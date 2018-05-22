package com.uom.game;


public class HazardMap implements MapBuilder{
	private GeneralMap generalmap;
	private static HazardMap instance = new HazardMap();
	private int tile_no;
	private int map_type;
	
	private HazardMap(){
	}
	
	public void MapGeneration(){
		this.generalmap = new GeneralMap();
	}
	
	public static HazardMap getInstance(){
		if(instance == null){
			instance = new HazardMap();
		}
		return instance;
	}
	

	public void buildTiles(int tile_no){
		generalmap.setTiles(tile_no);
	}
	
	public void buildType(int map_type){
		generalmap.setType(map_type);
	}
	
	public void buildMap(){
		generalmap.createMap();
	}
	
	public GeneralMap getMap(){
		return this.generalmap;
	}
}