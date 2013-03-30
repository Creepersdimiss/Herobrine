package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class CreateInfection extends Action {
    
    public CreateInfection() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        for (int x = -Herobrine.getConfigFile().getInt("Herobrine.infectionSize"); x < Herobrine.getConfigFile().getInt("Herobrine.infectionSize"); x++) {
            for (int z = -Herobrine.getConfigFile().getInt("Herobrine.infectionSize"); z < Herobrine.getConfigFile().getInt("Herobrine.infectionSize"); z++) {
                Location loc = new Location(player.getWorld(), player.getLocation().getBlockX() + x, player.getLocation().getBlockY() - 1, player.getLocation().getBlockZ() + z);
                if (Util.getRandom().nextInt((int) player.getLocation().distance(loc)) == 0 && Util.isSolid(loc.getBlock())) {
                    loc.getBlock().setType(Util.getRandom().nextBoolean() ? Material.NETHERRACK : Material.SOUL_SAND);
                }
            }
        }
        return "Done.";
    }
}
