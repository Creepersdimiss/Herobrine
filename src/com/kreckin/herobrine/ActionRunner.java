package com.kreckin.herobrine;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ActionRunner implements Runnable {
    
    private final Random random = new Random();

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (Util.shouldAct(player)) {
                Action action = Herobrine.getActionManager().getActions().get(random.nextInt(Herobrine.getActionManager().getActions().size() - 1));
                if (!action.isRandom()) {
                    return;
                }
                action.checkAction(player, null);
            }
        }
    }
}
