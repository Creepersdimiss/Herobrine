package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import org.bukkit.entity.Player;

public class ThrowPlayer extends Action {

    public ThrowPlayer() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        int jumpHeight = 5 + Util.getRandom().nextInt(5);
        player.getLocation().setY(player.getLocation().getY() + jumpHeight);
        return "Done.";
    }
}
