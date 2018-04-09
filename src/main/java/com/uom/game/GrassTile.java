package com.uom.game;

public class GrassTile extends Tile {
	//Tile constructor
	public GrassTile(int x ,int y){
		super(x,y);
	}
	//Tile action goes here
	static boolean TileAction( int x ,int y,Tile t){
		return false;
	}
}