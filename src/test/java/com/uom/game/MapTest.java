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
	private GeneralMap map;
	private SafeMap map_1;
	private HazardMap map_2;
	private MapEngineer map_engineer;

	//Done to test Singleton map
	@Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
       Field map = Map.class.getDeclaredField("instance");
       map.setAccessible(true);
       map.set(null, null);
    }
	//Testing the return on the tile amounts
	@Test
	public void testAmountReturnSafe(){
		int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Safe Map Instance
		SafeMap map_1 = SafeMap.getInstance();
		map_engineer = new MapEngineer(map_1);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();

		int ans = map.returnTileAmount();
		int expected = 14;
		assertTrue(expected == ans);
	}

	//Testing the return on the tile type
	@Test
	public void testMapTypeSafe(){
		int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Safe Map Instance
		SafeMap map_1 = SafeMap.getInstance();
		map_engineer = new MapEngineer(map_1);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
		
		int ans = map.return_map_type();
		
		int expected = 1;
		
		assertTrue(expected == ans);
	}
	//Testing the tile setting for the water tiles
	@Test
	public void testWaterTileSafe(){
		int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Safe Map Instance
		SafeMap map_1 = SafeMap.getInstance();
		map_engineer = new MapEngineer(map_1);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
		
		water = new WaterTile(2,2);
		map.setTile(water,2,2);
		Tile ans = map.getTile(2 ,2);
		Tile expected = water;
		
		assertTrue(expected == ans);
	}
	
	//Testing the tile setting for the grass tiles
	@Test
	public void testGrassTileSafe(){
		int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Safe Map Instance
		SafeMap map_1 = SafeMap.getInstance();
		map_engineer = new MapEngineer(map_1);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
		
		grass = new GrassTile(3,3);
		map.setTile(grass,3,3);
		Tile ans = map.getTile(3 ,3);
		Tile expected = grass;
		
		assertTrue(expected == ans);
	}
	
	//Testing the tile setting for the winning tile
	@Test
	public void testWinTileSafe(){
		int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Safe Map Instance
		SafeMap map_1 = SafeMap.getInstance();
		map_engineer = new MapEngineer(map_1);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
		
		win = new WinningTile(4,4);
		map.setTile(win,4,4);
		Tile ans = map.getTile(4 ,4);
		Tile expected = win;
		
		assertTrue(expected == ans);
	}
	//Testing the return on the tile amounts
	@Test
	public void testAmountReturnHazard(){
		int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Hazard Map Instance
		HazardMap map_2 = HazardMap.getInstance();
		map_engineer = new MapEngineer(map_2);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();

		int ans = map.returnTileAmount();
		int expected = 14;
		assertTrue(expected == ans);
	}

	//Testing the return on the tile type
	@Test
	public void testMapTypeHazard(){
		int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Hazard Map Instance
		HazardMap map_2 = HazardMap.getInstance();
		map_engineer = new MapEngineer(map_2);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
		
		int ans = map.return_map_type();
		
		int expected = 1;
		
		assertTrue(expected == ans);
	}
	//Testing the tile setting for the water tiles
	@Test
	public void testWaterTileHazard(){
		int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Hazard Map Instance
		HazardMap map_2 = HazardMap.getInstance();
		map_engineer = new MapEngineer(map_2);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
		
		water = new WaterTile(2,2);
		map.setTile(water,2,2);
		Tile ans = map.getTile(2 ,2);
		Tile expected = water;
		
		assertTrue(expected == ans);
	}
	
	//Testing the tile setting for the grass tiles
	@Test
	public void testGrassTileHazard(){
		 int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Hazard Map Instance
		HazardMap map_2 = HazardMap.getInstance();
		map_engineer = new MapEngineer(map_2);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
		
		grass = new GrassTile(3,3);
		map.setTile(grass,3,3);
		Tile ans = map.getTile(3 ,3);
		Tile expected = grass;
		
		assertTrue(expected == ans);
	}
	
	//Testing the tile setting for the winning tile
	@Test
	public void testWinTileHazard(){
		 int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Hazard Map Instance
		HazardMap map_2 = HazardMap.getInstance();
		map_engineer = new MapEngineer(map_2);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
		
		win = new WinningTile(4,4);
		map.setTile(win,4,4);
		Tile ans = map.getTile(4 ,4);
		Tile expected = win;
		
		assertTrue(expected == ans);
	}
	
}