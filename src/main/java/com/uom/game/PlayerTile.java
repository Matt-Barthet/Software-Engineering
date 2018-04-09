public class PlayerTile extends Tile {
	//Tile constructor
	public PlayerTile(int x ,int y){
		super(x,y);
	}
	//Tile action goes here
	static boolean TileAction( int x ,int y,Tile t){
		return false;
	}
}