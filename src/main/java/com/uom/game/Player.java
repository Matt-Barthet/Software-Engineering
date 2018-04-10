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
	public void move(Player player,char direction){
		switch(direction){
			case 'u': x = player.getPX()-1;
					break;	
			case 'd': x = player.getPX()+1;
					break;
			case 'l': y = player.getPY()-1;
					break;
			case 'r': y = player.getPY()+1;
					break;
			default : break;
		}
	}
	//Returns player to the original position
	public void moveOriginal(){
		x = temp_x;
		y = temp_y;
	}
	
}