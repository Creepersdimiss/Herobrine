package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class CreateGrave extends Action {
    
    private final Random random = new Random();
    
    public CreateGrave() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        Block sign = Util.getNearbyLocation(player, 5).getBlock();
        Block stone1 = sign.getLocation().add(0, -1, 1).getBlock();
        Block stone2 = sign.getLocation().add(0, -1, 2).getBlock();
        Block stone3 = sign.getLocation().add(0, -1, 0).getBlock();
        if (Util.isValid(sign) && Util.isSolid(stone1) && Util.isSolid(stone2) && Util.isSolid(stone3)) {
            sign.setType(Material.SIGN_POST);
            stone1.setType(random.nextBoolean() ? Material.COBBLESTONE : Material.MOSSY_COBBLESTONE);
            stone2.setType(random.nextBoolean() ? Material.COBBLESTONE : Material.MOSSY_COBBLESTONE);
            stone3.setType(random.nextBoolean() ? Material.COBBLESTONE : Material.MOSSY_COBBLESTONE);
            Sign signIn = (Sign) sign.getState();
            signIn.setLine(1, player.getName());
            signIn.update();
            Location loc = sign.getLocation();
            return ("Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
        }
        return "Failed, could not find a proper location!";
    }
}
