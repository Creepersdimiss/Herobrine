package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.mobs.FallenAngel;
import com.kreckin.herobrine.mobs.HellsGuardian;
import com.kreckin.herobrine.mobs.UnknownDemon;
import com.kreckin.herobrine.util.Util;
import org.bukkit.entity.Player;

public class SpawnEntities extends Action {

    public SpawnEntities() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        switch (Util.getRandom().nextInt(3)) {
            
            case 0:
                new HellsGuardian(player.getLocation());
                break;
                
            case 1:
                new FallenAngel(player.getLocation());
                break;
                
            default:
                new UnknownDemon(player.getLocation());
                break;
        }
        return "Done.";
    }
}
