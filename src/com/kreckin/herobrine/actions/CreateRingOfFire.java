package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class CreateRingOfFire extends Action {
    
    public CreateRingOfFire() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        Block[] blocks = new Block[8];
        blocks[0] = player.getLocation().add(2, 0, 0).getBlock();
        blocks[1] = player.getLocation().add(0, 0, 2).getBlock();
        blocks[2] = player.getLocation().add(0, 0, -2).getBlock();
        blocks[3] = player.getLocation().add(-2, 0, 0).getBlock();
        blocks[4] = player.getLocation().add(1, 0, 1).getBlock();
        blocks[5] = player.getLocation().add(1, 0, -1).getBlock();
        blocks[6] = player.getLocation().add(-1, 0, 1).getBlock();
        blocks[7] = player.getLocation().add(-1, 0, -1).getBlock();
        for (Block block : blocks) {
            if (!Util.isValid(block)) {
                return "Failed, could not find a proper location!";
            }
        }
        for (Block block : blocks) {
            block.setType(Material.FIRE);
        }
        Location loc = player.getLocation();
        return ("Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
    }
}
