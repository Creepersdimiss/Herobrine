package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.Structure;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class CreateTomb extends Action {
    
    public CreateTomb() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        Location loc = Util.getNearbyLocation(player, 30);
        if (!Structure.loadStructure(loc, "/com/kreckin/herobrine/structures/Tomb.yml").createStructure()) {
            return "Failed, could not find a proper location!";
        }
        return ("Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
    }
}
