package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.support.FactionsSupport;
import com.kreckin.herobrine.support.GriefPreventionSupport;
import com.kreckin.herobrine.support.HerobrineAISupport;
import com.kreckin.herobrine.support.MonsterApocalypseSupport;
import com.kreckin.herobrine.support.PreciousStonesSupport;
import com.kreckin.herobrine.support.ResidenceSupport;
import com.kreckin.herobrine.support.TownySupport;
import com.kreckin.herobrine.support.WorldGuardSupport;
import java.util.ArrayList;
import org.bukkit.Location;

public class SupportManager {
    
    private final ArrayList<Support> supports;
    
    public SupportManager() {
        this.supports = new ArrayList<Support>();
        this.registerSupport(new ResidenceSupport());
        this.registerSupport(new GriefPreventionSupport());
        this.registerSupport(new PreciousStonesSupport());
        this.registerSupport(new WorldGuardSupport());
        this.registerSupport(new TownySupport());
        this.registerSupport(new HerobrineAISupport());
        this.registerSupport(new FactionsSupport());
        this.registerSupport(new MonsterApocalypseSupport());
    }
    
    public final void registerSupport(Support support) {
        this.supports.add(support);
    }
    
    public void checkPlugins() {
        for (Support support : this.supports) {
            if (support.isEnabled() && support.getPlugin().isEnabled()) {
                Herobrine.getLog().info("Hooked: " + support.getName() + " v" + support.getPlugin().getDescription().getVersion());
            }
        }
    }
    
    public boolean checkPermissions(Location loc) {
        for (Support support : this.supports) {
            if (!support.isEnabled()) {
                continue;
            }
            if (!support.checkPermissions(loc, support.getPlugin())) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Support> getSupports() {
        return this.supports;
    }
}
