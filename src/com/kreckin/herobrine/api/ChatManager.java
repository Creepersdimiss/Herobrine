package com.kreckin.herobrine.api;

import java.util.ArrayList;
import org.bukkit.entity.Player;

public class ChatManager {

    private final ArrayList<String> usernames;
  
    public ChatManager() {
        this.usernames = new ArrayList<String>();
    }
  
    public void addPlayer(Player player) {
        if (!this.usernames.contains(player.getName())) {
            this.usernames.add(player.getName());
        }
    }
  
    public void removePlayer(Player player) {
        if (this.usernames.contains(player.getName())) {
            this.usernames.remove(player.getName());
        }
    }
    
    public ArrayList<String> getUsernames() {
        return this.usernames;
    }
}
