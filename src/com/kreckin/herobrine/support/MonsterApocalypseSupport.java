package com.kreckin.herobrine.support;

import blainicus.MonsterApocalypse.MonsterApocalypse;
import com.kreckin.herobrine.api.Support;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

public class MonsterApocalypseSupport extends Support {
    
    public MonsterApocalypseSupport() {
        super("MonsterApocalypse");
    }
    
    @Override
    public void onStartup() {
        ((MonsterApocalypse) super.getPlugin()).setHpHandledExternally(true);
    }

    @Override
    public boolean checkPermissions(Location loc, Plugin plugin) {
        return true;
    }
}
