package com.uom.game;

import static j2html.TagCreator.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public Player player[];
    public boolean game_won;
    
	Scanner reader = new Scanner(System.in);
	Random rand  = new Random();
	//Has passing parameters for the game no of players and board size
	//This will create the map and the html table
    
	public Game(int players,int n,int map_type){
		Map map = new Map(n,map_type);
		setNumPlayers(players,n,map);
		winGame(players,player,map, n);
	}
    
    //constructor to create game for testing purposes
    public Game(int players, Map map,int map_type){
        //set number of players accordingly
        setNumPlayers(players, map.returnTileAmount(), map);
        
        //place player 1 straight onto winning tile for testing purposes
        player[0].setPXPY(map.winning_x, map.winning_y);
        
        player[0].uncovered.add( map.getTile(map.winning_x, map.winning_y));
        
        //store whether the game completed successfully here
        game_won = winGame(players, player, map, map.returnTileAmount());
    }
    
	//Gaming loop keeps playing until game is won 
	public boolean winGame(int players, Player player[], Map map, int n){
		
        char [] directions = new char [9];
        
        while(true){
          
            int i = 0;

            for(i = 0; i < players; i++){
                //Win ends the game and returns the winning player
                if(map.getTile(player[i].getPX() ,player[i].getPY()) instanceof WinningTile ){
                    System.out.println("Congratulations, the winner is Player "+(player[i].getPN()+1));
                    return false;
                }               
            }
            
            System.out.println("\nCollecting Moves:");
            
            for(i = 0; i < players ; i++){
                System.out.println("Player "+(player[i].getPN()+1)+": Turn Choose direction");
				directions [i] = reader.next().charAt(0);   
            }
            
            System.out.println("\nExecuting Moves and Generating HTML Files:");
            
			for(i = 0; i < players ; i++){
                
                //move player
				player[i].move(player[i],directions[i],map.returnTileAmount(), map);
                
                //Add uncovered to player's uncovered list
                player[i].uncovered.add( map.getTile(player[i].getPX(), player[i].getPY()));
                
				//System.out.println("Player , "+(player[i].getPN()+1)+" At X "+player[i].getPX()+ " and Y : "+player[i].getPY());
                
				//Death sets player back to his spawn point
				if(map.getTile(player[i].getPX() ,player[i].getPY()) instanceof WaterTile){
					player[i].moveOriginal();
				} 
                
                //At the end of each turn generate HTML Map
                generateHTMLMap(player[i], n, map);
                
			}
		}

	}
    
	//This should also check if the player is being set on a grass tile or not
	public void setNumPlayers(int players,int n,Map map){
		player = new Player[players];
		for(int i = 0 ; i < players;i++){
			int x1 = rand.nextInt(n) + 0;
			int y1 = rand.nextInt(n) + 0;
            
			if(!(map.getTile(x1,y1) instanceof GrassTile)){
				//Continue randomizing the spawn until its a grass tile
				while(!(map.getTile(x1,y1) instanceof GrassTile)){
						x1 = rand.nextInt(n) + 0;
						y1 = rand.nextInt(n) + 0;
				}
			}
			//System.out.println("x :"+x1+" y : "+y1);

			//Create if player is spawned on a grass tile
			player[i] = new Player(i,x1,y1);
            
            player[i].uncovered.add( map.getTile(player[i].getPX(), player[i].getPY()));
            
            generateHTMLMap(player[i], n, map);
		}
	}

    
    public static void generateHTMLMap(Player player, int map_size, Map map){
        
        //Creating arraylist for storing lines of html which will be written to a file
        List <String> lines = new ArrayList<String>();
        
        //Add the title to the webpage
        lines.add( 
            head(
                title("Treasure Map")   
            ).render()
        );
        
        List <Integer> numbers = new ArrayList<Integer>();
        
        for (int i = 0; i < map_size; i++){
            numbers.add(i + 1);
        }
        
        lines.add("<body>");
        
        //Adding Titles
        lines.add(h1("Treasure Map").render());
        lines.add(h2("Player " + String.valueOf(player.getPN()+1)).render());
        
        //HTML Code for table
        lines.add("<table>");
        
        for (int i = 0; i < map_size; i++){
            //Each iteration adds a row
            lines.add("<tr>");
            for(int j = 0; j < map_size; j++){
                //Each iteration adds a cell
                
                //tile type placeholder
                String tile_type = "";
                
                //is tile uncovered?
                boolean uncovered_bool = false;
                
                //if tile is found in player's uncovered list, set to true
                for(int k = 0; k < player.uncovered.size(); k++){
                    if((player.uncovered).contains(map.getTile(i,j))){
                        uncovered_bool = true;
                    }
                }
                
                //if the tile is covered for this player, show gray tile
                if(!uncovered_bool){
					tile_type = ".gray_tile";
				}else{
                    //show respective tile otherwise
                    if(player.getPX() == i && player.getPY() == j){
                        tile_type = ".player_tile";
                    }
                    if(map.getTile(i,j) instanceof  WaterTile){
                        tile_type += ".water_tile";
                    }else if(map.getTile(i,j) instanceof GrassTile){
                        tile_type += ".green_tile";
                    }else if(map.getTile(i,j)  instanceof  WinningTile){
                        tile_type += ".winning_tile";
                    }
                    
                }

                //add the tile according to what type in the html table
                lines.add(td(attrs(tile_type)).render());
            }
            lines.add("</tr>");
        }
        lines.add("</table>");
        lines.add("</body>");
        //CSS code for the webpage
        lines.add("\n<style data-brackets-id='28976'>");
        lines.add("     table, th, td{ border-collapse: collapse; margin-left: auto; margin-right: auto; border: 1px solid black; }");
        lines.add("     table { table-layout: fixed; width: 80%; height: 70%; }");
        lines.add("     td { text-align: center; }");
        lines.add("     img{ width: 100%; height: 100%;}");
        lines.add("     h2 { padding-left: 10%;}");
        lines.add("     h1{ padding-left: 42.5%; margin-top:2%}");
        lines.add("     .green_tile{ background-color: greenyellow}");
        lines.add("     .gray_tile{ background-color: gray}");
        lines.add("     .water_tile{ background-color: skyblue}");
        lines.add("     .player_tile.green_tile{ background-image: url(player.png); background-repeat: no-repeat; background-size: contain; background-position: center; background-color: greenyellow}");
        lines.add("     .player_tile.winning_tile{ background-image: url(player.png); background-repeat: no-repeat; background-size: contain; background-position: center; background-color: gold}");
        lines.add("</style>");
        
        //Try catch block to write html to a file
        try{
        Path file = Paths.get("map_player_"+ String.valueOf(player.getPN()+1)+".html");
        Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (Exception e){}
    }
	
}