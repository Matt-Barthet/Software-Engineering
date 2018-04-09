public abstract class Tile {
	private int x;
	private int y;
	
	//Tile constructor
	public Tile( int x ,int y){
		this.x = x;
		this.y = y;
	}
	//retrieves x coordinate of a tile
	public int getX(){
		return x;
	}
	//retrieves y coordinate of a tile
	public int getY(){
		return y;
	}
	//Maybe change return type of polymorphed function
	static boolean TileAction( int x ,int y,Tile tile){
		return tile.TileAction(x ,y,tile);
	}
}