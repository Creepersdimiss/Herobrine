package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public abstract class CustomEntity {
    
    private final LivingEntity entity;
    private final ItemStack drop;

    public CustomEntity(Location loc, EntityType type, String name, ItemStack drop) {
        this.entity = (LivingEntity) loc.getWorld().spawnEntity(loc, type);
        this.drop = drop;
        this.entity.setCanPickupItems(false);
        this.entity.setCustomName(name);
        this.entity.setCustomNameVisible(true);
        this.entity.setRemoveWhenFarAway(false);
        this.entity.getEquipment().setBootsDropChance(0);
        this.entity.getEquipment().setChestplateDropChance(0);
        this.entity.getEquipment().setHelmetDropChance(0);
        this.entity.getEquipment().setItemInHandDropChance(0);
        this.entity.getEquipment().setLeggingsDropChance(0);
        Herobrine.getEntityManager().addEntity(this);
        this.onSpawn();
    }
    
    public abstract void onSpawn();

    public abstract void onKilled();

    public ItemStack getDrop() {
        return this.drop;
    }

    public LivingEntity getEntity() {
        return this.entity;
    }
    
    public String getName() {
        return this.entity.getCustomName();
    }
}
