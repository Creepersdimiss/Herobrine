package com.kreckin.herobrine.api;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public abstract class CustomEntity {
    
    private final LivingEntity entity;

    public CustomEntity(Location loc, EntityType type) {
        this.entity = (LivingEntity) loc.getWorld().spawnEntity(loc, type);
    }

    public abstract void onKilled();

    public abstract void onSpawn();

    public LivingEntity getEntity() {
        return this.entity;
    }
}
