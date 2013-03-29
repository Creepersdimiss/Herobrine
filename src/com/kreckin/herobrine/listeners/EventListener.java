package com.kreckin.herobrine.listeners;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.actions.AltarSummon;
import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.CustomEntity;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventListener implements Listener {
    
    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent event) {
        if (!event.getCause().equals(BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL)) {
            return;
        }
        Block nether = event.getBlock().getLocation().subtract(0D, 1D, 0D).getBlock();
        Block moss = nether.getLocation().subtract(0D, 1D, 0D).getBlock();
        if (nether.getType().equals(Material.NETHERRACK) && moss.getType().equals(Material.MOSSY_COBBLESTONE)) {
            new AltarSummon().checkAction(event.getPlayer(), new Object[] { nether });
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (Util.shouldAct(event.getPlayer())) {
            Action action = Herobrine.getActionManager().getActions().get(Util.getRandom().nextInt(Herobrine.getActionManager().getActions().size() - 1));
            if (!action.isRandom()) {
                return;
            }
            action.checkAction(event.getPlayer(), null);
        }
    }
    
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (Herobrine.getEntityManager().getEntity(event.getEntity().getEntityId()) != null && !event.getCause().equals(DamageCause.ENTITY_ATTACK)) {
            event.setCancelled(true);
            event.setDamage(0);
            if (event.getEntity().getFireTicks() > 0) {
                event.getEntity().setFireTicks(0);
            }
        }
    }
    
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        CustomEntity entity = Herobrine.getEntityManager().getEntity(event.getEntity().getEntityId());
        if (entity != null) {
            entity.onKilled();
            event.setDroppedExp(0);
            event.getDrops().clear();
            event.getDrops().add(entity.getDrop());
            Herobrine.getEntityManager().removeEntity(entity.getEntity().getEntityId());
        }
    }
}
