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
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Herobrine extends JavaPlugin {

    private static Herobrine instance;
    private final static ActionManager actionManager = new ActionManager();
    private final static SupportManager support = new SupportManager();
    private final static CustomEntityManager entityManager = new CustomEntityManager();
    private final static HotspotManager hotspotManager = new HotspotManager();
    private static YamlConfiguration config;

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
        actionManager.loadDefaultActions();
        ShapedRecipe recipe = new ShapedRecipe(new HerobrinesSword().getItem());
        recipe.shape("ABA", "BCB", "ABA");
        recipe.setIngredient('A', Material.REDSTONE);
        recipe.setIngredient('B', Material.DIAMOND);
        recipe.setIngredient('C', Material.EMERALD);
        getServer().addRecipe(recipe);
        getCommand("hb").setExecutor(new CommandListener());
        getCommand("hbu").setExecutor(new CommandListener());
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        getServer().getScheduler().runTaskTimer(this, new ActionRunner(), 10, 10);
        try {
            new MetricsLite(this).start();
        } catch (Exception ex) {
            getLogger().severe("Failed to start MCStats reporting!");
        }
        support.checkPlugins();
    }
    
    @Override
    public void onDisable() {
        instance = null;
        HandlerList.unregisterAll(this);
        getServer().getScheduler().cancelTasks(this);
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

    public static SupportManager getSupportManager() {
        return support;
    }
    
    public static HotspotManager getHotspotManager() {
        return hotspotManager;
    }
    
    public static Herobrine getInstance() {
        return instance;
    }
}
