package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class RandomLightning extends Action {

    public RandomLightning() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        Location loc = Util.getNearbyLocation(player, 10);
        player.getWorld().strikeLightning(loc);
        return ("Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
    }
}
