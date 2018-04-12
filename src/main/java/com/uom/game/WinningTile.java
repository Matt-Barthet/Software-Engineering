package com.uom.game;

public class WinningTile extends Tile {
	//Tile constructor
	public WinningTile(int x ,int y){
		super(x,y);
	}
	//Tile action goes here
	static boolean TileAction(int x ,int y,Tile t){
		return false;
	}
}