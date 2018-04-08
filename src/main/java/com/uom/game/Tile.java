public abstract class Tile {
	private int x;
	private int y;
	private String color;
	
	//Tile constructor
	public Tile(String color, int x ,int y){
		this.color = color;
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
	//returns the color of the tile
	public String getColor(){
		return color;
	}
	//Maybe change return type of polymorphed function
	static boolean TileAction(String color , int x ,int y,Tile tile){
		return tile.TileAction(color ,x ,y,tile);
	}
}