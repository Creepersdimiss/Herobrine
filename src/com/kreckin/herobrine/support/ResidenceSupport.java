package com.kreckin.herobrine.support;

import com.bekvon.bukkit.residence.Residence;
import com.kreckin.herobrine.api.Support;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

public class ResidenceSupport extends Support {
    
    public ResidenceSupport() {
        super("Residence");
    }

    @Override
    public boolean checkPermissions(Location loc, Plugin plugin) {
        if (Residence.getResidenceManager().getByLoc(loc) != null) {
            return false;
        }
        return true;
    }
}
