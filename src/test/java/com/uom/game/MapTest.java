package com.uom.game;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MapTest{
	private Player player;
	private WaterTile water;
	private GrassTile grass;
	private WinningTile win;
	private Tile tile;
	private Map map;
	/*
	//Done to test Singleton map
	@Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
       Field map = Map.class.getDeclaredField("instance");
       map.setAccessible(true);
       map.set(null, null);
    }
	//Testing the return on the tile amounts
	@Test
	public void testAmountReturn(){
		Map map = Map.getInstance();
	    map.GenerateMap(14,1);
		int ans = map.returnTileAmount();
		int expected = 14;
		System.out.println("RETURNING AMOUTN OF TILES"+ans);
		assertTrue(expected == ans);
	}
	
	//Testing the return on the tile type
	@Test
	public void testMapType(){
		
		Map map = Map.getInstance();
	    map.GenerateMap(14,1);
		int ans = map.return_map_type();
		System.out.println("RETURNING TYPE OF MAP"+ans);
		int expected = 1;
		
		assertTrue(expected == ans);
	}
	//Testing the tile setting for the water tiles
	@Test
	public void testWaterTile(){
		
		Map map = Map.getInstance();
	    map.GenerateMap(14,1);
		water = new WaterTile(2,2);
		map.setTile(water,2,2);
		Tile ans = map.getTile(2 ,2);
		Tile expected = water;
		
		assertTrue(expected == ans);
	}
	
	//Testing the tile setting for the grass tiles
	@Test
	public void testGrassTile(){
		
		Map map = Map.getInstance();
	    map.GenerateMap(14,1);
		grass = new GrassTile(3,3);
		map.setTile(grass,3,3);
		Tile ans = map.getTile(3 ,3);
		Tile expected = grass;
		
		assertTrue(expected == ans);
	}
	
	//Testing the tile setting for the winning tile
	@Test
	public void testWinTile(){
		
		Map map = Map.getInstance();
	    map.GenerateMap(14,1);
		win = new WinningTile(4,4);
		map.setTile(win,4,4);
		Tile ans = map.getTile(4 ,4);
		Tile expected = win;
		
		assertTrue(expected == ans);
	}
	*/
}