package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.ActionResult;
import com.kreckin.herobrine.api.ActionType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RearrangeInventory extends Action {
    
    public RearrangeInventory() {
        super(ActionType.STANDARD);
    }

    @Override
    public ActionResult callAction(Player player, Object[] metadata) {
        List<ItemStack> items = Arrays.asList(player.getInventory().getContents());
        Collections.shuffle(items);
        player.getInventory().clear();
        int count = 0;
        for (ItemStack item : items) {
            if (item != null) {
                player.getInventory().addItem(item);
                count++;
            }
        }
        return (new ActionResult("Done.", "Rearranged " + count + " items!"));
    }
}
