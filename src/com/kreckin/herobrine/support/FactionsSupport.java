package com.kreckin.herobrine.support;

import com.kreckin.herobrine.api.Support;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

public class FactionsSupport extends Support {
    
    public FactionsSupport() {
        super("Factions");
    }

    @Override
    public boolean checkPermissions(Location loc, Plugin plugin) {
        return true;
    }
}
