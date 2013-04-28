package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.util.Validate;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public abstract class CustomEntity {
    
    private final LivingEntity entity;
    private final ItemStack drop;

    public CustomEntity(Location loc, EntityType type, String name, ItemStack drop) {
        Validate.isSafe(loc, type, name, drop);
        this.drop = drop;
        entity = (LivingEntity) loc.getWorld().spawnEntity(loc, type);
        entity.setCanPickupItems(false);
        entity.setCustomName(name);
        entity.setCustomNameVisible(true);
        entity.setRemoveWhenFarAway(false);
        entity.getEquipment().setBootsDropChance(0);
        entity.getEquipment().setChestplateDropChance(0);
        entity.getEquipment().setHelmetDropChance(0);
        entity.getEquipment().setItemInHandDropChance(0);
        entity.getEquipment().setLeggingsDropChance(0);
        onSpawn();
        Herobrine.getEntityManager().addEntity(this);
    }
    
    public abstract void onSpawn();

    public abstract void onKilled();

    public ItemStack getDrop() {
        return drop;
    }

    public LivingEntity getEntity() {
        return entity;
    }
    
    public String getName() {
        return entity.getCustomName();
    }
}
