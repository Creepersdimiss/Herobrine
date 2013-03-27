package com.kreckin.herobrine.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public abstract class Support {
    
    private int state;
    private Plugin plugin;
    private final String name;
    
    public Support(String name) {
        this.name = name;
        this.state = 0;
    }

    public abstract boolean checkPermissions(Player player, Plugin plugin);
    
    public Plugin getPlugin() {
        if (this.plugin == null && this.state != 0) {
            this.plugin = Bukkit.getServer().getPluginManager().getPlugin(this.name);
        }
        return this.plugin;
    }
    
    public boolean isEnabled() {
        if (state == 0) {
            if (this.getPlugin() != null) {
                state = 1;
            } else {
                state = -1;
            }
        }
        return (this.state == 1);
    }
    
    public String getName() {
        return this.name;
    }
}
