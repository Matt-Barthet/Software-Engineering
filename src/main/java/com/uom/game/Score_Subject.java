package com.uom.game;

import java.util.*;

class Score_Subject extends Abstract_Subject {
    
    public List<Tile> team_uncovered = new ArrayList<Tile>();
    public List<Observer_Class> team_members = new ArrayList<Observer_Class>();
    
    public void set_state(Tile tile){
        team_uncovered.add(tile);
        notify_players();
    }
    
    public List<Tile> get_state (){
        return team_uncovered;
    }
    
    public void notify_players(){
        
        for (int i = 0; i < team_members.size(); i++){
            team_members.get(i).update();
        }
        
    }
    
    public void attach(Observer_Class p){
        team_members.add(p);
        p.score = this;
    }
}