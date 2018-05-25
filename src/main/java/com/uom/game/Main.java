package com.uom.game;

import java.util.Scanner;
import static j2html.TagCreator.*;

public class Main {
	
    public static void main( String[] args ){
		Scanner reader = new Scanner(System.in);
		boolean accept = false;
	    int players = 0 ;
		int map_size = 0;
		int map_type = 0;
		boolean collab_mode = false;
        int no_of_teams = 0;
    
        
        while(!accept){
            try{
            
                System.out.println("Enter the kind of map you want 1 = safe , 2 = hazardous");
                map_type = reader.nextInt();

                if(map_type != 1 && map_type != 2){
                    throw new RuntimeException();
                }

                //Collaborative mode prompt
                System.out.println("Would you like to play in collaborative mode? 0 = No, 1 = Yes.");
                int collab = reader.nextInt();
                if(collab == 1){
                    collab_mode = true;
                } else if (collab != 0){
                    throw new RuntimeException();
                }//Otherwise remain false

                System.out.println("Enter the amount of players: min = 2 , max = 8  ");
                players = reader.nextInt();
                if (players < 2 || players > 8){
                    throw new RuntimeException();
                }

                //Team count prompt
                if(collab_mode == true){
                    System.out.println("How many teams would you like?");
                    no_of_teams = reader.nextInt();
                    if(no_of_teams > players){
                        throw new RuntimeException();
                    } else if (no_of_teams <= 0){
                        throw new RuntimeException();
                    }
                }


                System.out.println("Enter the size of the map: min = 5 ,max = 50 ");
                map_size = reader.nextInt();
                //Change this to errors later on
                if((players>=2 && players<=8)&&(map_size>=5 && map_size<=50)){
                    if((players>=2 && players<=4)&&(map_size>=5)){
                        accept = true;
                    }else if((players>=5 && players<=8)&&(map_size>=8))
                        accept = true;
                    else{
                        throw new RuntimeException();
                    }
                }else{
                    throw new RuntimeException();
                }
            } catch (Exception e){
                System.out.println("Incorrect Input! Restarting...");
                continue;
            }
		}
        //Once accepted the new game can be created
        if (accept){
            Game g = new Game(players,map_size,map_type, no_of_teams);
        }
    }
}