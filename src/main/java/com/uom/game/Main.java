import java.util.Scanner;

public class Main {
	
	protected int min_players = 2;
	protected int max_players = 8;
	protected int min_mapsize1 = 5;
	protected int min_mapsize2 = 8;
	protected int max_mapsize = 50;
	
    public static void main( String[] args ){
		Scanner reader = new Scanner(System.in);
		boolean accept = true;
		int players = 0 ;
		int map_size = 0;
		while(accept){
			System.out.println("Enter the amount of players: min =2 , max = 8  ");
			players = reader.nextInt();
			
			System.out.println("Enter the size of the map: min = 5 ,max = 50 ");
			map_size = reader.nextInt();
			
			if((players>=2 && players<=8)&&(map_size>=5 && map_size<=50)){
				accept = false;
			}else{
				System.out.println("Failed inputs try again");
			}
		
		}
		Game g = new Game(players,map_size);
    }
}