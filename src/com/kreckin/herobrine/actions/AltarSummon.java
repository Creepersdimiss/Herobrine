package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class AltarSummon extends Action {

    private final Random random = new Random();
    private final List<EntityType> allowedMobs = new ArrayList<>();

    public AltarSummon() {
        super(false);
        for (String mobName : Herobrine.getConfigFile().getStringList("Herobrine.allowedMobs")) {
            if (EntityType.fromName(mobName) != null) {
                allowedMobs.add(EntityType.fromName(mobName));
            }
        }
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        player.getWorld().createExplosion(((Block) metadata[0]).getLocation(), 3F);
        player.getWorld().setStorm(true);
        player.getWorld().setTime(14200);
        player.getWorld().strikeLightning(((Block) metadata[0]).getLocation());
        for (Entity entity : player.getNearbyEntities(30, 30, 30)) {
            if (entity instanceof Player) {
                ((Player) entity).sendMessage(Util.formatString(Util.getMessage("Herobrine.altarMessages")));
            }
        }
        int amountToSpawn = 5 + (random.nextInt(5));
        for (int id = 0; id < amountToSpawn; id++) {
            if (allowedMobs.isEmpty()) {
                break;
            }
            EntityType entity;
            if (this.allowedMobs.size() == 1) {
                entity = this.allowedMobs.get(0);
            } else {
                entity = this.allowedMobs.get(random.nextInt(this.allowedMobs.size()));
            }
            player.getWorld().spawnEntity(Util.getNearbyLocation(player, random.nextInt(10)), entity);
        }
        String message = Util.getMessage("Herobrine.altarMessages");
        if (message!= null) {
             player.sendMessage(Util.formatString(message));
        }
        return ("Spawned: " + amountToSpawn);
    }
}
