package com.kreckin.herobrine.support;

import com.kreckin.herobrine.api.Support;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class GriefPreventionSupport extends Support {
    
    public GriefPreventionSupport() {
        super("GriefPrevention");
    }

    @Override
    public boolean checkPermissions(Player player, Plugin plugin) {
        if (GriefPrevention.instance.dataStore.getClaimAt(player.getLocation(), false, null) != null) {
            return false;
        }
        return true;
    }
}
