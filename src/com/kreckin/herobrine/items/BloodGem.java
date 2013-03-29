package com.kreckin.herobrine.items;

import com.kreckin.herobrine.api.CustomItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class BloodGem extends CustomItem {
    
    public BloodGem() {
        super("Blood Gem", "Dropped by an Unknown Demon", Material.REDSTONE);
        super.addEnchantment(Enchantment.FIRE_ASPECT, 1);
    }
}
