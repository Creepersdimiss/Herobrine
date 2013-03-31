package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class CreateInfection extends Action {
    
    private final ArrayList<Material> materials;
    
    public CreateInfection() {
        super(true);
        this.materials = new ArrayList<Material>();
        this.materials.add(Material.NETHERRACK);
        this.materials.add(Material.SOUL_SAND);
        this.materials.add(Material.COBBLESTONE);
        this.materials.add(Material.MOSSY_COBBLESTONE);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        for (int x = -Herobrine.getConfigFile().getInt("Herobrine.infectionSize"); x < Herobrine.getConfigFile().getInt("Herobrine.infectionSize"); x++) {
            for (int z = -Herobrine.getConfigFile().getInt("Herobrine.infectionSize"); z < Herobrine.getConfigFile().getInt("Herobrine.infectionSize"); z++) {
                Location loc = new Location(player.getWorld(), player.getLocation().getBlockX() + x, player.getLocation().getBlockY() - 1, player.getLocation().getBlockZ() + z);
                if (Util.getRandom().nextInt((int) player.getLocation().distance(loc)) == 0 && Util.isSolid(loc.getBlock())) {
                    loc.getBlock().setType(this.materials.get(Util.getRandom().nextInt(this.materials.size())));
                }
            }
        }
        return ("Location: " + player.getLocation().getBlockX() + ", " + player.getLocation().getBlockY() + ", " + player.getLocation().getBlockZ());
    }
}
