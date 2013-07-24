package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import java.util.HashMap;
import java.util.Map;

public class CustomEntityManager {
    
    private final Map<Integer, CustomEntity> entities = new HashMap<>();

    public void addEntity(CustomEntity entity) {
        if (entities.size() >= Herobrine.getConfigFile().getInt("Herobrine.maxCustomEntities")) {
            Herobrine.getInstance().getLogger().warning("Max custom entities count has been surpassed!");
            return;
        }
        entities.put(entity.getEntity().getEntityId(), entity);
        entity.onSpawn();
    }
    
    public void removeEntity(int id) {
        entities.remove(id);
    }
    
    public Map<Integer, CustomEntity> getEntities() {
        return entities;
    }
}
