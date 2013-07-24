package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class CreateInfection extends Action {
    
    private final Random random = new Random();
    private final List<Material> materials = Arrays.asList(
        Material.NETHERRACK,
        Material.SOUL_SAND,
        Material.COBBLESTONE,
        Material.MOSSY_COBBLESTONE
    );
    
    public CreateInfection() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        for (int x = -Herobrine.getConfigFile().getInt("Herobrine.infectionSize"); x < Herobrine.getConfigFile().getInt("Herobrine.infectionSize"); x++) {
            for (int z = -Herobrine.getConfigFile().getInt("Herobrine.infectionSize"); z < Herobrine.getConfigFile().getInt("Herobrine.infectionSize"); z++) {
                Location loc = new Location(player.getWorld(), player.getLocation().getBlockX() + x, player.getLocation().getBlockY() - 1, player.getLocation().getBlockZ() + z);
                if (random.nextInt((int) player.getLocation().distance(loc)) == 0 && Util.isSolid(loc.getBlock())) {
                    loc.getBlock().setType(this.materials.get(random.nextInt(this.materials.size())));
                }
            }
        }
        return ("Location: " + player.getLocation().getBlockX() + ", " + player.getLocation().getBlockY() + ", " + player.getLocation().getBlockZ());
    }
}
