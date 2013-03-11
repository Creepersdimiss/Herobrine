package com.kreckin.herobrine;

import com.bekvon.bukkit.residence.Residence;
import java.util.logging.Level;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Support {
    
    private boolean useWorldGuard, useResidence, usePrevention;
    
    public Support() {
        this.useWorldGuard = false;
        this.useResidence = false;
        this.usePrevention = false;
    }
    
    public void scanPlugins() {
        this.useResidence = (Bukkit.getServer().getPluginManager().getPlugin("Residence") != null);
        this.useWorldGuard = (Bukkit.getServer().getPluginManager().getPlugin("WorldGuard") != null);
        this.usePrevention = (Bukkit.getServer().getPluginManager().getPlugin("GriefPrevention") != null);
        if (this.useResidence) {
            Herobrine.log("Found Residence v" + Bukkit.getServer().getPluginManager().getPlugin("Residence").getDescription().getVersion(), Level.INFO);
        }
        if (this.useWorldGuard) {
            Herobrine.log("Found WorldGuard v" + Bukkit.getServer().getPluginManager().getPlugin("WorldGuard").getDescription().getVersion(), Level.INFO);
        }
        if (this.usePrevention) {
            Herobrine.log("Found GriefPrevention v" + Bukkit.getServer().getPluginManager().getPlugin("GriefPrevention").getDescription().getVersion(), Level.INFO);
        }
    }
    
    public boolean isAllowed(Location loc) {
        if (this.useResidence) {
            if (Residence.getResidenceManager().getByLoc(loc) != null) {
                return false;
            }
        }
        if (this.useWorldGuard) {
            // TODO: WorldGuard support.
        }
        if (this.usePrevention) {
            if (GriefPrevention.instance.dataStore.getClaimAt(loc, false, null) != null) {
                return false;
            }
        }
        return true;
    }
}
