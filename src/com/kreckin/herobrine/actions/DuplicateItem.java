package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import java.util.ArrayList;
import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DuplicateItem extends Action {
    
    public DuplicateItem() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        ArrayList<Integer> slots = new ArrayList<Integer>();
        for (int index = 0; index < 35; index++) {
            if (player.getInventory().getItem(index) != null) {
                slots.add(index);
            }
        }
        if (slots.isEmpty()) {
            return "Failed, could not find a proper item!";
        }
        ItemStack item = player.getInventory().getItem(slots.get(0));
        if (slots.size() > 1) {
            item = player.getInventory().getItem(new Random().nextInt(slots.size() - 1));
        }
        if (item != null) {
            player.getInventory().addItem(new ItemStack(item.getType(), 1));
            player.updateInventory();
            return ("Duplicated: " + item.getType().toString());
        }
        return "Failed, could not find a proper item!";
    }
}
