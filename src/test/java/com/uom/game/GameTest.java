package com.uom.game;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.nio.charset.*;

public class GameTest  {
	private Player player;
	private Map map;
	private WaterTile water;
	private GrassTile grass;
	private WinningTile win;
	private Tile tile;
	
	/*
	//Done to test Singleton map
	@Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
       Field map = Map.class.getDeclaredField("instance");
       map.setAccessible(true);
       map.set(null, null);
    }
	
    //Testing that the right amount of players are created
    @Test
	public void testPlayerAmount(){
		
		Map map = Map.getInstance();
		map.GenerateMap(14,1);
        
		//map = new Map(14,1);
        //Creating a game object which should contain
        //4 players with a 14x14 map size
        Game game = new Game (4, map,1);
        
        //expected number of players
        int expected = 4;
        //actual number of players
        int actual = game.player.length;
        
        assertTrue(expected == actual);
        
    }
    
    //Test to check that the right number of html files are being generated
	@Test
    public void testHTMLGenerator(){
        Map map = Map.getInstance();
		map.GenerateMap(14,1);
        int players = 4;
        
        //Creating a game object which should contain
        //4 players with a 14x14 map size
        Game game = new Game (players, map, 1);
        
        boolean expected = true;
        
        for(int i = 0; i < players; i++){
            Path file = Paths.get("map_player_"+(i+1)+".html");
            if(Files.notExists(file)){
                expected = false;
            }
        }

        //if html files are as expected, return true
        assertTrue(expected);
    }
    
    //Test method to confirm whether a win is confirmed by the game loop
    @Test
	public void testWinCondition(){
       Map map = Map.getInstance();
		map.GenerateMap(14,1);
        int players = 4;
        
        //Creating a game object which should contain
        //4 players with a 14x14 map size
        Game game = new Game (players, map,1);
        
        assertTrue(game.game_won == false);
        
    }
    
    //Test to check whether the tiles uncover if a player is placed on them
    @Test
	public void testUncover(){
        Map map = Map.getInstance();
		map.GenerateMap(14,1);
        int players = 4;
        
        //Creating a game object which should contain
        //4 players with a 14x14 map size
        Game game = new Game (players, map,1);
        
        //check if the uncovered length is equal to two as player was moved
        //twice in the test case created in the previous test
        assertTrue(game.player[0].uncovered.size() == 2);
        
    }
	*/
    
}