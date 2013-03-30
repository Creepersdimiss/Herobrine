package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class Structure {
    
    private final Location loc;
    private final YamlConfiguration config;

    public Structure(Location loc, YamlConfiguration config) {
        this.loc = loc;
        this.config = config;
    }
    
    public static Structure loadStructure(Location loc, String name) {
        return (new Structure(loc, YamlConfiguration.loadConfiguration(Herobrine.class.getResourceAsStream(name))));
    }
    
    public void createStructure() {
        for (String blockItem : this.config.getStringList("Blocks")) {
            String[] blockData = blockItem.split(",");
            Location blockLoc = new Location(this.loc.getWorld(), this.loc.getBlockX() + Integer.parseInt(blockData[0]), this.loc.getBlockY() + Integer.parseInt(blockData[1]), this.loc.getBlockZ() + Integer.parseInt(blockData[2]));
            blockLoc.getBlock().setType(Material.getMaterial(blockData[3]));
            blockLoc.getBlock().setData(Byte.parseByte(blockData[4]));
            if (blockLoc.getBlock().getType().equals(Material.CHEST)) {
                Chest chest = (Chest) blockLoc.getBlock().getState();
                chest.getInventory().addItem(new ItemStack(2266, 1));
            }
        }
    }
    
    public YamlConfiguration getConfigFile() {
        return this.config;
    }
    
    public Location getLocation() {
        return this.loc;
    }
}
