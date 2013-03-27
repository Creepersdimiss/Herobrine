package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.ActionResult;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class PlaceTorch extends Action {
    
    public PlaceTorch() {
        super(true);
    }

    @Override
    public ActionResult callAction(Player player, Object[] metadata) {
        Block block = Util.getNearbyLocation(player, 10).getBlock();
        if (Util.isValid(block)) {
            block.setType(Material.REDSTONE_TORCH_ON);
            Location loc = block.getLocation();
            return (new ActionResult("Done.", "Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ()));
        }
        return (new ActionResult("Failed, could not find a proper location!"));
    }
}
