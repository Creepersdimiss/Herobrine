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
import java.util.List;
import org.bukkit.Location;

public class SupportManager {
    
    private final List<Support> supports = new ArrayList<>();
    
    public SupportManager() {
        supports.add(new ResidenceSupport());
        supports.add(new GriefPreventionSupport());
        supports.add(new PreciousStonesSupport());
        supports.add(new WorldGuardSupport());
        supports.add(new TownySupport());
        supports.add(new HerobrineAISupport());
        supports.add(new FactionsSupport());
        supports.add(new MonsterApocalypseSupport());
    }

    public void checkPlugins() {
        for (Support support : supports) {
            if (support.isEnabled() && support.getPlugin().isEnabled()) {
                Herobrine.getInstance().getLogger().info("Hooked: " + support.getName() + " v" + support.getPlugin().getDescription().getVersion());
            }
        }
    }
    
    public boolean checkPermissions(Location loc) {
        for (Support support : supports) {
            if (!support.isEnabled()) {
                continue;
            }
            if (!support.checkPermissions(loc, support.getPlugin())) {
                return false;
            }
        }
        return true;
    }

    public List<Support> getSupports() {
        return supports;
    }
}
