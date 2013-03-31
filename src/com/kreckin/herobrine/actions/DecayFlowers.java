package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class DecayFlowers extends Action {
    
    public DecayFlowers() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        int changed = 0;
        for (int x = -5; x < 5; x++) {
            for (int z = -5; z < 5; z++) {
                for (int y = -5; y < 5; y++) {
                    Block block = player.getLocation().add(x, y, z).getBlock();
                    if (block.getType().equals(Material.YELLOW_FLOWER)) {
                        block.setType(Material.BROWN_MUSHROOM);
                        changed++;
                    } else if (block.getType().equals(Material.RED_ROSE)) {
                        block.setType(Material.RED_MUSHROOM);
                        changed++;
                    }
                }
            }
        }
        return ("Decayed " + changed + " flowers!");
    }
}
