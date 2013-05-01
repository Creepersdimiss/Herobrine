package com.kreckin.herobrine;

import com.kreckin.herobrine.api.SupportManager;
import com.kreckin.herobrine.api.ActionManager;
import com.kreckin.herobrine.api.CustomEntityManager;
import com.kreckin.herobrine.api.HotspotManager;
import com.kreckin.herobrine.api.ChatManager;
import com.kreckin.herobrine.items.HerobrinesSword;
import com.kreckin.herobrine.listeners.CommandListener;
import com.kreckin.herobrine.listeners.EventListener;
import java.io.File;
import java.util.logging.Logger;
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
    private static ChatManager chatManager;

    @Override
    public void onEnable() {
        try {
            if (!this.getDataFolder().exists()) {
                this.getDataFolder().mkdirs();
            }
            if (!new File(this.getDataFolder() + "/config.yml").exists()) {
                this.saveResource("config.yml", false);
            }
            config = YamlConfiguration.loadConfiguration(new File(this.getDataFolder() + "/config.yml"));
        } catch (Exception ex) {
            getLog().severe("Failed to properly manage the configuration!");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        instance = this;
        actionManager = new ActionManager();
        support = new SupportManager();
        entityManager = new CustomEntityManager();
        hotspotManager = new HotspotManager();
        chatManager = new ChatManager();
        ShapedRecipe recipe = new ShapedRecipe(new HerobrinesSword().getItem());
        recipe.shape("ABA", "BCB", "ABA");
        recipe.setIngredient('A', Material.REDSTONE);
        recipe.setIngredient('B', Material.DIAMOND);
        recipe.setIngredient('C', Material.EMERALD);
        this.getServer().addRecipe(recipe);
        this.getCommand("hb").setExecutor(new CommandListener());
        this.getCommand("hbu").setExecutor(new CommandListener());
        this.getServer().getPluginManager().registerEvents(new EventListener(), this);
        try {
            new MetricsLite(this).start();
        } catch (Exception ex) {
            getLog().severe("Failed to start MCStats reporting!");
        }
        support.checkPlugins();
    }

    public static ChatManager getChatManager() {
        return chatManager;
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
    
    public static Logger getLog() {
        return instance.getLogger();
    }
}
