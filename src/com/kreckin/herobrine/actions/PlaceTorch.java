package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class PlaceTorch extends Action {
    
    public PlaceTorch() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        Block block = Util.getNearbyLocation(player, 10).getBlock();
        if (Util.isValid(block)) {
            block.setType(Material.REDSTONE_TORCH_ON);
            Location loc = block.getLocation();
            return ("Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
        }
        return "Failed, could not find a proper location!";
    }
}
