package com.kreckin.herobrine.support;

import com.kreckin.herobrine.api.Support;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

public class GriefPreventionSupport extends Support {
    
    public GriefPreventionSupport() {
        super("GriefPrevention");
    }

    @Override
    public boolean checkPermissions(Location loc, Plugin plugin) {
        if (GriefPrevention.instance.dataStore.getClaimAt(loc, false, null) != null) {
            return false;
        }
        return true;
    }
}
