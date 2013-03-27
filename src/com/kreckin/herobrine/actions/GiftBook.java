package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.api.ActionResult;
import com.kreckin.herobrine.util.Util;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class GiftBook extends Action {
    
    public GiftBook() {
        super(true);
    }

    @Override
    public ActionResult callAction(Player player, Object[] metadata) {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
        String message = Util.getMessage("Herobrine.bookMessages");
        BookMeta meta = (BookMeta) book.getItemMeta();
        meta.setAuthor("Herobrine");
        meta.setTitle(Herobrine.getConfigFile().getString("Herobrine.bookTitle"));
        meta.setPages(message);
        book.setItemMeta(meta);
        player.getInventory().addItem(book);
        return (new ActionResult("Done.", "Message: " + message));
    }
}
