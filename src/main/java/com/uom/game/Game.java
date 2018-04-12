package com.uom.game;

import static j2html.TagCreator.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.Random;

public class Game {
	private PlayerTile playertile[];
	Random rand  = new Random();
	//Has passing parameters for the game no of players and board size
	//This will create the map and the html table
	public Game(int players,int n){
		Map map = new Map(n);
		playertile = new PlayerTile[n];
		setNumPlayers(players,n,map);
		generateHTMLMap(n, map);
	}
	
	//This should also check if the player is being set on a grass tile or not
	public void setNumPlayers(int players,int n,Map map){
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
			//Create if player is spawned on a grass tile
			Player player = new Player(i,x1,y1);
			playertile[i] = new PlayerTile(x1,y1);
			map.setTile(playertile[i],playertile[i].getX(),playertile[i].getY());
		}
	}
    
    public static void generateHTMLMap(int map_size, Map map){
        
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
        lines.add(h2("Player 1" /*+ String.valueOf(player.getPN())*/).render());
        
        //HTML Code for table
        lines.add("<table>");
        
        for (int i = 0; i < map_size; i++){
            //Each iteration adds a row
            lines.add("<tr>");
            for(int j = 0; j < map_size; j++){
                //Each iteration adds a cell
                
                String tile_type = "";
                
                if(map.getTile(i,j) instanceof  WaterTile){
					tile_type = ".water_tile";
				}else if(map.getTile(i,j) instanceof GrassTile){
					tile_type = ".green_tile";
				}else if(map.getTile(i,j)  instanceof  WinningTile){
					tile_type = ".winning_tile";
				}else if(map.getTile(i,j) instanceof PlayerTile){
					tile_type = ".player_tile";
				}else if(map.getTile(i,j)==null){
					tile_type = ".grey_tile";
				}else{
					System.out.print(" ER ");
				}
                
                
                lines.add(td(attrs(tile_type)).render());
            }
            lines.add("</tr>");
        }
        
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
        lines.add("     .winning_tile{ background-color: gold}");
        lines.add("     .player_tile{ background-color: black}");
        lines.add("</style>");
        
        //Try catch block to write html to a file
        try{
        Path file = Paths.get("template2.html");
        Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (Exception e){}
    }
	//Temporary function to output the map created on the console
	public static void showMap(Map map,int n){
		for(int i = 0;i<n;i++){
			for(int j = 0; j<n;j++){
				if(map.getTile(i,j) instanceof  WaterTile){
					System.out.print(" WT ");
				}else if(map.getTile(i,j) instanceof GrassTile){
					System.out.print(" GT ");
				}else if(map.getTile(i,j)  instanceof  WinningTile){
					System.out.print(" WW ");
				}else if(map.getTile(i,j) instanceof PlayerTile){
					System.out.print(" PP ");
				}else if(map.getTile(i,j)==null){
					System.out.print(" __ ");
				}else{
					System.out.print(" ER ");
				}
			}
			System.out.println();	
		}
	}
	
}