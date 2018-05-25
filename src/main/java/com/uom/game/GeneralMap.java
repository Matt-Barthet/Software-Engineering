package com.uom.game;

import java.util.Random;

public class GeneralMap implements MapPlan{
	
	private int tile_no;
	private int n;
	private int map_type;
	private int k = 0;
	private GrassTile grass[];
	private WaterTile water[];
	private WinningTile win;
	public Tile[][] tile;
    public int winning_x, winning_y;
	private GeneralMap generalmap;
	
	Random rand  = new Random();
	//General map setter
	public GeneralMap(){
		this.generalmap = generalmap;
	}

	//Setting the type
	public void setType(int map_type){
		this.map_type = map_type;
	}
	//Setting the tiles
	public void setTiles(int tile_no){
		this.n = tile_no;
	}
	//Returns the amount of tiles generated
	public int returnTileAmount(){
		return n;
	}
	public int return_map_type(){
		return map_type;
	}
	//Sets the type of tile at the certain position
	public void setTile(Tile tile,int x,int y){
		this.tile[x][y]=tile;
	}
	//Returns the type of tile at that position
	public Tile getTile(int x ,int y){
		return tile[x][y];
	}
	//Creating the map
	public void createMap() throws RuntimeException{
		double temp_percent =0.0;
		if(map_type == 1 ){
			temp_percent = 0.10;
		}else if(map_type == 2){
			//Random Choice of map between 25% and 35% water
			int temp_choice = rand.nextInt(1);
			if(temp_choice == 0){
				temp_percent = 0.25;
			}else{
				temp_percent = 0.35;
			}	
		}else{
			throw new RuntimeException("Invalid Input please Choose 1 : Safe or 2 : Hazard");
		}
		
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
					water[k] = new WaterTile(i,j);
					setTile(water[k],water[k].getX(),water[k].getY());
					k++;
				}else{
					grass[k] = new GrassTile(i,j);
					setTile(grass[k],grass[k].getX(),grass[k].getY());
					k++;
				}
			}
		}
		//Set a random position for the winning tile after all tiles are placed
		int x1 = rand.nextInt(n) + 0;
		int y1 = rand.nextInt(n) + 0;
        winning_x = x1;
        winning_y = y1;
		win  = new WinningTile(x1,y1);
		setTile(win,win.getX(),win.getY());	
	}
}