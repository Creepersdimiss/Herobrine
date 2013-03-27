package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class GiftHead extends Action {
    
    public GiftHead() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(player.getName());
        if (Util.getRandom().nextInt(10) == 0) {
            meta.setOwner("Herobrine");
        }
        skull.setItemMeta(meta);
        player.getInventory().addItem(skull);
        return "Done.";
    }
}
