package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

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
    
    public void loadBlocks() {
        for (String blockItem : this.config.getStringList("Blocks")) {
            String[] blockData = blockItem.split(",");
            //Location tempLoc = this.loc;
            Location blockLoc = new Location(this.loc.getWorld(), this.loc.getBlockX() + Integer.parseInt(blockData[0]), this.loc.getBlockY() + Integer.parseInt(blockData[1]), this.loc.getBlockZ() + Integer.parseInt(blockData[2]));
            blockLoc.getBlock().setType(Material.getMaterial(blockData[3]));
            blockLoc.getBlock().setData(Byte.parseByte(blockData[4]));
        }
    }
    
    public YamlConfiguration getConfigFile() {
        return this.config;
    }
    
    public Location getLocation() {
        return this.loc;
    }
}
