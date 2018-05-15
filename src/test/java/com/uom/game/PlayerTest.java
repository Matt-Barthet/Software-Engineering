package com.uom.game;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PlayerTest {
	protected Player player;
	private Map map;
	/*
	//Done to test Singleton map
	@Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
       Field map = Map.class.getDeclaredField("instance");
       map.setAccessible(true);
       map.set(null, null);
    }
	//Setup
	public void setup(){
		Map map = Map.getInstance();
	    map.GenerateMap(5,1);
	}
	//Testing returns 
	@Test
	public void testGetX(){
		player = new Player(1,2,3);
		int ans = player.getPX();
		int expected = 2;
		
		assertTrue(expected == ans);
	}
	
	//Testing returns 
	@Test
	public void testGetY(){
		player = new Player(1,2,3);
		int ans = player.getPY();
		int expected = 3;
		
		assertTrue(expected == ans);
	}
	
	//Testing movement up
	@Test
	public void testMoveUp(){
		setup();
		player = new Player(1,2,3);
		player.move(player,'u',5,map);
		int ansx = player.getPX();
		
		int expectedx = 1;
		assertTrue(expectedx == ansx);
	
	}

	//Testing movement down
	@Test
	public void testMoveDown(){
		setup();
		player = new Player(1,2,3);
		player.move(player,'d',5,map);
		int ansx = player.getPX();
		
		int expectedx = 3;
		assertTrue(expectedx == ansx);
	
	}
	
	//Testing movement left
	@Test
	public void testMoveLeft(){
		setup();
		player = new Player(1,2,3);
		player.move(player,'l',5,map);
		int ansx = player.getPY();
		
		int expectedx = 2;
		assertTrue(expectedx == ansx);
	
	}
	
	//Testing movement right
	@Test
	public void testMoveRight(){
		setup();
		player = new Player(1,2,3);
		player.move(player,'r',5,map);
		int ansx = player.getPY();
		
		int expectedx = 4;
		assertTrue(expectedx == ansx);
	
	}
	
	//Testing movement Failure
	@Test
	public void testMoveFail(){
		setup();
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
	@Test
	public void testStartPos(){
		setup();
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
	*/

}