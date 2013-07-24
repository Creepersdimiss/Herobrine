package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class StealItem extends Action {
    
    private final Random random = new Random();
    
    public StealItem() {
        super(true);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        List<Integer> slots = new ArrayList<>();
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
            item = player.getInventory().getItem(random.nextInt(slots.size()));
        }
        if (item != null) {
            player.getInventory().remove(item);
            player.updateInventory();
            return ("Stole: " + item.getType().toString() + " & Amount: " + item.getAmount());
        }
        return "Failed, could not find a proper item!";
    }
}
