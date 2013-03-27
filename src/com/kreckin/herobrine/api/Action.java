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

    public ActionResult checkAction(Player player, Object[] metadata) {
        if (Herobrine.getConfigFile().getStringList("Herobrine.disallowedActions").contains(this.getClass().getSimpleName())) {
            return (new ActionResult("Sorry, that action has been disallowed in the configuration file!"));
        }
        if (Herobrine.getConfigFile().getStringList("Herobrine.disallowedWorlds").contains(player.getWorld().getName())) {
            return (new ActionResult("Sorry, that world has been disallowed in the configuration file!"));
        }
        if (!player.getGameMode().equals(GameMode.SURVIVAL) && Herobrine.getConfigFile().getBoolean("Herobrine.survivalOnly")) {
            return (new ActionResult("Sorry, the player must be in survival mode."));
        }
        if (player.hasPermission("herobrine.ignore") && !player.isOp()) {
            return (new ActionResult("Sorry, the player cannot have the \"herobrine.ignore\" permissions node!"));
        }
        if (!Herobrine.getSupportManager().checkPermissions(player) && !Herobrine.getConfigFile().getBoolean("Herobrine.ignoreProtectedRegions")) {
            return (new ActionResult("Sorry, events are not allowed in that region!"));
        }
        Herobrine.log("Running Action: " + this.getClass().getSimpleName() + " & Player: " + player.getName(), Level.INFO);
        ActionResult result = this.callAction(player, metadata);
        Herobrine.log(result.getMessage(), Level.INFO);
        if (result.getData() != null) {
            Herobrine.log("Details: " + result.getData(), Level.INFO);
        }
        return result;
    }
    
    public abstract ActionResult callAction(Player player, Object[] metadata);

    public boolean isRandom() {
        return this.random;
    }
}
