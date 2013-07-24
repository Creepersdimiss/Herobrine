package com.kreckin.herobrine;

import com.kreckin.herobrine.api.SupportManager;
import com.kreckin.herobrine.api.ActionManager;
import com.kreckin.herobrine.api.CustomEntityManager;
import com.kreckin.herobrine.api.HotspotManager;
import com.kreckin.herobrine.items.HerobrinesSword;
import com.kreckin.herobrine.listeners.CommandListener;
import com.kreckin.herobrine.listeners.EventListener;
import java.io.File;
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
        instance = this;
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            if (!new File(getDataFolder() + File.separator + "config.yml").exists()) {
                saveResource("config.yml", false);
            }
            config = YamlConfiguration.loadConfiguration(new File(getDataFolder() + File.separator + "config.yml"));
        } catch (Exception ex) {
            getLogger().severe("Failed to properly manage the configuration!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        actionManager = new ActionManager();
        support = new SupportManager();
        entityManager = new CustomEntityManager();
        hotspotManager = new HotspotManager();
        ShapedRecipe recipe = new ShapedRecipe(new HerobrinesSword().getItem());
        recipe.shape("ABA", "BCB", "ABA");
        recipe.setIngredient('A', Material.REDSTONE);
        recipe.setIngredient('B', Material.DIAMOND);
        recipe.setIngredient('C', Material.EMERALD);
        getServer().addRecipe(recipe);
        getCommand("hb").setExecutor(new CommandListener());
        getCommand("hbu").setExecutor(new CommandListener());
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        try {
            new MetricsLite(this).start();
        } catch (Exception ex) {
            getLogger().severe("Failed to start MCStats reporting!");
        }
        support.checkPlugins();
    }

    public static CustomEntityManager getEntityManager() {
        return entityManager;
    }
    
    public static YamlConfiguration getConfigFile() {
        return config;
    }
    
    public static ActionManager getActionManager() {
        return actionManager;
    }
    
    public static Herobrine getInstance() {
        return instance;
    }
    
    public static SupportManager getSupportManager() {
        return support;
    }
    
    public static HotspotManager getHotspotManager() {
        return hotspotManager;
    }
}
