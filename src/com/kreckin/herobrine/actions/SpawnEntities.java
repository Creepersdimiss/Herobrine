package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.mobs.FallenAngel;
import com.kreckin.herobrine.mobs.HellsGuardian;
import com.kreckin.herobrine.util.Util;
import org.bukkit.entity.Player;

public class SpawnEntities extends Action {

    public SpawnEntities() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        if (Util.getRandom().nextBoolean()) {
            new HellsGuardian(player.getLocation());
        } else {
            new FallenAngel(player.getLocation());
        }
        return "Done.";
    }
}
