package com.kreckin.herobrine.mobs;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.CustomEntity;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FallenAngel extends CustomEntity {
    
    public FallenAngel(Location loc) {
        super(loc);
        super.getDrops().add(Util.getColoredArmour(Material.LEATHER_BOOTS, Color.SILVER));
        super.getDrops().add(Util.getColoredArmour(Material.LEATHER_LEGGINGS, Color.SILVER));
        super.getDrops().add(Util.getColoredArmour(Material.LEATHER_CHESTPLATE, Color.SILVER));
        super.getDrops().add(Util.getColoredArmour(Material.LEATHER_HELMET, Color.SILVER));
        super.getDrops().add(new ItemStack(Material.REDSTONE_TORCH_ON, 1));
    }

    @Override
    public void onSpawn() {
        super.getEntity().setMaxHealth(Herobrine.getConfigFile().getInt("Herobrine.fallenAngelHealth"));
        super.getEntity().setHealth(super.getEntity().getMaxHealth());
        super.getEntity().getEquipment().setBoots(Util.getColoredArmour(Material.LEATHER_BOOTS, Color.SILVER));
        super.getEntity().getEquipment().setLeggings(Util.getColoredArmour(Material.LEATHER_LEGGINGS, Color.SILVER));
        super.getEntity().getEquipment().setChestplate(Util.getColoredArmour(Material.LEATHER_CHESTPLATE, Color.SILVER));
        super.getEntity().getEquipment().setHelmet(Util.getColoredArmour(Material.LEATHER_HELMET, Color.SILVER));
        super.getEntity().getEquipment().setItemInHand(new ItemStack(Material.REDSTONE_TORCH_ON, 1));
    }
    
    @Override
    public void onKilled() {
        
    }
}
