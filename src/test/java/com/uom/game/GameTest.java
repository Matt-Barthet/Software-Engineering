package com.uom.game;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.*;
import java.nio.file.*;
import java.nio.charset.*;

public class GameTest extends TestCase {
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
    
    //Testing that the right amount of players are created
    public void testPlayerAmount(){
        map = new Map(14);
        //Creating a game object which should contain
        //4 players with a 14x14 map size
        Game game = new Game (4, map);
        
        //expected number of players
        int expected = 4;
        //actual number of players
        int actual = game.player.length;
        
        assertTrue(expected == actual);
        
    }
    
    //Test to check that the right number of html files are being generated
    public void testHTMLGenerator(){
        map = new Map(14);
        int players = 4;
        
        //Creating a game object which should contain
        //4 players with a 14x14 map size
        Game game = new Game (players, map);
        
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
    
}