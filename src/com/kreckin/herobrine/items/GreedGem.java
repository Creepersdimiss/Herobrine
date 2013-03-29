package com.kreckin.herobrine.items;

import com.kreckin.herobrine.api.CustomItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class GreedGem extends CustomItem {
    
    public GreedGem() {
        super("Greed Gem", "Dropped by a Fallen Angel", Material.EMERALD);
        super.addEnchantment(Enchantment.FIRE_ASPECT, 1);
    }
}
