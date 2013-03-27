package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import java.util.Random;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class AltarSummon extends Action {
    
    private final ArrayList<EntityType> hostiles;

    public AltarSummon() {
        super(false);
        this.hostiles = new ArrayList<EntityType>();
        this.hostiles.add(EntityType.BAT);
        this.hostiles.add(EntityType.BLAZE);
        this.hostiles.add(EntityType.CAVE_SPIDER);
        this.hostiles.add(EntityType.CREEPER);
        this.hostiles.add(EntityType.ENDERMAN);
        this.hostiles.add(EntityType.GHAST);
        this.hostiles.add(EntityType.GIANT);
        this.hostiles.add(EntityType.MAGMA_CUBE);
        this.hostiles.add(EntityType.PIG_ZOMBIE);
        this.hostiles.add(EntityType.SILVERFISH);
        this.hostiles.add(EntityType.SKELETON);
        this.hostiles.add(EntityType.SLIME);
        this.hostiles.add(EntityType.SPIDER);
        this.hostiles.add(EntityType.WITCH);
        this.hostiles.add(EntityType.ZOMBIE);
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
        int amountToSpawn = 5 + (new Random().nextInt(5));
        for (int id = 0; id < amountToSpawn; id++) {
            player.getWorld().spawnEntity(Util.getNearbyLocation(player, new Random().nextInt(10)), this.hostiles.get(new Random().nextInt(this.hostiles.size() - 1)));
        }
        player.sendMessage(Util.formatString(Util.getMessage("Herobrine.altarMessages")));
        return ("Spawned: " + amountToSpawn);
    }
}
