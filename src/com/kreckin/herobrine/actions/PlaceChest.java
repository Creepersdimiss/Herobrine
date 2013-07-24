package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlaceChest extends Action {
    
    private final List<Material> items = new ArrayList<>();
    private final Random random = new Random();
    
    public PlaceChest() {
        super(true);
        for (String line : Herobrine.getConfigFile().getStringList("Herobrine.allowedItems")) {
            if (Material.getMaterial(line) != null) {
                items.add(Material.getMaterial(line));
            }
        }
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        if (this.items.isEmpty()) {
            return "Failed, there are no items in the configuration file!";
        }
        Location loc = Util.getNearbyLocation(player, 10);
        if (!Util.isValid(loc.getBlock())) {
            return "Failed, there are no sign messages in the configuration file!";
        }
        ItemStack item;
        if (items.size() == 1) {
            item = new ItemStack(items.get(0), random.nextInt(3));
        } else {
            item = new ItemStack(items.get(random.nextInt(this.items.size() - 1)), random.nextInt(3));
        }
        loc.getBlock().setType(Material.CHEST);
        ((Chest) loc.getBlock().getState()).getInventory().addItem(item);
        return ("Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
    }
}
