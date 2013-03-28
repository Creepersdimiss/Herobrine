package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.mobs.HellsGuardian;
import com.kreckin.herobrine.util.Util;
import org.bukkit.entity.Player;

public class SpawnCustomEntity extends Action {

    public SpawnCustomEntity() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        int toSpawn = 3 + Util.getRandom().nextInt(3);
        for (int id = 0; id < toSpawn; id++) {
            new HellsGuardian(Util.getNearbyLocation(player, 5 + Util.getRandom().nextInt(3)));
        }
        return ("Spawned: " + toSpawn);
    }
}
