package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import java.util.logging.Level;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public abstract class Action {

    private final boolean random;

    public Action(boolean random) {
        this.random = random;
    }

    public abstract String callAction(Player player, Object[] metadata);
    
    public String checkAction(Player player, Object[] metadata) {
        if (Herobrine.getConfigFile().getStringList("Herobrine.disallowedActions").contains(this.getClass().getSimpleName())) {
            return "Sorry, that action has been disallowed in the configuration file!";
        }
        if (Herobrine.getConfigFile().getStringList("Herobrine.disallowedWorlds").contains(player.getWorld().getName())) {
            return "Sorry, that world has been disallowed in the configuration file!";
        }
        if (!player.getGameMode().equals(GameMode.SURVIVAL) && Herobrine.getConfigFile().getBoolean("Herobrine.survivalOnly")) {
            return "Sorry, the player must be in survival mode.";
        }
        if (player.hasPermission("herobrine.ignore") && !player.isOp()) {
            return "Sorry, the player cannot have the \"herobrine.ignore\" permissions node!";
        }
        if (!Herobrine.getSupportManager().checkPermissions(player.getLocation()) && !Herobrine.getConfigFile().getBoolean("Herobrine.ignoreProtectedRegions")) {
            return "Sorry, events are not allowed in that region!";
        }
        Herobrine.getHotspotManager().addLocation(player.getLocation());
        Herobrine.log("Running Action: " + this.getClass().getSimpleName() + " & Player: " + player.getName(), Level.INFO);
        String result = this.callAction(player, metadata);
        Herobrine.log(result, Level.INFO);
        return result;
    }

    public boolean isRandom() {
        return this.random;
    }
}
