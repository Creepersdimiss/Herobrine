package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class AltarSummon extends Action {

    public AltarSummon() {
        super(false);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        player.getWorld().createExplosion(((Block) metadata[0]).getLocation(), 3F);
        player.getWorld().setStorm(true);
        player.getWorld().setTime(14200);
        player.getWorld().strikeLightning(((Block) metadata[0]).getLocation());
        for (Entity entity : player.getNearbyEntities(30, 30, 30)) {
            if (entity instanceof Player) {
                ((Player) entity).sendMessage(Util.formatString(Util.getMessage("Herobrine.altarMessages")));
            }
        }
        int amountToSpawn = 5 + (Util.getRandom().nextInt(5));
        for (int id = 0; id < amountToSpawn; id++) {
            EntityType entity = Util.getRandomMob();
            if (entity == null) {
                continue;
            }
            player.getWorld().spawnEntity(Util.getNearbyLocation(player, Util.getRandom().nextInt(10)), entity);
        }
        player.sendMessage(Util.formatString(Util.getMessage("Herobrine.altarMessages")));
        return ("Spawned: " + amountToSpawn);
    }
}
