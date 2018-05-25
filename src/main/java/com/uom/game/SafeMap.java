package com.uom.game;


public class SafeMap implements MapBuilder{
	private GeneralMap generalmap;
	private static SafeMap instance = new SafeMap();
	private int tile_no;
	private int map_type;
	
	private SafeMap(){}
	
	public void MapGeneration(){
		this.generalmap = new GeneralMap();
	}
	
	public static SafeMap getInstance(){
		if(instance == null){
			instance = new SafeMap();
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