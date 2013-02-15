package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.ActionResult;
import com.kreckin.herobrine.api.ActionType;
import com.kreckin.herobrine.util.Util;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class GiftBook extends Action {
    
    public GiftBook() {
        super(ActionType.STANDARD);
    }

    @Override
    public ActionResult callAction(Player player, Object[] metadata) {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta meta = (BookMeta) book.getItemMeta();
        meta.setAuthor("Herobrine");
        meta.setTitle(ChatColor.MAGIC + "steaks4uce");
        meta.setPages(Util.getMessage("Herobrine.bookMessages"));
        book.setItemMeta(meta);
        player.getInventory().addItem(book);
        return (new ActionResult("Done."));
    }
}
