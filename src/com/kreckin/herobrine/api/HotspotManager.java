package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;

public class HotspotManager {
    
    private final List<Location> locations = new ArrayList<>();

    public void addLocation(Location loc) {
        if (!Herobrine.getConfigFile().getBoolean("Herobrine.allowHotspots")) {
            return;
        }
        Herobrine.getInstance().getLogger().info("Added Hotspot: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
        locations.add(loc);
    }
    
    public int getImportance(Location loc) {
        int hotspots = 0;
        for (Location location : locations) {
            if (!location.getWorld().getName().equals(loc.getWorld().getName())) {
                continue;
            }
            if (location.distance(loc) <= Herobrine.getConfigFile().getInt("Herobrine.hotspotSize")) {
                hotspots++;
            }
        }
        if (hotspots < 2 && Herobrine.getConfigFile().getInt("Herobrine.hotspotSize") > 1) {
            hotspots = 2;
        }
        return hotspots;
    }

    public List<Location> getLocations() {
        return locations;
    }
}
