package com.kreckin.herobrine.api;

import java.util.ArrayList;
import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.util.Validate;

public class CustomEntityManager {
    
    private final ArrayList<CustomEntity> entities;
    
    public CustomEntityManager() {
        entities = new ArrayList<CustomEntity>();
    }

    public void addEntity(CustomEntity entity) {
        Validate.isSafe(entity);
        if (entities.size() >= Herobrine.getConfigFile().getInt("Herobrine.maxCustomEntities")) {
            Herobrine.getLog().warning("Max custom entities count has been surpassed!");
            return;
        }
        if (getEntity(entity.getEntity().getEntityId()) != null) {
            return;
        }
        entities.add(entity);
    }
    
    public void removeEntity(int id) {
        Validate.isSafe(id);
        if (getEntity(id) == null) {
            return;
        }
        entities.remove(getEntity(id));
    }
    
    public CustomEntity getEntity(int id) {
        Validate.isSafe(id);
        if (entities.isEmpty()) {
            return null;
        }
        for (CustomEntity entity : entities) {
            if (entity.getEntity().getEntityId() == id) {
                return entity;
            }
        }
        return null;
    }
    
    public ArrayList<CustomEntity> getEntities() {
        return entities;
    }
}
