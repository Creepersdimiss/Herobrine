package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.util.Validate;
import java.util.ArrayList;
import org.bukkit.Location;

public class HotspotManager {
    
    private final ArrayList<Location> locations;
    
    public HotspotManager() {
        locations = new ArrayList<Location>();
    }
    
    public void addLocation(Location loc) {
        Validate.isSafe(loc);
        if (!Herobrine.getConfigFile().getBoolean("Herobrine.allowHotspots")) {
            return;
        }
        Herobrine.getLog().info("Added Hotspot: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
        locations.add(loc);
    }
    
    public int getImportance(Location loc) {
        Validate.isSafe(loc);
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

    public ArrayList<Location> getLocations() {
        return locations;
    }
}
