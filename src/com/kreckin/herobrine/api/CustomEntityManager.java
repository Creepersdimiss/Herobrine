package com.kreckin.herobrine.api;

import com.kreckin.herobrine.mobs.FallenAngel;
import com.kreckin.herobrine.mobs.HellsGuardian;
import java.util.ArrayList;
import org.bukkit.Location;

public class CustomEntityManager {
    
    private final ArrayList<CustomEntity> entities;
    
    public CustomEntityManager() {
        this.entities = new ArrayList<CustomEntity>();
    }
    
    public static CustomEntity spawnEntity(CustomEntityType type, Location loc) {
        if (type.equals(CustomEntityType.HELLS_GUARDIAN)) {
            return (new HellsGuardian(loc));
        } else if (type.equals(CustomEntityType.FALLEN_ANGEL)) {
            return (new FallenAngel(loc));
        }
        return null;
    }
    
    public void addEntity(CustomEntity entity) {
        if (this.getEntity(entity.getEntity().getEntityId()) != null) {
            return;
        }
        this.entities.add(entity);
    }
    
    public void removeEntity(int id) {
        if (this.getEntity(id) == null) {
            return;
        }
        this.entities.remove(this.getEntity(id));
    }
    
    public CustomEntity getEntity(int id) {
        for (CustomEntity entity : this.entities) {
            if (entity.getEntity().getEntityId() == id) {
                return entity;
            }
        }
        return null;
    }
    
    public ArrayList<CustomEntity> getEntities() {
        return this.entities;
    }
}
