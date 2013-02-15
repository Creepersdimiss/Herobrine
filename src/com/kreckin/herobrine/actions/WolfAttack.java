package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.ActionResult;
import com.kreckin.herobrine.api.ActionType;
import com.kreckin.herobrine.util.Util;
import java.util.Random;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;

public class WolfAttack extends Action {

    public WolfAttack() {
        super(ActionType.STANDARD);
    }

    @Override
    public ActionResult callAction(Player player, Object[] metadata) {
        int toSpawn = (new Random().nextInt(3)) + 3;
        for (int wolf = 0; wolf < toSpawn; wolf++) {
            Wolf theWolf = (Wolf) player.getWorld().spawnEntity(Util.getNearbyLocation(player, 5), EntityType.WOLF);
            theWolf.setAngry(true);
            theWolf.setTarget(player);
        }
        return (new ActionResult("Done.", "Spawned: " + toSpawn));
    }
}
