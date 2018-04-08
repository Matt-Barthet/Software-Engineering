public class Map {
	//Change to private later
	public Tile[][] tile;
	
	//Create a map with n*n amount of tiles
	//This will have to randomly generate the type of tiles
	public Map(int n){
		tile = new Tile[n][n];
	}
	//Sets the type of tile at the certain position
	public void setTile(Tile tile,int x,int y){
		this.tile[x][y]=tile;
	}
	//Returns the type of tile at that position
	public Tile getTile(int x ,int y){
		return tile[x][y];
	}
	//Changes the type of tile 
	public void changeTile(int x,int y){
		
	}
	
}