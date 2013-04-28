package com.kreckin.herobrine.api;

import com.kreckin.herobrine.util.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

public abstract class Support {
    
    private int state;
    private Plugin plugin;
    private final String name;
    
    public Support(String name) {
        Validate.isSafe(name);
        this.name = name;
    }
    
    public void onStartup(Plugin plugin) { }

    public abstract boolean checkPermissions(Location loc, Plugin plugin);

    public Plugin getPlugin() {
        if (state == 0) {
            plugin = Bukkit.getServer().getPluginManager().getPlugin(name);
        }
        return plugin;
    }
    
    public boolean isEnabled() {
        if (state == 0) {
            if (getPlugin() != null) {
                state = 1;
                onStartup(plugin);
            } else {
                state = -1;
            }
        }
        return (state == 1);
    }
    
    public String getName() {
        return name;
    }
}
