package com.kreckin.herobrine.items;

import com.kreckin.herobrine.api.CustomItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class MidnightGem extends CustomItem {
    
    public MidnightGem() {
        super("Midnight Gem", "Dropped by a Hell's Guardian", Material.DIAMOND);
        addEnchantment(Enchantment.FIRE_ASPECT, 1);
    }
}
