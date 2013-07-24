package com.kreckin.herobrine.util;

import com.kreckin.herobrine.Herobrine;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Util {

    private final static Random random = new Random();
    private final static List<Material> solids = Arrays.asList(
        Material.STONE,
        Material.GRASS,
        Material.DIRT,
        Material.COBBLESTONE,
        Material.WOOD,
        Material.SAND,
        Material.SANDSTONE
    );
    private final static List<Material> airs = Arrays.asList(
        Material.AIR,
        Material.LONG_GRASS,
        Material.SAPLING,
        Material.BROWN_MUSHROOM,
        Material.RED_MUSHROOM,
        Material.RED_ROSE,
        Material.YELLOW_FLOWER
    );

    public static boolean shouldAct(Player player) {
        int actionChance = Herobrine.getConfigFile().getInt("Herobrine.actionChance");
        if (player != null) {
            if (player.getWorld().getTime() >= 13000 && player.getWorld().getTime() <= 14200) {
                actionChance /= 4;
            }
            actionChance /= Herobrine.getHotspotManager().getImportance(player.getLocation());
            if (Herobrine.getConfigFile().getBoolean("Herobrine.heavierEquation") && player.getNearbyEntities(5, 5, 5).size() <= 3) {
                actionChance /= 4;
            }
        }
        return (random.nextInt(actionChance) == 0);
    }
    
    public static String getMessage(String path) {
        List<String> strings = Herobrine.getConfigFile().getStringList(path);
        if (strings.isEmpty()) {
            return null;
        }
        return strings.get(random.nextInt(strings.size()));
    }

    public static Location getNearbyLocation(Player player, int distance) {
        int addX = (random.nextBoolean() ? -random.nextInt(distance) : random.nextInt(distance));
        int addZ = (random.nextBoolean() ? -random.nextInt(distance) : random.nextInt(distance));
        return (player.getLocation().clone().add(addX, 0, addZ));
    }
    
    public static boolean isValid(Block block) {
        return (airs.contains(block.getType())) && isSolid(block.getWorld().getBlockAt(block.getLocation().subtract(0, 1, 0)));
    }
    
    public static boolean isSolid(Block block) {
        return solids.contains(block.getType());
    }
    
    public static String formatString(String message) {
        return ("[" + ChatColor.RED + Herobrine.getConfigFile().getString("Herobrine.entityName") + ChatColor.WHITE + "] " + message);
    }
    
    public static ItemStack getColoredArmour(Material mat, Color color) {
        ItemStack itemStack = new ItemStack(mat, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) itemStack.getItemMeta();
        meta.setColor(color);
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
