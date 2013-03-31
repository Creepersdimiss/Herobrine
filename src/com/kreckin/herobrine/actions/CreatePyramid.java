package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.Structure;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class CreatePyramid extends Action {
    
    private final ArrayList<Material> materials;

    public CreatePyramid() {
        super(true);
        this.materials = new ArrayList<Material>();
        this.materials.add(Material.NETHERRACK);
        this.materials.add(Material.SOUL_SAND);
        this.materials.add(Material.COBBLESTONE);
        this.materials.add(Material.MOSSY_COBBLESTONE);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        Location loc = Util.getNearbyLocation(player, 10);
        if (!Structure.loadStructure("/com/kreckin/herobrine/structures/Pyramid.yml").createStructure(loc)) {
            return "Failed, could not find a proper location!";
        }
        for (Block block : Structure.loadStructure("/com/kreckin/herobrine/structures/Pyramid.yml").getBlocks(loc)) {
            if (block.getType().equals(Material.STONE)) {
                block.setType(this.materials.get(Util.getRandom().nextInt(this.materials.size())));
            }
        }
        return ("Location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ());
    }
}
