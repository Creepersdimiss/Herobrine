package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public abstract class CustomEntity {
    
    private final LivingEntity entity;
    private final ArrayList<ItemStack> drops;

    public CustomEntity(Location loc, EntityType type, String name) {
        this.entity = (LivingEntity) loc.getWorld().spawnEntity(loc, type);
        this.drops = new ArrayList<ItemStack>();
        this.onSpawn();
        this.entity.setCanPickupItems(false);
        this.entity.setCustomName(name);
        this.entity.setCustomNameVisible(true);
        this.entity.setRemoveWhenFarAway(false);
        Herobrine.getEntityManager().addEntity(this);
    }

    public abstract void onKilled();

    public abstract void onSpawn();
    
    public ArrayList<ItemStack> getDrops() {
        return this.drops;
    }
    
    public ItemStack getRandomDrop() {
        if (this.drops.isEmpty()) {
            return null;
        }
        if (this.drops.size() == 1) {
            return this.drops.get(0);
        }
        return this.drops.get(Util.getRandom().nextInt(this.drops.size() - 1));
    }

    public LivingEntity getEntity() {
        return this.entity;
    }
}
