package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import java.util.Random;
import org.bukkit.entity.Player;

public class ThrowPlayer extends Action {
    
    private final Random random = new Random();

    public ThrowPlayer() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        int jumpHeight = 5 + random.nextInt(5);
        player.getLocation().setY(player.getLocation().getY() + jumpHeight);
        return "Done.";
    }
}
