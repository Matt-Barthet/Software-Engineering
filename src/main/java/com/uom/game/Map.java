package com.uom.game;

import java.util.Random;

public class Map {
	//Change to private later
	public Tile[][] tile;
	private int k = 0;
	private int n ;
	private GrassTile grass[];
	private WaterTile water[];
	private WinningTile win;
    public int winning_x, winning_y;
    
	Random rand  = new Random();
	//Create a map with n*n amount of tiles
	//This will have to randomly generate the type of tiles
	public Map(int n,int type){
		double temp_percent =0.0;
		if(type == 1 ){
			temp_percent = 0.10;
		}else if(type == 2){
			int temp_choice = rand.nextInt(1);
			if(temp_choice == 0){
				temp_percent = 0.25;
			}else{
				temp_percent = 0.35;
			}
			
		}
		this.n = n;
		int temp_water = 0;
		int temp_other =0;
		//Create the tiles and set them 
		tile = new Tile[n][n];
		grass = new GrassTile[n*n];
		water = new WaterTile[n*n];
		
		//Going through every tile randomly generate water or grass tiles
		for (int i = 0 ;i < n; i++){
			for (int j = 0 ;j < n; j++){
				double percent = rand.nextDouble();
				//Change the percentage to change the spawn rate of water tiles
				if(percent>=(1.0-temp_percent)){
					temp_water++;
					water[k] = new WaterTile(i,j);
					setTile(water[k],water[k].getX(),water[k].getY());
					k++;
				}else{
					temp_other++;
					grass[k] = new GrassTile(i,j);
					setTile(grass[k],grass[k].getX(),grass[k].getY());
					k++;
				}
			}
		}
		System.out.println("Water Tiles = " +temp_water+ " Other Tile"+temp_other);
		//Set a random position for the winning tile after all tiles are placed
		int x1 = rand.nextInt(n) + 0;
		int y1 = rand.nextInt(n) + 0;
        winning_x = x1;
        winning_y = y1;
		win  = new WinningTile(x1,y1);
		setTile(win,win.getX(),win.getY());
	}
    
	public int returnTileAmount(){
		return n;
	}
	//Sets the type of tile at the certain position
	public void setTile(Tile tile,int x,int y){
		this.tile[x][y]=tile;
	}
	//Returns the type of tile at that position
	public Tile getTile(int x ,int y){
		return tile[x][y];
	}
	
}