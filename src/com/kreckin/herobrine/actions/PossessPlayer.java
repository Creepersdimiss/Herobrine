package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.ActionResult;
import com.kreckin.herobrine.api.ActionType;
import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PossessPlayer extends Action {
    
    public PossessPlayer() {
        super(ActionType.STANDARD);
    }

    @Override
    public ActionResult callAction(Player player, Object[] metadata) {
        int time = (new Random().nextInt(10) + 5) * 20;
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, time, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, time, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, time, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, time, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, time, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, time, 1));
        return (new ActionResult("Done."));
    }
}
