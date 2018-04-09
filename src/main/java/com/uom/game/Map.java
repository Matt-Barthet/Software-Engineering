import java.util.Random;

public class Map {
	//Change to private later
	public Tile[][] tile;
	private int k = 0;
	private int n ;
	private GrassTile grass[];
	private WaterTile water[];
	private WinningTile win;
	
	Random rand  = new Random();
	//Create a map with n*n amount of tiles
	//This will have to randomly generate the type of tiles
	public Map(int n){
		this.n = n;
		//Create the tiles and set them 
		tile = new Tile[n][n];
		grass = new GrassTile[n*n];
		water = new WaterTile[n*n];
		//Going through every tile randomly generate water or grass tiles
		for (int i = 0 ;i < n; i++){
			for (int j = 0 ;j < n; j++){
				int percent = rand.nextInt(10) + 1;
				//Change the percentage to change the spawn rate of water tiles
				if(percent>=9){
					water[k] = new WaterTile(i,j);
					setTile(water[k],water[k].getX(),water[k].getY());
					k++;
				}else{
					grass[k] = new GrassTile(i,j);
					setTile(grass[k],grass[k].getX(),grass[k].getY());
					k++;
				}
			}
		}
		//Set a random position for the winning tile after all tiles are placed
		int x1 = rand.nextInt(n) + 0;
		int y1 = rand.nextInt(n) + 0;
		win  = new WinningTile(x1,y1);
		setTile(win,win.getX(),win.getY());
	}
	public int returnTileAmount(){
		return n;
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