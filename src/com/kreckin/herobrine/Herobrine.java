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
    private static CommandListener commands;
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
            Herobrine.config = YamlConfiguration.loadConfiguration(new File(this.getDataFolder() + "/config.yml"));
        } catch (Exception ex) {
            Herobrine.getLog().severe("Failed to properly manage the configuration!");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        Herobrine.instance = this;
        Herobrine.actionManager = new ActionManager();
        Herobrine.commands = new CommandListener();
        Herobrine.support = new SupportManager();
        Herobrine.entityManager = new CustomEntityManager();
        Herobrine.hotspotManager = new HotspotManager();
        Herobrine.chatManager = new ChatManager();
        ShapedRecipe recipe = new ShapedRecipe(new HerobrinesSword().getItem());
        recipe.shape("ABA", "BCB", "ABA");
        recipe.setIngredient('A', Material.REDSTONE);
        recipe.setIngredient('B', Material.DIAMOND);
        recipe.setIngredient('C', Material.EMERALD);
        this.getServer().addRecipe(recipe);
        this.getCommand("hb").setExecutor(Herobrine.commands);
        this.getCommand("herobrine").setExecutor(Herobrine.commands);
        this.getCommand("hbu").setExecutor(Herobrine.commands);
        this.getServer().getPluginManager().registerEvents(new EventListener(), this);
        try {
            new MetricsLite(this).start();
        } catch (Exception ex) {
            Herobrine.getLog().severe("Failed to start MCStats reporting!");
        }
        Herobrine.support.checkPlugins();
        Herobrine.getLog().info("Donators: ");
        Herobrine.getLog().info("\t- cadester177");
        Herobrine.getLog().info("\t- Deanfvjr");
    }
    
    @Override
    public void onDisable() {
        Herobrine.actionManager = null;
        Herobrine.config = null;
        Herobrine.instance = null;
        Herobrine.support = null;
        Herobrine.entityManager = null;
        Herobrine.hotspotManager = null;
        Herobrine.commands = null;
        Herobrine.chatManager = null;
    }
    
    public static ChatManager getChatManager() {
        return Herobrine.chatManager;
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
    
    public static Logger getLog() {
        return Herobrine.getInstance().getLogger();
    }
    
    public static CommandListener getCommandListener() {
        return Herobrine.commands;
    }
}
