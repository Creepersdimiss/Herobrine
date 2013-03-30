package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlaceChest extends Action {
    
    private final ArrayList<Material> items;
    
    public PlaceChest() {
        super(true);
        this.items = new ArrayList<Material>();
        for (String line : Herobrine.getConfigFile().getStringList("Herobrine.allowedItems")) {
            if (Material.getMaterial(line) != null) {
                this.items.add(Material.getMaterial(line));
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
            item = new ItemStack(this.items.get(0), Util.getRandom().nextInt(3));
        } else {
            item = new ItemStack(this.items.get(Util.getRandom().nextInt(this.items.size() - 1)), Util.getRandom().nextInt(3));
        }
        loc.getBlock().setType(Material.CHEST);
        ((Chest) loc.getBlock().getState()).getInventory().addItem(item);
        return ("Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
    }
}
