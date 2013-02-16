package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.ActionResult;
import com.kreckin.herobrine.api.ActionType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class ThrowPlayer extends Action {

    public ThrowPlayer() {
        super(ActionType.STANDARD);
    }

    @Override
    public ActionResult callAction(Player player, Object[] metadata) {
        player.setVelocity(player.getLocation().getDirection().multiply(new Vector(0, 0.5, 0)));
        return (new ActionResult("Done."));
    }
}
