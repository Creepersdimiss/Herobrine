package com.kreckin.herobrine.mobs;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.CustomEntity;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class HellsGuardian extends CustomEntity {
    
    private final ArrayList<ItemStack> drops;
    
    public HellsGuardian(Location loc) {
        super(loc, EntityType.ZOMBIE);
        this.drops = new ArrayList<ItemStack>();
        this.drops.add(Util.getColoredArmour(Material.LEATHER_BOOTS, Color.RED));
        this.drops.add(Util.getColoredArmour(Material.LEATHER_LEGGINGS, Color.RED));
        this.drops.add(Util.getColoredArmour(Material.LEATHER_CHESTPLATE, Color.RED));
        this.drops.add(Util.getColoredArmour(Material.LEATHER_HELMET, Color.RED));
        this.drops.add(new ItemStack(Material.IRON_SWORD, 1));
    }
    
    @Override
    public void onSpawn() {
        super.getEntity().setMaxHealth(Herobrine.getConfigFile().getInt("Herobrine.entityHealth"));
        super.getEntity().setHealth(super.getEntity().getMaxHealth());
        super.getEntity().getEquipment().setBoots(Util.getColoredArmour(Material.LEATHER_BOOTS, Color.RED));
        super.getEntity().getEquipment().setLeggings(Util.getColoredArmour(Material.LEATHER_LEGGINGS, Color.RED));
        super.getEntity().getEquipment().setChestplate(Util.getColoredArmour(Material.LEATHER_CHESTPLATE, Color.RED));
        super.getEntity().getEquipment().setHelmet(Util.getColoredArmour(Material.LEATHER_HELMET, Color.RED));
        super.getEntity().getEquipment().setItemInHand(new ItemStack(Material.IRON_SWORD, 1));
    }

    @Override
    public void onKilled() {
        super.getEntity().getWorld().dropItem(super.getEntity().getLocation(), this.drops.get(Util.getRandom().nextInt(this.drops.size() - 1)));
    }
}
