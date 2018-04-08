public class WinningTile extends Tile {
	//Tile constructor
	public WinningTile(String color, int x ,int y){
		super(color,x,y);
	}
	//Tile action goes here
	static boolean TileAction(String color , int x ,int y,Tile t){
		return false;
	}
}