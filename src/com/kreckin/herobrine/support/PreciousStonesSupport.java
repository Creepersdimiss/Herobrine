package com.kreckin.herobrine.support;

import com.kreckin.herobrine.api.Support;
import net.sacredlabyrinth.Phaed.PreciousStones.FieldFlag;
import net.sacredlabyrinth.Phaed.PreciousStones.PreciousStones;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PreciousStonesSupport extends Support {
    
    public PreciousStonesSupport() {
        super("PreciousStones");
    }

    @Override
    public boolean checkPermissions(Player player, Plugin plugin) {
        return (!PreciousStones.API().isFieldProtectingArea(FieldFlag.ALL, player.getLocation()));
    }
}
