package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.Action;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class FlashMob extends Action {
    
    public FlashMob() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        final ArrayList<Entity> spawned = new ArrayList<Entity>();
        spawned.add(player.getWorld().spawnEntity(player.getLocation().add(2, 0, 0), EntityType.ZOMBIE));
        spawned.add(player.getWorld().spawnEntity(player.getLocation().add(1, 0, 1), EntityType.ZOMBIE));
        spawned.add(player.getWorld().spawnEntity(player.getLocation().add(0, 0, 2), EntityType.ZOMBIE));
        spawned.add(player.getWorld().spawnEntity(player.getLocation().add(-1, 0, 1), EntityType.ZOMBIE));
        spawned.add(player.getWorld().spawnEntity(player.getLocation().add(-2, 0, 0), EntityType.ZOMBIE));
        spawned.add(player.getWorld().spawnEntity(player.getLocation().add(-1, 0, -1), EntityType.ZOMBIE));
        spawned.add(player.getWorld().spawnEntity(player.getLocation().add(0, 0, -2), EntityType.ZOMBIE));
        spawned.add(player.getWorld().spawnEntity(player.getLocation().add(1, 0, -1), EntityType.ZOMBIE));
        Bukkit.getServer().getScheduler().runTaskLater(Herobrine.getInstance(), new Runnable() {

            @Override
            public void run() {
                for (Entity entity : spawned) {
                    entity.remove();
                }
            }
        }, 40);
        return "Done.";
    }
}
