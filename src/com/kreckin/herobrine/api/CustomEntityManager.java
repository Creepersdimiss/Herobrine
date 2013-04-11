package com.kreckin.herobrine.api;

import java.util.ArrayList;
import com.kreckin.herobrine.Herobrine;

public class CustomEntityManager {
    
    private final ArrayList<CustomEntity> entities;
    
    public CustomEntityManager() {
        this.entities = new ArrayList<CustomEntity>();
    }

    public void addEntity(CustomEntity entity) {
        if (this.entities.size() >= Herobrine.getConfigFile().getInt("Herobrine.maxCustomEntities")) {
            Herobrine.getLog().warning("Max custom entities count has been surpassed!");
            return;
        }
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
        if (this.entities.isEmpty()) {
            return null;
        }
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
