package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.ActionResult;
import org.bukkit.entity.Player;

public class ThrowPlayer extends Action {

    public ThrowPlayer() {
        super(true);
    }

    @Override
    public ActionResult callAction(Player player, Object[] metadata) {
        player.getLocation().setY(player.getLocation().getY() + 10);
        return (new ActionResult("Done."));
    }
}
