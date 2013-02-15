package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.ActionResult;
import com.kreckin.herobrine.api.ActionType;
import java.util.Random;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class BatAttack extends Action {

    public BatAttack() {
        super(ActionType.STANDARD);
    }

    @Override
    public ActionResult callAction(Player player, Object[] metadata) {
        int toSpawn = (new Random().nextInt(3)) + 3;
        for (int bat = 0; bat < toSpawn; bat++) {
            player.getWorld().spawnEntity(player.getLocation(), EntityType.BAT);
        }
        return (new ActionResult("Done.", "Spawned: " + toSpawn));
    }
}
