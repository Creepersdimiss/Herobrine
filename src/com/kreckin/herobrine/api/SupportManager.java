package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.support.GriefPreventionSupport;
import com.kreckin.herobrine.support.PreciousStonesSupport;
import com.kreckin.herobrine.support.ResidenceSupport;
import com.kreckin.herobrine.support.WorldGuardSupport;
import java.util.ArrayList;
import java.util.logging.Level;
import org.bukkit.entity.Player;

public class SupportManager {
    
    private final ArrayList<Support> supports;
    
    public SupportManager() {
        this.supports = new ArrayList<Support>();
        this.registerSupport(new ResidenceSupport());
        this.registerSupport(new GriefPreventionSupport());
        this.registerSupport(new PreciousStonesSupport());
        this.registerSupport(new WorldGuardSupport());
    }
    
    public final void registerSupport(Support support) {
        this.supports.add(support);
        if (Herobrine.getConfigFile().getBoolean("Herobrine.verboseLog")) {
            Herobrine.log("Supports: " + support.getName(), Level.INFO);
        }
    }
    
    public void checkPlugins() {
        for (Support support : this.supports) {
            if (support.isEnabled()) {
                Herobrine.log("Found: " + support.getName() + " v" + support.getPlugin().getDescription().getVersion(), Level.INFO);
            }
        }
    }
    
    public boolean checkPermissions(Player player) {
        for (Support support : this.supports) {
            if (!support.isEnabled()) {
                continue;
            }
            if (!support.checkPermissions(player, support.getPlugin())) {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<Support> getSupports() {
        return this.supports;
    }
}
