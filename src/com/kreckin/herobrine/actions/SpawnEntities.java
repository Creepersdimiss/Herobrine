package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.CustomEntityManager;
import com.kreckin.herobrine.api.CustomEntityType;
import com.kreckin.herobrine.util.Util;
import org.bukkit.entity.Player;

public class SpawnEntities extends Action {

    public SpawnEntities() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        int toSpawn = 3 + Util.getRandom().nextInt(3);
        for (int id = 0; id < toSpawn; id++) {
            CustomEntityManager.spawnEntity(CustomEntityType.values()[Util.getRandom().nextInt(CustomEntityType.values().length - 1)], Util.getNearbyLocation(player, 5));
        }
        return ("Spawned: " + toSpawn);
    }
}
