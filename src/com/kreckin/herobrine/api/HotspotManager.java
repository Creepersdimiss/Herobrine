package com.kreckin.herobrine.api;

import java.util.ArrayList;
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
        this.locations.add(loc);
    }
    
    public boolean isInside(Location loc) {
        for (Location location : this.locations) {
            if (location.distance(loc) <= 50) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Location> getLocations() {
        return this.locations;
    }
}
