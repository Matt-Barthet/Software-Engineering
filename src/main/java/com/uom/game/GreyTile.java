package com.uom.game;

public class GreyTile extends Tile {
	//Tile constructor
	public GreyTile(int x ,int y){
		super(x,y);
	}
	//Tile action goes here
	static boolean TileAction(int x ,int y,Tile t){
		return false;
	}
}