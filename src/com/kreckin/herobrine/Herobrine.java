package com.kreckin.herobrine;

import com.kreckin.herobrine.api.SupportManager;
import com.kreckin.herobrine.api.ActionManager;
import com.kreckin.herobrine.api.CustomEntityManager;
import com.kreckin.herobrine.api.HotspotManager;
import com.kreckin.herobrine.items.HerobrinesSword;
import com.kreckin.herobrine.listeners.CommandListener;
import com.kreckin.herobrine.listeners.EventListener;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Herobrine extends JavaPlugin {

    private static Herobrine instance;
    private static ActionManager actionManager;
    private static YamlConfiguration config;
    private static SupportManager support;
    private static CustomEntityManager entityManager;
    private static HotspotManager hotspotManager;

    @Override
    public void onEnable() {
        Herobrine.instance = this;
        Herobrine.actionManager = new ActionManager();
        Herobrine.support = new SupportManager();
        Herobrine.entityManager = new CustomEntityManager();
        Herobrine.hotspotManager = new HotspotManager();
        ShapedRecipe recipe = new ShapedRecipe(new HerobrinesSword().getItem());
        recipe.shape("ABA", "BCB", "ABA");
        recipe.setIngredient('A', Material.REDSTONE);
        recipe.setIngredient('B', Material.DIAMOND);
        recipe.setIngredient('C', Material.EMERALD);
        this.getServer().addRecipe(recipe);
        this.getCommand("hb").setExecutor(new CommandListener());
        this.getServer().getPluginManager().registerEvents(new EventListener(), this);
        try {
            if (!this.getDataFolder().exists()) {
                this.getDataFolder().mkdirs();
            }
            if (!new File(this.getDataFolder() + "/config.yml").exists()) {
                this.saveResource("config.yml", false);
            }
            Herobrine.config = YamlConfiguration.loadConfiguration(new File(this.getDataFolder() + "/config.yml"));
        } catch (Exception ex) {
            Herobrine.log("Failed to properly manage the configuration!", Level.SEVERE);
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        try {
            new MetricsLite(this).start();
        } catch (Exception ex) {
            Herobrine.log("Failed to start MCStats reporting!", Level.WARNING);
        }
        Herobrine.support.checkPlugins();
        Herobrine.log("Special Thanks Too: ", Level.INFO);
        Herobrine.log("\t- cadester177", Level.INFO);
        Herobrine.log("\t- Deanfvjr", Level.INFO);
    }
    
    @Override
    public void onDisable() {
        Herobrine.actionManager = null;
        Herobrine.config = null;
        Herobrine.instance = null;
        Herobrine.support = null;
        Herobrine.entityManager = null;
        Herobrine.hotspotManager = null;
    }
    
    public static void log(String message, Level level) {
        Bukkit.getLogger().log(level, "[Herobrine] {0}", message);
    }

    public static CustomEntityManager getEntityManager() {
        return Herobrine.entityManager;
    }
    
    public static YamlConfiguration getConfigFile() {
        return Herobrine.config;
    }
    
    public static ActionManager getActionManager() {
        return Herobrine.actionManager;
    }
    
    public static Herobrine getInstance() {
        return Herobrine.instance;
    }
    
    public static SupportManager getSupportManager() {
        return Herobrine.support;
    }
    
    public static HotspotManager getHotspotManager() {
        return Herobrine.hotspotManager;
    }
}
