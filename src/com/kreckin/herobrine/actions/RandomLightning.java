package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.ActionResult;
import com.kreckin.herobrine.api.ActionType;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class RandomLightning extends Action {

    public RandomLightning() {
        super(ActionType.STANDARD);
    }

    @Override
    public ActionResult callAction(Player player, Object[] metadata) {
        Location loc = Util.getNearbyLocation(player, 10);
        player.getWorld().strikeLightning(loc);
        return (new ActionResult("Done.", "Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ()));
    }
}
