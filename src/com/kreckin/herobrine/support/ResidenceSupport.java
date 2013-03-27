package com.kreckin.herobrine.support;

import com.bekvon.bukkit.residence.Residence;
import com.kreckin.herobrine.api.Support;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ResidenceSupport extends Support {
    
    public ResidenceSupport() {
        super("Residence");
    }

    @Override
    public boolean checkPermissions(Player player, Plugin plugin) {
        if (Residence.getResidenceManager().getByLoc(player.getLocation()) != null) {
            return false;
        }
        return true;
    }
}
