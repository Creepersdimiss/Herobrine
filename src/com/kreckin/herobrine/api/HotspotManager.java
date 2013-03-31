package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import java.util.ArrayList;
import java.util.logging.Level;
import org.bukkit.Location;

public class HotspotManager {
    
    private final ArrayList<Location> locations;
    
    public HotspotManager() {
        this.locations = new ArrayList<Location>();
    }
    
    public void addLocation(Location loc) {
        if (this.isInside(loc)) {
            return;
        }
        Herobrine.log("Added Hotspot: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ(), Level.INFO);
        this.locations.add(loc);
    }
    
    public boolean isInside(Location loc) {
        for (Location location : this.locations) {
            if (location.distance(loc) <= Herobrine.getConfigFile().getInt("Herobrine.hotspotSize")) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Location> getLocations() {
        return this.locations;
    }
}
