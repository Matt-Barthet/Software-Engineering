package com.uom.game;

//Player Objecy
public class Player{
	private int x ,y ,n;
	public int temp_x , temp_y;
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
	//Changes the position of the player
	//Also map limits set so player doesnt move out of map
	public void move(Player player,char direction,int n){
		switch(direction){
			case 'u':if((player.getPX()-1)<=0){
						x = 0;
						break;
					}else{
						x = player.getPX()-1;
						break;
					}
			case 'd':if((player.getPX()+1)>=n){
						x = n-1;
						break;
					}else{
						x = player.getPX()+1;
						break;
					}
			case 'l': if((player.getPY()-1)<=0){
						y = 0;
						break;
					}else{
						y = player.getPY()-1;
						break;
					}
			case 'r': if((player.getPY()+1)>=n){
						y = n-1;
						break;
					}else{
						y = player.getPY()+1;
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
	
}