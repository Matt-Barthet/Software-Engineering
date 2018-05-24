package com.uom.game;
import java.util.*;

public class Observer_Class {

    Score_Subject score;
    List<Tile> observer_state = new ArrayList<Tile>();
    
    public void update(){
        observer_state = score.get_state();
    }

}