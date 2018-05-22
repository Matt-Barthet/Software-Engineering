package com.uom.game;

interface MapPlan{
	public void setTiles(int tile_no);
	
	public void setType(int map_type);
	
	public void createMap();
	
	public int returnTileAmount();
	
	public int return_map_type();
	
	public void setTile(Tile tile,int x,int y);
	
	public Tile getTile(int x ,int y);
	
}