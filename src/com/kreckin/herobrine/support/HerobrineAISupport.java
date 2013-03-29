package com.kreckin.herobrine.support;

import com.kreckin.herobrine.api.Support;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

public class HerobrineAISupport extends Support {
    
    public HerobrineAISupport() {
        super("HerobrineAI");
    }

    @Override
    public boolean checkPermissions(Location loc, Plugin plugin) {
        Bukkit.getServer().getPluginManager().disablePlugin(plugin);
        return true;
    }
}
