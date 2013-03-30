package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class AddHotspot extends Action {
    
    public AddHotspot() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        Player thePlayer = Bukkit.getServer().getOnlinePlayers()[Util.getRandom().nextInt(Bukkit.getServer().getOnlinePlayers().length - 1)];
        Herobrine.getHotspotManager().addLocation(thePlayer.getLocation());
        return ("Location: " + player.getLocation().getBlockX() + ", " + player.getLocation().getBlockY() + ", " + player.getLocation().getBlockZ());
    }
}
