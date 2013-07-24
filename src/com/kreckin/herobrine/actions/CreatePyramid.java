package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.Structure;
import com.kreckin.herobrine.util.Util;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class CreatePyramid extends Action {
    
    private final Random random = new Random();
    private final List<Material> materials = Arrays.asList(
        Material.NETHERRACK,
        Material.SOUL_SAND,
        Material.COBBLESTONE,
        Material.MOSSY_COBBLESTONE
    );

    public CreatePyramid() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        Location loc = Util.getNearbyLocation(player, 10);
        if (!Structure.loadStructure("/com/kreckin/herobrine/structures/Pyramid.yml").createStructure(loc)) {
            return "Failed, could not find a proper location!";
        }
        for (Block block : Structure.loadStructure("/com/kreckin/herobrine/structures/Pyramid.yml").getBlocks(loc)) {
            if (block.getType().equals(Material.STONE)) {
                block.setType(this.materials.get(random.nextInt(this.materials.size())));
            }
        }
        return ("Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
    }
}
