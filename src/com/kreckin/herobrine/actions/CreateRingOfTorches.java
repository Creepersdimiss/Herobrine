package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.Structure;
import org.bukkit.entity.Player;

public class CreateRingOfTorches extends Action {
    
    public CreateRingOfTorches() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        if (!Structure.loadStructure("/com/kreckin/herobrine/structures/RingOfTorches.yml").createStructure(player.getLocation())) {
            return "Failed, could not find a proper location!";
        }
        return ("Location: " + player.getLocation().getBlockX() + ", " + player.getLocation().getBlockY() + ", " + player.getLocation().getBlockZ());
    }
}
