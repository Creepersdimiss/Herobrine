package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class CreateBlankTree extends Action {
    
    public CreateBlankTree() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        Location loc = Util.getNearbyLocation(player, 15);
        if (Util.isValid(loc.getBlock())) {
            int height = 4 + Util.getRandom().nextInt(3);
            for (int y = 0; y < height; y++) {
                if (!loc.add(0, y, 0).getBlock().getType().equals(Material.AIR)) {
                    break;
                }
                loc.add(0, y, 0).getBlock().setType(Material.LOG);
            }
            return ("Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
        }
        return "Failed, could not find a proper location!";
    }
}
