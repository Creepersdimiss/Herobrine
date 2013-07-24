package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import java.util.Random;
import org.bukkit.entity.Player;

public class SpinPlayer extends Action {
    
    private final Random random = new Random();
    
    public SpinPlayer() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        for (int spin = 0; spin < 5; spin++) {
            player.getLocation().setPitch(random.nextInt(360));
            player.getLocation().setYaw(random.nextInt(360));
        }
        return "Done.";
    }
}
