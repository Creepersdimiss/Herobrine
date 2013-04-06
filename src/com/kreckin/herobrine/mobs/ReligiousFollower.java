package com.kreckin.herobrine.mobs;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.CustomEntity;
import com.kreckin.herobrine.items.SatanicBook;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ReligiousFollower extends CustomEntity {
    
    public ReligiousFollower(Location loc) {
        super(loc, EntityType.ZOMBIE, "Religious Follower", new SatanicBook().getItem());
    }

    @Override
    public void onSpawn() {
        super.getEntity().setMaxHealth(Herobrine.getConfigFile().getInt("Herobrine.religiousFollowerHealth"));
        super.getEntity().setHealth(super.getEntity().getMaxHealth());
        super.getEntity().getEquipment().setItemInHand(new ItemStack(Material.WRITTEN_BOOK, 1));
        super.getEntity().getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
        super.getEntity().getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        super.getEntity().getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
    }

    @Override
    public void onKilled() {
        Player player = null;
        for (Entity entity : super.getEntity().getNearbyEntities(5, 5, 5)) {
            if (entity instanceof Player) {
                player = (Player) entity;
                break;
            }
        }
        if (player != null) {
            player.sendMessage("[" + ChatColor.AQUA + "Religious Follower" + ChatColor.WHITE + "] Run... run while you... still ca-");
        }
    }
}
