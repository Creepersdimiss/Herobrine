package com.kreckin.herobrine.api;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

public abstract class Support {
    
    private State state = State.UNLOADED;
    private Plugin plugin;
    private final String name;
    
    public Support(String name) {
        this.name = name;
    }
    
    public void onStartup(Plugin plugin) { }

    public abstract boolean checkPermissions(Location loc, Plugin plugin);

    public Plugin getPlugin() {
        if (state.equals(State.UNLOADED)) {
            plugin = Bukkit.getServer().getPluginManager().getPlugin(name);
        }
        return plugin;
    }
    
    public boolean isEnabled() {
        if (state.equals(State.UNLOADED)) {
            if (getPlugin() != null) {
                state = State.LOADED;
                onStartup(plugin);
            } else {
                state = State.INVALID;
            }
        }
        return state.equals(State.LOADED);
    }
    
    public String getName() {
        return name;
    }
}
