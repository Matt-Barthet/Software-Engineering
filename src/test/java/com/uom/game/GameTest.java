package com.uom.game;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.Arrays;

public class GameTest  {
	private Player player;
	private GeneralMap map;
	private SafeMap map_1;
	private HazardMap map_2;
	private MapEngineer map_engineer;
	private WaterTile water;
	private GrassTile grass;
	private WinningTile win;
	private Tile tile;
	

	//Done to test Singleton map
	@Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
       Field map = Map.class.getDeclaredField("instance");
       map.setAccessible(true);
       map.set(null, null);
    }
    //Testing that the right amount of players are created
    @Test
	public void testPlayerAmountSafe(){
		int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Safe Map Instance
		SafeMap map_1 = SafeMap.getInstance();
		map_engineer = new MapEngineer(map_1);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
        //Creating a game object which should contain
        //4 players with a 14x14 map size
        Game game = new Game (players, map);
        
        //expected number of players
        int expected = 4;
        //actual number of players
        int actual = game.player.length;
        
        assertTrue(expected == actual);
        
    }
	//Testing the Hazard Map Setting players
	@Test
	public void testPlayerAmountHazard(){
		int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Hazard Map Instance
		HazardMap map_2 = HazardMap.getInstance();
		map_engineer = new MapEngineer(map_2);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
        //Creating a game object which should contain
        //4 players with a 14x14 map size
        Game game = new Game (players, map);
        
        //expected number of players
        int expected = 4;
        //actual number of players
        int actual = game.player.length;
        
        assertTrue(expected == actual);
    }

    //Test to check that the right number of html files are being generated
	@Test
    public void testHTMLGeneratorSafe(){
        int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Safe Map Instance
		SafeMap map_1 = SafeMap.getInstance();
		map_engineer = new MapEngineer(map_1);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
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
    
    //Test method to confirm whether a win is confirmed by the game loop
    @Test
	public void testWinConditionSafe(){
        int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Safe Map Instance
		SafeMap map_1 = SafeMap.getInstance();
		map_engineer = new MapEngineer(map_1);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
        //Creating a game object which should contain
        //4 players with a 14x14 map size
        Game game = new Game (players, map);
        
        assertTrue(game.game_won == false);
        
    }
    
    //Test to check whether the tiles uncover if a player is placed on them
    @Test
	public void testUncoverSafe(){
        int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Safe Map Instance
		SafeMap map_1 = SafeMap.getInstance();
		map_engineer = new MapEngineer(map_1);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
        
        //Creating a game object which should contain
        //4 players with a 14x14 map size
        Game game = new Game (players, map);
        
        //check if the uncovered length is equal to two as player was moved
        //twice in the test case created in the previous test
        assertTrue(game.player[0].observer_state.size() == 2);
        
    }
	
	
	//Test to check that the right number of html files are being generated
	@Test
    public void testHTMLGeneratorHazard(){
       int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Hazard Map Instance
		HazardMap map_2 = HazardMap.getInstance();
		map_engineer = new MapEngineer(map_2);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
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
    
    //Test method to confirm whether a win is confirmed by the game loop
    @Test
	public void testWinConditionHazard(){
        int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Hazard Map Instance
		HazardMap map_2 = HazardMap.getInstance();
		map_engineer = new MapEngineer(map_2);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
        //Creating a game object which should contain
        //4 players with a 14x14 map size
        Game game = new Game (players, map);
        
        assertTrue(game.game_won == false);
        
    }
    
    //Test to check whether the tiles uncover if a player is placed on them
    @Test
	public void testUncoverHazard(){
       int tiles = 14;
		int players = 4;
		int type = 1;
		//Testing with a Hazard Map Instance
		HazardMap map_2 = HazardMap.getInstance();
		map_engineer = new MapEngineer(map_2);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
        //Creating a game object which should contain
        //4 players with a 14x14 map size
        Game game = new Game (players, map);
        
        //check if the uncovered length is equal to two as player was moved
        //twice in the test case created in the previous test
        assertTrue(game.player[0].observer_state.size() == 2);
        
    }
    
    @Test
    public void testTeamObservation(){
        int tiles = 14;
		int players = 4;
		int type = 1;
        int no_of_teams = 2;
        
        HazardMap map_2 = HazardMap.getInstance();
		map_engineer = new MapEngineer(map_2);
		map_engineer.constructMap(tiles,type);
        map = map_engineer.getMap();
        
        Game game = new Game(players, map, no_of_teams);
        
        boolean correct = false;
        
        //Checks if the player's uncovered states corresponds to the team's
        if(game.player[0].observer_state.equals( game.team_uncovered[game.player[0].team_number-1].get_state())){
            correct = true;
        }
        
        assertTrue(correct == true);
    }
    
    

}