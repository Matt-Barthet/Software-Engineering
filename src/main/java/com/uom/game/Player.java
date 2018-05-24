package com.uom.game;

import java.util.*;
import java.lang.Math;

//Player Objecy
public class Player extends Observer_Class{
	private int x ,y ,n;
	private int temp_x , temp_y;
    int team_number = 0;
    public List<Tile> uncovered = new ArrayList<Tile>();
    
	//Player constructor sets the number of the player and his position
	public Player(int n,int x,int y){
		this.n = n;
		this.x = x;
		this.y = y;
		this.temp_x = x;
		this.temp_y = y;
	}
	public int getPTX(){
		 return temp_x;
	}
	public int getPTY(){
		return temp_y;
	}
	//retrieves x coordinate of a player
	public int getPX(){
		return x;
	}
	//retrieves y coordinate of a player
	public int getPY(){
		return y;
	}
	//retrieves the player number
	public int getPN(){
		return n;
	}
    
    public void setPXPY(int px, int py){
        x = px; y = py;
    }
    
	//Changes the position of the player
	//Also map limits set so player doesnt move out of map
	public void move(Player player,char direction,int n, Map map){
		switch(direction){
			case 'u':if((player.getPX()-1)<=0){
						x = 0;
                        //Add uncovered to player's uncovered list
                        observer_state.add(map.getTile(player.getPX(), player.getPY()));
						break;
					}else{
						x = player.getPX()-1;
                        observer_state.add(map.getTile(player.getPX(), player.getPY()));
						break;
					}
			case 'd':if((player.getPX()+1)>=n){
						x = n-1;
                        observer_state.add(map.getTile(player.getPX(), player.getPY()));
						break;
					}else{
						x = player.getPX()+1;
                        observer_state.add(map.getTile(player.getPX(), player.getPY()));
						break;
					}
			case 'l': if((player.getPY()-1)<=0){
						y = 0;
                        observer_state.add(map.getTile(player.getPX(), player.getPY()));
						break;
					}else{
						y = player.getPY()-1;
                        observer_state.add(map.getTile(player.getPX(), player.getPY()));
						break;
					}
			case 'r': if((player.getPY()+1)>=n){
						y = n-1;
                        observer_state.add(map.getTile(player.getPX(), player.getPY()));
						break;
					}else{
						y = player.getPY()+1;
                        observer_state.add(map.getTile(player.getPX(), player.getPY()));
						break;
					}
			default : break;
		}
	}
	//Returns player to the original position
	public void moveOriginal(){
		x = temp_x;
		y = temp_y;
	}
    
    public void set_team(int no_of_teams){
        team_number = (int)(Math.random()* no_of_teams + 1);
        
    }
	
}