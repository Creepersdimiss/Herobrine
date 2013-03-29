package com.kreckin.herobrine.items;

import com.kreckin.herobrine.api.CustomItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class HerobrinesSword extends CustomItem {
    
    public HerobrinesSword() {
        super("Herobrine's Sword", "Forged in Hell", Material.GOLD_SWORD);
        super.addEnchantment(Enchantment.DURABILITY, 3);
        super.addEnchantment(Enchantment.LOOT_BONUS_MOBS, 2);
        super.addEnchantment(Enchantment.KNOCKBACK, 4);
        super.addEnchantment(Enchantment.FIRE_ASPECT, 3);
        super.addEnchantment(Enchantment.DAMAGE_ALL, 2);
    }
}
