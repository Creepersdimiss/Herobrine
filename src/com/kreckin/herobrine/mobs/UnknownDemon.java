package com.kreckin.herobrine.mobs;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.CustomEntity;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class UnknownDemon extends CustomEntity {
    
    public UnknownDemon(Location loc) {
        super(loc);
        super.getDrops().add(Util.getColoredArmour(Material.LEATHER_BOOTS, Color.MAROON));
        super.getDrops().add(Util.getColoredArmour(Material.LEATHER_LEGGINGS, Color.MAROON));
        super.getDrops().add(Util.getColoredArmour(Material.LEATHER_CHESTPLATE, Color.MAROON));
        super.getDrops().add(Util.getColoredArmour(Material.LEATHER_HELMET, Color.MAROON));
        super.getDrops().add(new ItemStack(Material.BOW, 1));
    }

    @Override
    public void onSpawn() {
        super.getEntity().setCanPickupItems(false);
        super.getEntity().setCustomName("Unknown Demon");
        super.getEntity().getWorld().strikeLightning(super.getEntity().getLocation());
        super.getEntity().setMaxHealth(Herobrine.getConfigFile().getInt("Herobrine.unknownDemonHealth"));
        super.getEntity().setHealth(super.getEntity().getMaxHealth());
        super.getEntity().getEquipment().setBoots(Util.getColoredArmour(Material.LEATHER_BOOTS, Color.MAROON));
        super.getEntity().getEquipment().setLeggings(Util.getColoredArmour(Material.LEATHER_LEGGINGS, Color.MAROON));
        super.getEntity().getEquipment().setChestplate(Util.getColoredArmour(Material.LEATHER_CHESTPLATE, Color.MAROON));
        super.getEntity().getEquipment().setHelmet(Util.getColoredArmour(Material.LEATHER_HELMET, Color.MAROON));
        super.getEntity().getEquipment().setItemInHand(new ItemStack(Material.BOW, 1));
    }
    
    @Override
    public void onKilled() {
        super.getEntity().getWorld().strikeLightning(super.getEntity().getLocation());
    }
}