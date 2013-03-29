package com.kreckin.herobrine.support;

import com.kreckin.herobrine.api.Support;
import com.palmergames.bukkit.towny.object.TownyUniverse;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class TownySupport extends Support {
    
    public TownySupport() {
        super("Towny");
    }

    @Override
    public boolean checkPermissions(Player player, Plugin plugin) {
        return (TownyUniverse.getTownBlock(player.getLocation()) != null);
    }
}
