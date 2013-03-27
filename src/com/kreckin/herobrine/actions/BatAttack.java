package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class BatAttack extends Action {

    public BatAttack() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        int toSpawn = (Util.getRandom().nextInt(3)) + 3;
        for (int bat = 0; bat < toSpawn; bat++) {
            player.getWorld().spawnEntity(player.getLocation(), EntityType.BAT);
        }
        return ("Spawned: " + toSpawn);
    }
}
