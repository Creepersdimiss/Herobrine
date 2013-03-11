package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.ActionResult;
import com.kreckin.herobrine.api.ActionType;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class DimTorches extends Action {

    public DimTorches() {
        super(ActionType.STANDARD);
    }
    
    @Override
    public ActionResult callAction(Player player, Object[] metadata) {
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
        return (new ActionResult("Done.", "Dimmed " + torchTotal + " torches."));
    }
}
