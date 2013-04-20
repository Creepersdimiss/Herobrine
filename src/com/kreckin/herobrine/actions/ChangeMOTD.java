package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.server.ServerListPingEvent;

public class ChangeMOTD extends Action {
    
    public ChangeMOTD() {
        super(false);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        String motd = Util.getMessage("Herobrine.altarMessages");
        if (motd == null) {
            return "Failed, there are no messages in the configuration file!";
        }
        ((ServerListPingEvent) metadata[0]).setMotd(motd);
        ((ServerListPingEvent) metadata[0]).setMaxPlayers(666);
        return "Done.";
    }
}
