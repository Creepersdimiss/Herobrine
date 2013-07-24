package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class CreateTNTTrap extends Action {
    
    private final Random random = new Random();

    public CreateTNTTrap() {
        super(true);
    }
    
    @Override
    public String callAction(Player player, Object[] metadata) {
        Block plate = Util.getNearbyLocation(player, 5).getBlock();
        Block ground = plate.getLocation().subtract(0, 1, 0).getBlock();
        Block tnt = ground.getLocation().subtract(0, 1, 0).getBlock();
        if (Util.isValid(plate) && Util.isSolid(ground) && Util.isSolid(tnt)) {
            plate.setTypeId(random.nextBoolean() ? 70 : 72);
            tnt.setType(Material.TNT);
            Location loc = plate.getLocation();
            return ("Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
        }
        return "Failed, could not find a proper location!";
    }
}
