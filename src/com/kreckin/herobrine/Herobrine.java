package com.kreckin.herobrine;

import com.kreckin.herobrine.api.SupportManager;
import com.kreckin.herobrine.api.ActionManager;
import com.kreckin.herobrine.api.CustomEntityManager;
import com.kreckin.herobrine.listeners.CommandListener;
import com.kreckin.herobrine.listeners.EventListener;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Herobrine extends JavaPlugin {

    private static Herobrine instance;
    private static ActionManager actionManager;
    private static YamlConfiguration config;
    private static SupportManager support;
    private static CustomEntityManager entityManager;

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
            Herobrine.log("Failed to properly manage the configuration!", Level.SEVERE);
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        Herobrine.instance = this;
        Herobrine.actionManager = new ActionManager();
        Herobrine.support = new SupportManager();
        Herobrine.entityManager = new CustomEntityManager();
        this.getCommand("hb").setExecutor(new CommandListener());
        this.getServer().getPluginManager().registerEvents(new EventListener(), this);
        if (Herobrine.config.getBoolean("Herobrine.verboseLog")) {
            Herobrine.log("Heavier Equation: " + Herobrine.config.getBoolean("Herobrine.heavierEquation"), Level.INFO);
            Herobrine.log("Survival Only: " + Herobrine.config.getBoolean("Herobrine.survivalOnly"), Level.INFO);
            Herobrine.log("Action Chance: " + Herobrine.config.getInt("Herobrine.actionChance"), Level.INFO);
            Herobrine.log("Entity Name: " + Herobrine.config.getString("Herobrine.entityName"), Level.INFO);
            Herobrine.log("Ignore Protected Regions: " + Herobrine.config.getBoolean("Herobrine.ignoreProtectedRegions"), Level.INFO);
            Herobrine.log("Book Title: " + Herobrine.config.getBoolean("Herobrine.bookTitle"), Level.INFO);
            this.printArray(Herobrine.config.getStringList("Herobrine.bookMessages"), "Book Messages");
            this.printArray(Herobrine.config.getStringList("Herobrine.signMessages"), "Sign Messages");
            this.printArray(Herobrine.config.getStringList("Herobrine.altarMessages"), "Altar Messages");
            this.printArray(Herobrine.config.getStringList("Herobrine.disallowedWorlds"), "Disallowed Worlds");
            this.printArray(Herobrine.config.getStringList("Herobrine.disallowedActions"), "Disallowed Actions");
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
    }
    
    public static void log(String message, Level level) {
        Bukkit.getLogger().log(level, "[Herobrine] {0}", message);
    }
    
    private void printArray(List<String> list, String tag) {
        if (list.isEmpty()) {
            Herobrine.log(tag + ": None", Level.INFO);
        } else {
            Herobrine.log(tag + ":", Level.INFO);
            for (int index = 0; index < list.size(); index++) {
                Herobrine.log("\t" + (index + 1) + ". " + list.get(index), Level.INFO);
            }
        }
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
}
