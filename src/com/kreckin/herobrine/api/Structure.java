package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;

public class Structure {

    private final YamlConfiguration config;

    public Structure(YamlConfiguration config) {
        this.config = config;
    }
    
    public static Structure loadStructure(String name) {
        return (new Structure(YamlConfiguration.loadConfiguration(Herobrine.class.getResourceAsStream(name))));
    }

    public boolean createStructure(Location loc) {
        for (String blockItem : this.config.getStringList("Blocks")) {
            String[] blockData = blockItem.split(",");
            if (blockData[1].equalsIgnoreCase("0")) {
                if (!Util.isValid(new Location(loc.getWorld(), loc.getBlockX() + Integer.parseInt(blockData[0]), loc.getBlockY() + Integer.parseInt(blockData[1]), loc.getBlockZ() + Integer.parseInt(blockData[2])).getBlock())) {
                    return false;
                }
            } else {
                if (blockData[1].equalsIgnoreCase("-1")) {
                    continue;
                }
                if (Util.isSolid(new Location(loc.getWorld(), loc.getBlockX() + Integer.parseInt(blockData[0]), loc.getBlockY() + Integer.parseInt(blockData[1]), loc.getBlockZ() + Integer.parseInt(blockData[2])).getBlock())) {
                    return false;
                }
            }
        }
        for (String blockItem : this.config.getStringList("Blocks")) {
            String[] blockData = blockItem.split(",");
            Location blockLoc = new Location(loc.getWorld(), loc.getBlockX() + Integer.parseInt(blockData[0]), loc.getBlockY() + Integer.parseInt(blockData[1]), loc.getBlockZ() + Integer.parseInt(blockData[2]));
            blockLoc.getBlock().setType(Material.getMaterial(blockData[3]));
            blockLoc.getBlock().setData(Byte.parseByte(blockData[4]));
        }
        return true;
    }
    
    public ArrayList<Block> getBlocks(Location loc) {
        ArrayList<Block> blocks = new ArrayList<Block>();
        for (String blockItem : this.config.getStringList("Blocks")) {
            String[] blockData = blockItem.split(",");
            blocks.add(new Location(loc.getWorld(), loc.getBlockX() + Integer.parseInt(blockData[0]), loc.getBlockY() + Integer.parseInt(blockData[1]), loc.getBlockZ() + Integer.parseInt(blockData[2])).getBlock());
        }
        return blocks;
    }
    
    public YamlConfiguration getConfigFile() {
        return this.config;
    }
}
