package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.Structure;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class CreatePyramid extends Action {

    public CreatePyramid() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        Location loc = Util.getNearbyLocation(player, 10);
        if (!Structure.loadStructure(loc, "/com/kreckin/herobrine/structures/Pyramid.yml").createStructure()) {
            return "Failed, could not find a proper location!";
        }
        return ("Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
    }
}
