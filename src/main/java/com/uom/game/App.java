package com.uom.game;

import static j2html.TagCreator.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;


public class App 
{
    public static void main( String[] args )
    {
        
        Player player = new Player(2,2,3);
        int map_size = 10;
        Map map = new Map(map_size);
        //generateHTMLMap(player, map_size, map);
        
    }
    
}
