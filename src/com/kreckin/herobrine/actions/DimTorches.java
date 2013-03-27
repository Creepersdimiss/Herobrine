package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class DimTorches extends Action {

    public DimTorches() {
        super(true);
    }
    
    @Override
    public String callAction(Player player, Object[] metadata) {
        int torchTotal = 0;
        for (int x = -5; x < 5; x++) {
            for (int z = -5; z < 5; z++) {
                for (int y = -5; y < 5; y++) {
                    Block block = player.getWorld().getBlockAt(x, y, z);
                    if (block.getType().equals(Material.TORCH)) {
                        block.setType(Material.REDSTONE_TORCH_ON);
                        torchTotal++;
                    }
                }
            }
        }
        return ("Dimmed " + torchTotal + " torches.");
    }
}
