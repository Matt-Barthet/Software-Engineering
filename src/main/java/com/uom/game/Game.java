import java.util.Random;
import java.util.Scanner;

public class Game {
	public Player player[];
	Scanner reader = new Scanner(System.in);
	Random rand  = new Random();
	//Has passing parameters for the game no of players and board size
	//This will create the map and the html table
	public Game(int players,int n){
		Map map = new Map(n);
		setNumPlayers(players,n,map);
		showMap(map,n);
		winGame(players,player,map);
	}
	//Gaming loop
	//needs more functionality 
	//Limits of map
	//Win condition
	//Water tile deaths(respawning)
	public boolean winGame(int players, Player player[], Map map){
		while(true){
			int i = 0;
			for(i = 0; i < players ; i++){
				System.out.println("Player , "+player[i].getPN()+" Turn Choose direction");
				char direction = reader.next().charAt(0);
				player[i].move(player[i],direction);
				System.out.println("Player , "+player[i].getPN()+" At X "+player[i].getPX()+ " and Y : "+player[i].getPY());
				showPlayer(player[i],map.returnTileAmount());
				if(map.getTile(player[i].getPX() ,player[i].getPY()) instanceof WinningTile ){
					System.out.println("Congratulations winner Player  , "+player[i].getPN());
					return false;
				}
			}
		}
	}
	//This should also check if the player is being set on a grass tile or not
	public void setNumPlayers(int players,int n,Map map){
		player = new Player[players];
		for(int i = 0 ; i < players;i++){
			int x1 = rand.nextInt(n) + 0;
			int y1 = rand.nextInt(n) + 0;
			if(!(map.getTile(x1,y1) instanceof GrassTile)){
				//Continue randomizing the spawn until its a grass tile
				while(!(map.getTile(x1,y1) instanceof GrassTile)){
						x1 = rand.nextInt(n) + 0;
						y1 = rand.nextInt(n) + 0;
				}
			}
			//Create if player is spawned on a grass tile
			player[i] = new Player(i,x1,y1);
		}
	}
	//Temporary function to output the map created on the console
	public static void showPlayer(Player player,int n){
		for(int i = 0;i<n;i++){
			for(int j = 0; j<n;j++){
				if((player.getPX()==i)&&(player.getPY()==j)){
					System.out.print(" PP ");
				}else{
					System.out.print(" __ ");
				}
			}
			System.out.println();	
		}
	}
	
	//Temporary function to output the map created on the console
	public static void showMap(Map map,int n){
		for(int i = 0;i<n;i++){
			for(int j = 0; j<n;j++){
				if(map.getTile(i,j) instanceof  WaterTile){
					System.out.print(" WT ");
				}else if(map.getTile(i,j) instanceof GrassTile){
					System.out.print(" GT ");
				}else if(map.getTile(i,j)  instanceof  WinningTile){
					System.out.print(" WW ");
				}else if(map.getTile(i,j)==null){
					System.out.print(" __ ");
				}else{
					System.out.print(" ER ");
				}
			}
			System.out.println();	
		}
	}
	
}