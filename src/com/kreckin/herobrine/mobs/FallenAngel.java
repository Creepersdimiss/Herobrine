package com.kreckin.herobrine.mobs;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.CustomEntity;
import com.kreckin.herobrine.items.GreedGem;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class FallenAngel extends CustomEntity {
    
    public FallenAngel(Location loc) {
        super(loc, EntityType.ZOMBIE, "Fallen Angel", new GreedGem().getItem());
    }

    @Override
    public void onSpawn() {
        getEntity().setMaxHealth(Herobrine.getConfigFile().getInt("Herobrine.fallenAngelHealth"));
        getEntity().setHealth(getEntity().getMaxHealth());
        getEntity().getEquipment().setBoots(Util.getColoredArmour(Material.LEATHER_BOOTS, Color.SILVER));
        getEntity().getEquipment().setLeggings(Util.getColoredArmour(Material.LEATHER_LEGGINGS, Color.SILVER));
        getEntity().getEquipment().setChestplate(Util.getColoredArmour(Material.LEATHER_CHESTPLATE, Color.SILVER));
        getEntity().getEquipment().setHelmet(Util.getColoredArmour(Material.LEATHER_HELMET, Color.SILVER));
        getEntity().getEquipment().setItemInHand(new ItemStack(Material.REDSTONE_TORCH_ON, 1));
    }
    
    @Override
    public void onKilled() {
        getEntity().getWorld().createExplosion(getEntity().getLocation(), 2, true);
    }
}
