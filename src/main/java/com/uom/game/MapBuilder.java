package com.uom.game;

//Map Builder Blue print
interface MapBuilder{
	public void MapGeneration();
	
	public void buildTiles(int tile_no);
	
	public void buildType(int map_type);
	
	public void buildMap();

	public GeneralMap getMap();
}