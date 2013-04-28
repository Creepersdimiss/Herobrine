package com.kreckin.herobrine.api;

import com.kreckin.herobrine.util.Validate;
import java.util.ArrayList;
import org.bukkit.entity.Player;

public class ChatManager {

    private final ArrayList<String> usernames;
  
    public ChatManager() {
        usernames = new ArrayList<String>();
    }
  
    public void addPlayer(Player player) {
        Validate.isSafe(player);
        if (!usernames.contains(player.getName())) {
            usernames.add(player.getName());
        }
    }
  
    public void removePlayer(Player player) {
        Validate.isSafe(player);
        if (usernames.contains(player.getName())) {
            usernames.remove(player.getName());
        }
    }
    
    public ArrayList<String> getUsernames() {
        return usernames;
    }
}
