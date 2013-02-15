package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.ActionResult;
import com.kreckin.herobrine.api.ActionType;
import com.kreckin.herobrine.util.Util;
import org.bukkit.entity.Player;

public class SendMessage extends Action {

    public SendMessage() {
        super(ActionType.STANDARD);
    }

    @Override
    public ActionResult callAction(Player player, Object[] metadata) {
        String message = Util.getMessage("Herobrine.altarMessages");
        player.sendMessage(Util.formatString(message));
        return (new ActionResult("Done.", "Message: " + message));
    }
}
