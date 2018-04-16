package com.uom.game;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.*;

public class MapTest extends TestCase {
	private Player player;
	private Map map;
	private WaterTile water;
	private GrassTile grass;
	private WinningTile win;
	private Tile tile;
	
	//Setting up the map
	protected void setup(){
		map = new Map(14);
	}
	//Testing the return on the tile amounts
	public void testAmountReturn(){
		map = new Map(14);
		int ans = map.returnTileAmount();
		int expected = 14;
		
		assertTrue(expected == ans);
	}
	//Testing the tile setting for the water tiles
	public void testWaterTile(){
		map = new Map(14);
		water = new WaterTile(2,2);
		map.setTile(water,2,2);
		Tile ans = map.getTile(2 ,2);
		Tile expected = water;
		
		assertTrue(expected == ans);
	}
	
	//Testing the tile setting for the grass tiles
	public void testGrassTile(){
		map = new Map(14);
		grass = new GrassTile(3,3);
		map.setTile(grass,3,3);
		Tile ans = map.getTile(3 ,3);
		Tile expected = grass;
		
		assertTrue(expected == ans);
	}
	
	//Testing the tile setting for the winning tile
	public void testWinTile(){
		map = new Map(14);
		win = new WinningTile(4,4);
		map.setTile(win,4,4);
		Tile ans = map.getTile(4 ,4);
		Tile expected = win;
		
		assertTrue(expected == ans);
	}

}