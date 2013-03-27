package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import org.bukkit.entity.Player;

public class ThrowPlayer extends Action {

    public ThrowPlayer() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        player.getLocation().setY(player.getLocation().getY() + 10);
        return "Done.";
    }
}
