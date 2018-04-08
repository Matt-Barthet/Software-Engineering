public class GrassTile extends Tile {
	//Tile constructor
	public GrassTile(String color, int x ,int y){
		super(color,x,y);
	}
	//Tile action goes here
	static boolean TileAction(String color , int x ,int y,Tile t){
		return false;
	}
}