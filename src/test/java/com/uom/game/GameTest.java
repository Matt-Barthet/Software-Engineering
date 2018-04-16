package com.uom.game;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.*;

public class GameTest extends TestCase {
	private Game game;
	private GrassTile grass;
	private Player player[];
	private Map map;
	
	//Setting up the Game
	protected void setup(){
		game = new Game(3,10);
	}
	/*
	//Testing the game loop
	public void testGameLoop(){
		game = new Game(3,10);
		boolean ans = game.winGame(3,player,map,10);
		boolean expected = true;
		assertTrue(expected == ans);
	}*/
	
	//This checks if the players spawned on a grass tile or not
	public void testNumPlay(){
		map = new Map(10);
		game.setNumPlayers(3,10,map);
		
		for(int i = 0;i<3 ;i++){
			Tile ans = map.getTile(player[0].getPX(),player[0].getPY());
			Tile expected = grass;
			assertTrue(expected == ans);
		}
	}
	
	
}