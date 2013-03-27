package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.support.ResidenceSupport;
import java.util.ArrayList;
import java.util.logging.Level;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SupportManager {
    
    private final ArrayList<Support> supports;
    
    public SupportManager() {
        this.supports = new ArrayList<Support>();
        this.registerSupport(Herobrine.getInstance(), new ResidenceSupport());
    }
    
    public final void registerSupport(Plugin plugin, Support support) {
        this.supports.add(new ResidenceSupport());
        if (Herobrine.getConfigFile().getBoolean("Herobrine.verboseLog")) {
            Herobrine.log("Supports: " + support.getName(), Level.INFO);
        }
    }
    
    public void checkPlugins() {
        for (Support support : this.supports) {
            if (support.isEnabled() && Herobrine.getConfigFile().getBoolean("Herobrine.verboseLog")) {
                Herobrine.log("Found: " + support.getName() + " v" + support.getPlugin().getDescription().getName(), Level.INFO);
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
