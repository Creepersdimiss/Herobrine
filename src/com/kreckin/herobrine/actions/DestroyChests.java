package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DestroyChests extends Action {
    
    public DestroyChests() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        int chestTotal = 0, dropTotal = 0;
        for (int x = -5; x < 5; x++) {
            for (int z = -5; z < 5; z++) {
                for (int y = -5; y < 5; y++) {
                    Block block = player.getLocation().add(x, y, z).getBlock();
                    if (block.getType().equals(Material.CHEST)) {
                        Chest chest = (Chest) block.getState();
                        for (ItemStack item : chest.getBlockInventory().getContents()) {
                            if (item == null) {
                                continue;
                            }
                            dropTotal += item.getAmount();
                            block.getWorld().dropItemNaturally(block.getLocation(), item);
                        }
                        chest.getBlockInventory().clear();
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.CHEST, 1));
                        block.setType(Material.AIR);
                        chestTotal++;
                    }
                }
            }
        }
        return ("Destroyed " + chestTotal + " chests (dropped " + dropTotal + " items).");
    }
}
