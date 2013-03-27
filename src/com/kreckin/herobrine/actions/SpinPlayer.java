package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.ActionResult;
import java.util.Random;
import org.bukkit.entity.Player;

public class SpinPlayer extends Action {
    
    public SpinPlayer() {
        super(true);
    }

    @Override
    public ActionResult callAction(Player player, Object[] metadata) {
        Random random = new Random();
        for (int spin = 0; spin < 5; spin++) {
            player.getLocation().setPitch(random.nextInt(360));
            player.getLocation().setYaw(random.nextInt(360));
        }
        return (new ActionResult("Done."));
    }
}
