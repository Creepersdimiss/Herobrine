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
        new HellsGuardian(Util.getNearbyLocation(player, 5));
        return "Done.";
    }
}
