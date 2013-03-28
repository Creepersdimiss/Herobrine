package com.kreckin.herobrine.support;

import com.kreckin.herobrine.api.Support;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class WorldGuardSupport extends Support {
    
    public WorldGuardSupport() {
        super("WorldGuard");
    }

    @Override
    public boolean checkPermissions(Player player, Plugin plugin) {
        RegionManager manager = ((WorldGuardPlugin) plugin).getRegionManager(player.getWorld());
        if (manager != null) {
            if (manager.getRegions() == null) {
                return true;
            }
            for (Map.Entry entry : manager.getRegions().entrySet()) {
                if (((ProtectedRegion) entry.getValue()).contains(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ())) {
                    return false;
                }
            }
        }
        return true;
    }
}
