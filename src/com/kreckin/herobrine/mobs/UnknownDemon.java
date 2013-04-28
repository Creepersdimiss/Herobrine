package com.kreckin.herobrine.mobs;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.CustomEntity;
import com.kreckin.herobrine.items.BloodGem;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class UnknownDemon extends CustomEntity {
    
    public UnknownDemon(Location loc) {
        super(loc, EntityType.SKELETON, "Unknown Demon", new BloodGem().getItem());
    }

    @Override
    public void onSpawn() {
        getEntity().setMaxHealth(Herobrine.getConfigFile().getInt("Herobrine.unknownDemonHealth"));
        getEntity().setHealth(getEntity().getMaxHealth());
        getEntity().getEquipment().setBoots(Util.getColoredArmour(Material.LEATHER_BOOTS, Color.MAROON));
        getEntity().getEquipment().setLeggings(Util.getColoredArmour(Material.LEATHER_LEGGINGS, Color.MAROON));
        getEntity().getEquipment().setChestplate(Util.getColoredArmour(Material.LEATHER_CHESTPLATE, Color.MAROON));
        getEntity().getEquipment().setHelmet(Util.getColoredArmour(Material.LEATHER_HELMET, Color.MAROON));
        getEntity().getEquipment().setItemInHand(new ItemStack(Material.GOLD_SWORD, 1));
    }
    
    @Override
    public void onKilled() {
        getEntity().getWorld().createExplosion(getEntity().getLocation(), 2, true);
    }
}