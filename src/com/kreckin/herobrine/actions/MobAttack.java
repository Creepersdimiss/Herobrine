package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class MobAttack extends Action {
    
    private final Random random = new Random();
    private final List<EntityType> allowedMobs = new ArrayList<>();
    
    public MobAttack() {
        super(true);
        for (String mobName : Herobrine.getConfigFile().getStringList("Herobrine.allowedMobs")) {
            if (EntityType.fromName(mobName) != null) {
                allowedMobs.add(EntityType.fromName(mobName));
            }
        }
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        int amountToSpawn = 3 + (random.nextInt(5));
        for (int id = 0; id < amountToSpawn; id++) {
            if (this.allowedMobs.isEmpty()) {
                break;
            }
            EntityType entity;
            if (this.allowedMobs.size() == 1) {
                entity = this.allowedMobs.get(0);
            } else {
                entity = this.allowedMobs.get(random.nextInt(this.allowedMobs.size() - 1));
            }
            player.getWorld().spawnEntity(Util.getNearbyLocation(player, random.nextInt(10)), entity);
        }
        new SendMessage().checkAction(player, metadata);
        return ("Spawned: " + amountToSpawn);
    }
}
