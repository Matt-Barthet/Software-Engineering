package com.uom.game;

public class MapEngineer{
	private MapBuilder mapbuilder;
	
	public MapEngineer(MapBuilder mapbuilder){
		this.mapbuilder = mapbuilder;
	}

	public GeneralMap getMap(){
		return this.mapbuilder.getMap();
	}
	
	public void constructMap(int tile_no,int map_type){
		this.mapbuilder.MapGeneration();
		this.mapbuilder.buildTiles(tile_no);
		this.mapbuilder.buildType(map_type);
		this.mapbuilder.buildMap();
	}
}
