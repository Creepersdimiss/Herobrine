package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import org.bukkit.entity.Player;

public class SendMessage extends Action {

    public SendMessage() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        String message = Util.getMessage("Herobrine.altarMessages");
        if (message == null) {
            return "Failed, there are no messages in the configuration file!";
        }
        player.sendMessage(Util.formatString(message));
        return ("Message: " + message);
    }
}
