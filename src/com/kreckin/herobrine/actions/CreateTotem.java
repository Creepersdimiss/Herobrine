package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;

public class CreateTotem extends Action {
    
    public CreateTotem() {
        super(true);
    }
    
    @Override
    public String callAction(Player player, Object[] metadata) {
        Block fence = Util.getNearbyLocation(player, 5).getBlock();
        Block head = fence.getLocation().add(0, 1, 0).getBlock();
        if (Util.isValid(fence) && Util.isValid(head)) {
            fence.setType(Material.FENCE);
            head.setType(Material.SKULL);
            ((Skull) head).setOwner(player.getName());
            Location loc = fence.getLocation();
            return ("Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ() + " & Skin: \"" + player.getName() + "\"");
        }
        return "Failed, could not find a proper location!";
    }
}
