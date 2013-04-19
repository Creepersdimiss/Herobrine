package com.kreckin.herobrine.listeners;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandListener implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if (!(cs instanceof Player)) {
            Herobrine.getLog().warning("You can only use these commands if you are a player!");
            return true;
        }
        if (!cs.hasPermission("herobrine.commands") && !cs.isOp()) {
            cs.sendMessage(Util.formatString("Sorry, you do not have permission to do this!"));
            return true;
        }
        if (strings.length == 1 && strings[0].equalsIgnoreCase("help")) {
            String knownActions = "Known actions: ";
            for (Action action : Herobrine.getActionManager().getActions()) {
                knownActions += action.getClass().getSimpleName() + ", ";
            }
            knownActions = knownActions.substring(0, knownActions.length() - 2);
            cs.sendMessage(Util.formatString(knownActions));
            return true;
        }
        if (strings.length == 2) {
            Action foundAction = null;
            for (Action action : Herobrine.getActionManager().getActions()) {
                if (action.getClass().getSimpleName().equalsIgnoreCase(strings[0])) {
                    foundAction = action;
                    break;
                }
            }
            if (foundAction != null) {
                if (!foundAction.isRandom()) {
                    cs.sendMessage(Util.formatString("Sorry, this is not an action that can be run by commands!"));
                    return true;
                }
                Player player = Bukkit.getPlayer(strings[1]);
                if (player == null) {
                    cs.sendMessage(Util.formatString("Unknown player!"));
                } else {
                    cs.sendMessage(Util.formatString(foundAction.checkAction(player, null)));
                }
            } else {
                cs.sendMessage(Util.formatString("Unknown action! Type \"/(hb, herobrine, hbu) help\" for all actions!"));
            }
        } else {
            cs.sendMessage(Util.formatString("Run an action with \"/(hb, herobrine, hbu) action username\", or type \"/(hb, herobrine, hbu) help\" for all actions!"));
        }
        return true;
    }
}
