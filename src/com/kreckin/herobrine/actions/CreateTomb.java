package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.Structure;
import org.bukkit.entity.Player;

public class CreateTomb extends Action {
    
    public CreateTomb() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        Structure.loadStructure(player.getLocation(), "/com/kreckin/herobrine/structures/Tomb.yml").loadBlocks();
        return "Done.";
    }
}
