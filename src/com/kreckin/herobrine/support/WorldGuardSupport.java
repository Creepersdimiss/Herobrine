package com.kreckin.herobrine.support;

import com.kreckin.herobrine.api.Support;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

public class WorldGuardSupport extends Support {
    
    public WorldGuardSupport() {
        super("WorldGuard");
    }

    @Override
    public boolean checkPermissions(Location loc, Plugin plugin) {
        RegionManager manager = ((WorldGuardPlugin) plugin).getRegionManager(loc.getWorld());
        if (manager.getRegions() == null) {
            return true;
        }
        for (Map.Entry entry : manager.getRegions().entrySet()) {
            if (((ProtectedRegion) entry.getValue()).contains(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ())) {
                return false;
            }
        }
        return true;
    }
}
