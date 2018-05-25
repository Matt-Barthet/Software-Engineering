package com.uom.game;

//Hazard map uses general map
public class HazardMap implements MapBuilder{
	private GeneralMap generalmap;
	private static HazardMap instance = new HazardMap();
	private int tile_no;
	private int map_type;
	//Private Hazard Map so that multiple ones can't be created SINGLETON purpose
	private HazardMap() throws RuntimeException{
		throw new RuntimeException("Can't Call Private Constructor");
	}
	//Generates Map
	public void MapGeneration(){
		this.generalmap = new GeneralMap();
	}
	//Returns a new instance , creates one if there isn't
	public static HazardMap getInstance(){
		if(instance == null){
			instance = new HazardMap();
		}
		return instance;
	}
	//Sets the amount of tiles in map
	public void buildTiles(int tile_no){
		generalmap.setTiles(tile_no);
	}
	//Setting the type of map to be built 
	public void buildType(int map_type){
		generalmap.setType(map_type);
	}
	//Creating the map
	public void buildMap(){
		generalmap.createMap();
	}
	//Retruning the map 
	public GeneralMap getMap(){
		return this.generalmap;
	}
}