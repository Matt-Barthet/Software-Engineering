package com.uom.game;

import java.util.Scanner;
import static j2html.TagCreator.*;

public class Main {
	
    public static void main( String[] args ){
		Scanner reader = new Scanner(System.in);
		boolean accept = true;
		int players = 0 ;
		int map_size = 0;
		
        while(accept){
			System.out.println("Enter the amount of players: min = 2 , max = 8  ");
			players = reader.nextInt();
			
			System.out.println("Enter the size of the map: min = 5 ,max = 50 ");
			map_size = reader.nextInt();
			//Change this to errors later on
			if((players>=2 && players<=8)&&(map_size>=5 && map_size<=50)){
				if((players>=2 && players<=4)&&(map_size>=5)){
					accept = false;
				}else if((players>=5 && players<=8)&&(map_size>=8))
					accept = false;
				else{
					accept = true;
					System.out.println("Map too small for amount of players");
				}
			}else{
				System.out.println("Failed inputs try again");
			}
		
		}
		Game g = new Game(players,map_size);
    }
}