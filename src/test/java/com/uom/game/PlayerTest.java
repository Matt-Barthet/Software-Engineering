package com.uom.game;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.*;

public class PlayerTest extends TestCase {
	protected Player player;
	private Map map;
	
	//Setting up the player
	protected void setup(){
		player = new Player(1,2,3);
	}
	
	//Testing returns 
	public void testGetX(){
		player = new Player(1,2,3);
		int ans = player.getPX();
		int expected = 2;
		
		assertTrue(expected == ans);
	}

	//Testing returns 
	public void testGetY(){
		player = new Player(1,2,3);
		int ans = player.getPY();
		int expected = 3;
		
		assertTrue(expected == ans);
	}
	
	//Testing movement up
	public void testMoveUp(){
		map = new Map(5);
		player = new Player(1,2,3);
		player.move(player,'u',5,map);
		int ansx = player.getPX();
		
		int expectedx = 1;
		assertTrue(expectedx == ansx);
	
	}
	
	//Testing movement down
	public void testMoveDown(){
		map = new Map(5);
		player = new Player(1,2,3);
		player.move(player,'d',5,map);
		int ansx = player.getPX();
		
		int expectedx = 3;
		assertTrue(expectedx == ansx);
	
	}
	
	//Testing movement left
	public void testMoveLeft(){
		map = new Map(5);
		player = new Player(1,2,3);
		player.move(player,'l',5,map);
		int ansx = player.getPY();
		
		int expectedx = 2;
		assertTrue(expectedx == ansx);
	
	}
	
	//Testing movement right
	public void testMoveRight(){
		map = new Map(5);
		player = new Player(1,2,3);
		player.move(player,'r',5,map);
		int ansx = player.getPY();
		
		int expectedx = 4;
		assertTrue(expectedx == ansx);
	
	}
	
	//Testing movement Failure
	public void testMoveFail(){
		map = new Map(5);
		player = new Player(1,2,3);
		player.move(player,'a',5,map);
		int ansy = player.getPY();
		int ansx = player.getPX();
		int expectedx = 2;
		int expectedy = 3;
		assertTrue(expectedx == ansx);
		assertTrue(expectedy == ansy);
	}
	
	//Testing returning starting positions after a player has moved
	public void testStartPos(){
		map = new Map(5);
		player = new Player(1,2,3);
		
		player.move(player,'u',5,map);
		player.move(player,'r',5,map);
		
		int ansy = player.getPY();
		int ansx = player.getPX();
		int expectedx = 1;
		int expectedy = 4;
		assertTrue(expectedx == ansx);
		assertTrue(expectedy == ansy);
		
		int starty = player.getPTY();
		int startx = player.getPTX();
		
		int expectedstx = 2;
		int expectedsty = 3;
		
		assertTrue(expectedstx == startx);
		assertTrue(expectedsty == starty);
	}

}