public class Game {

	//Has passing parameters for the game no of players and board size
	//This will create the map and the html table
	public Game(int players,int n){
		Map map = new Map(n);
		showMap(map,n);
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