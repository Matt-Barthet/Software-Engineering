package com.uom.game;

//Map Engineer that creates the map
public class MapEngineer{
	private MapBuilder mapbuilder;
	
	//sets the current map builder to be used to make this map
	public MapEngineer(MapBuilder mapbuilder){
		this.mapbuilder = mapbuilder;
	}
	//Returns the map that was built
	public GeneralMap getMap(){
		return this.mapbuilder.getMap();
	}
	//Constructs the map with the amount of tiles and it's type
	public void constructMap(int tile_no,int map_type){
		this.mapbuilder.MapGeneration();
		this.mapbuilder.buildTiles(tile_no);
		this.mapbuilder.buildType(map_type);
		this.mapbuilder.buildMap();
	}
}
