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
        super.getEntity().setMaxHealth(Herobrine.getConfigFile().getInt("Herobrine.unknownDemonHealth"));
        super.getEntity().setHealth(super.getEntity().getMaxHealth());
        super.getEntity().getEquipment().setBoots(Util.getColoredArmour(Material.LEATHER_BOOTS, Color.MAROON));
        super.getEntity().getEquipment().setLeggings(Util.getColoredArmour(Material.LEATHER_LEGGINGS, Color.MAROON));
        super.getEntity().getEquipment().setChestplate(Util.getColoredArmour(Material.LEATHER_CHESTPLATE, Color.MAROON));
        super.getEntity().getEquipment().setHelmet(Util.getColoredArmour(Material.LEATHER_HELMET, Color.MAROON));
        super.getEntity().getEquipment().setItemInHand(new ItemStack(Material.GOLD_SWORD, 1));
    }
    
    @Override
    public void onKilled() {
        super.getEntity().getWorld().createExplosion(super.getEntity().getLocation(), 2, true);
    }
}