package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.Material;

public class HotspotManager {
    
    private final ArrayList<Location> locations;
    
    public HotspotManager() {
        this.locations = new ArrayList<Location>();
    }
    
    public void addLocation(Location loc) {
        if (this.isInside(loc)) {
            return;
        }
        if (Util.isValid(loc.getBlock())) {
            loc.getBlock().setType(Material.JACK_O_LANTERN);
        }
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
