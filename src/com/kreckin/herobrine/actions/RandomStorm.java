package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.ActionResult;
import org.bukkit.entity.Player;

public class RandomStorm extends Action {
    
    public RandomStorm() {
        super(true);
    }

    @Override
    public ActionResult callAction(Player player, Object[] metadata) {
        player.getWorld().setStorm(true);
        player.getWorld().setTime(14200);
        return (new ActionResult("Done."));
    }
}
