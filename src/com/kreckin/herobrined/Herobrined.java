package com.kreckin.herobrined;

import com.kreckin.herobrined.actions.PlaceSign;
import com.kreckin.herobrined.actions.PlaceTorch;
import com.kreckin.herobrined.impl.ActionManager;
import com.kreckin.herobrined.listeners.CommandListener;
import com.kreckin.herobrined.listeners.EventListener;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Herobrined extends JavaPlugin {

    private static Herobrined instance;
    private ActionManager actionManager;
    private YamlConfiguration config;

    @Override
    public void onEnable() {
        Herobrined.instance = this;
        this.actionManager = new ActionManager();
        this.actionManager.registerAction(new PlaceTorch());
        this.actionManager.registerAction(new PlaceSign());
        this.getCommand("hb").setExecutor(new CommandListener());
        this.getServer().getPluginManager().registerEvents(new EventListener(), this);
        try {
            if (!this.getDataFolder().exists()) {
                this.getDataFolder().mkdirs();
            }
            if (!new File(this.getDataFolder() + "/config.yml").exists()) {
                this.saveResource("config.yml", false);
            }
            this.config = YamlConfiguration.loadConfiguration(new File(this.getDataFolder() + "/config.yml"));
        } catch (Exception ex) {
            this.getLogger().severe("Failed to properly config the plugin!");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        Logger.log("Survival Only: " + this.config.getBoolean("Herobrined.survivalOnly"), Level.INFO);
        this.printArray(this.config.getStringList("Herobrined.disallowedWorlds"), "Disallowed Worlds");
        this.printArray(this.config.getStringList("Herobrined.disallowedActions"), "Disallowed Actions");
        this.printArray(this.config.getStringList("Herobrined.signMessages"), "Sign Messages");
    }
    
    private void printArray(List<String> list, String tag) {
        if (list.isEmpty()) {
            Logger.log(tag + ": None", Level.INFO);
        } else {
            Logger.log(tag + ":", Level.INFO);
            for (int index = 0; index < list.size(); index++) {
                Logger.log("\t" + (index + 1) + ". " + list.get(index), Level.INFO);
            }
        }
    }
    
    public YamlConfiguration getYamlConfiguration() {
        return this.config;
    }
    
    public ActionManager getActionManager() {
        return this.actionManager;
    }
    
    public static Herobrined getHerobrined() {
        return Herobrined.instance;
    }
}
