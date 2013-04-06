package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import org.bukkit.Effect;
import org.bukkit.entity.Player;

public class EffectExplosion extends Action {
    
    public EffectExplosion() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        for (int count = 0; count < 7; count++) {
            for (Effect effect : Effect.values()) {
                player.getWorld().playEffect(player.getLocation(), effect, 2);
            }
        }
        return "Done.";
    }
}
