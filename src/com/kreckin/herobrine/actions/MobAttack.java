package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class MobAttack extends Action {
    
    private final ArrayList<EntityType> allowedMobs;
    
    public MobAttack() {
        super(true);
        this.allowedMobs = new ArrayList<EntityType>();
        for (String mobName : Herobrine.getConfigFile().getStringList("Herobrine.allowedMobs")) {
            if (EntityType.fromName(mobName) != null) {
                this.allowedMobs.add(EntityType.fromName(mobName));
            }
        }
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        int amountToSpawn = 3 + (Util.getRandom().nextInt(5));
        for (int id = 0; id < amountToSpawn; id++) {
            if (this.allowedMobs.isEmpty()) {
                break;
            }
            EntityType entity;
            if (this.allowedMobs.size() == 1) {
                entity = this.allowedMobs.get(0);
            } else {
                entity = this.allowedMobs.get(Util.getRandom().nextInt(this.allowedMobs.size() - 1));
            }
            player.getWorld().spawnEntity(Util.getNearbyLocation(player, Util.getRandom().nextInt(10)), entity);
        }
        new SendMessage().checkAction(player, metadata);
        return ("Spawned: " + amountToSpawn);
    }
}
