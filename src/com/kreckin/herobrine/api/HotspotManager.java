package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import java.util.ArrayList;
import org.bukkit.Location;

public class HotspotManager {
    
    private final ArrayList<Location> locations;
    
    public HotspotManager() {
        this.locations = new ArrayList<Location>();
    }
    
    public void addLocation(Location loc) {
        Herobrine.getLog().info("Added Hotspot: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
        this.locations.add(loc);
    }
    
    public int getImportant(Location loc) {
        int hotspots = 0;
        for (Location location : this.locations) {
            if (!location.getWorld().getName().equals(loc.getWorld().getName())) {
                continue;
            }
            if (location.distance(loc) <= Herobrine.getConfigFile().getInt("Herobrine.hotspotSize")) {
                hotspots++;
            }
        }
        if (hotspots < 2) {
            hotspots = 2;
        }
        return hotspots;
    }

    public ArrayList<Location> getLocations() {
        return this.locations;
    }
}
