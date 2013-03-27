package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import org.bukkit.entity.Player;

public class SpinPlayer extends Action {
    
    public SpinPlayer() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        for (int spin = 0; spin < 5; spin++) {
            player.getLocation().setPitch(Util.getRandom().nextInt(360));
            player.getLocation().setYaw(Util.getRandom().nextInt(360));
        }
        return "Done.";
    }
}
