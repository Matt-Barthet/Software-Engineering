package com.uom.game;

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
		showMap(map,n);
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