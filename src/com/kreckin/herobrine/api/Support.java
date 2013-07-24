package com.kreckin.herobrine.api;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

public abstract class Support {
    
    private SupportState state = SupportState.UNLOADED;
    private Plugin plugin;
    private final String name;
    
    public Support(String name) {
        this.name = name;
    }
    
    public void onStartup(Plugin plugin) { }

    public abstract boolean checkPermissions(Location loc, Plugin plugin);

    public Plugin getPlugin() {
        if (state.equals(SupportState.UNLOADED)) {
            plugin = Bukkit.getServer().getPluginManager().getPlugin(name);
        }
        return plugin;
    }
    
    public boolean isEnabled() {
        if (state.equals(SupportState.UNLOADED)) {
            if (getPlugin() != null) {
                state = SupportState.LOADED;
                onStartup(plugin);
            } else {
                state = SupportState.INVALID;
            }
        }
        return state.equals(SupportState.LOADED);
    }
    
    public String getName() {
        return name;
    }
}
