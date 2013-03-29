package com.kreckin.herobrine.mobs;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.CustomEntity;
import com.kreckin.herobrine.items.MidnightGem;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class HellsGuardian extends CustomEntity {

    public HellsGuardian(Location loc) {
        super(loc, EntityType.ZOMBIE, "Hell's Guardian", new MidnightGem().getItem());
    }
    
    @Override
    public void onSpawn() {
        super.getEntity().setMaxHealth(Herobrine.getConfigFile().getInt("Herobrine.hellsGuardianHealth"));
        super.getEntity().setHealth(super.getEntity().getMaxHealth());
        super.getEntity().getEquipment().setBoots(Util.getColoredArmour(Material.LEATHER_BOOTS, Color.RED));
        super.getEntity().getEquipment().setLeggings(Util.getColoredArmour(Material.LEATHER_LEGGINGS, Color.RED));
        super.getEntity().getEquipment().setChestplate(Util.getColoredArmour(Material.LEATHER_CHESTPLATE, Color.RED));
        super.getEntity().getEquipment().setHelmet(Util.getColoredArmour(Material.LEATHER_HELMET, Color.RED));
        super.getEntity().getEquipment().setItemInHand(new ItemStack(Material.IRON_SWORD, 1));
    }

    @Override
    public void onKilled() {
        super.getEntity().getWorld().createExplosion(super.getEntity().getLocation(), 2);
    }
}
