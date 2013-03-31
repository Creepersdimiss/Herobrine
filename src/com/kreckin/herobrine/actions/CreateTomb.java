package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.Structure;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CreateTomb extends Action {
    
    public CreateTomb() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        Location loc = Util.getNearbyLocation(player, 30);
        if (!Structure.loadStructure("/com/kreckin/herobrine/structures/Tomb.yml").createStructure(loc)) {
            return "Failed, could not find a proper location!";
        }
        for (Block block : Structure.loadStructure("/com/kreckin/herobrine/structures/Tomb.yml").getBlocks(loc)) {
            if (block.getType().equals(Material.CHEST)) {
                ((Chest) block.getState()).getInventory().addItem(new ItemStack(2266, 1));
            }
        }
        return ("Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
    }
}
