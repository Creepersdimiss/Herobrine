package com.kreckin.herobrine.support;

import com.kreckin.herobrine.api.Support;
import com.palmergames.bukkit.towny.object.TownyUniverse;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

public class TownySupport extends Support {
    
    public TownySupport() {
        super("Towny");
    }

    @Override
    public boolean checkPermissions(Location loc, Plugin plugin) {
        return (TownyUniverse.getTownBlock(loc) != null);
    }
}
