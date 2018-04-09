//Player Objecy
public class Player{
	private int x ,y ,n;
	//Player constructor sets the number of the player and his position
	public Player(int n,int x,int y){
		this.n = n;
		this.x = x;
		this.y = y;
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
	public void move(int x,int y,char direction){
		switch(direction){
			case 'u': this.x = x++;
			case 'd': this.x = x--;
			case 'l': this.y = y++;
			case 'r': this.y = y--;
			default : break;
		}
	}
}