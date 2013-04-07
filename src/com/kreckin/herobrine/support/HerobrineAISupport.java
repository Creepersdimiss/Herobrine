package com.kreckin.herobrine.support;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.actions.BatAttack;
import com.kreckin.herobrine.actions.BossAttack;
import com.kreckin.herobrine.actions.BurnPlayer;
import com.kreckin.herobrine.actions.BuryPlayer;
import com.kreckin.herobrine.actions.CreatePyramid;
import com.kreckin.herobrine.actions.CreateTomb;
import com.kreckin.herobrine.actions.DestroyTorches;
import com.kreckin.herobrine.actions.GiftBook;
import com.kreckin.herobrine.actions.GiftHead;
import com.kreckin.herobrine.actions.PlaceSign;
import com.kreckin.herobrine.actions.PossessPlayer;
import com.kreckin.herobrine.actions.RandomExplosion;
import com.kreckin.herobrine.actions.RandomLightning;
import com.kreckin.herobrine.actions.SendMessage;
import com.kreckin.herobrine.actions.WolfAttack;
import com.kreckin.herobrine.api.Support;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.jakub1221.herobrineai.HerobrineAI;

public class HerobrineAISupport extends Support {
    
    public HerobrineAISupport() {
        super("HerobrineAI");
    }
    
    @Override
    public void onStartup(Plugin plugin) {
        HerobrineAI.getPluginCore().getConfigDB().AttackCreative = !Herobrine.getConfigFile().getBoolean("Herobrine.survivalOnly");
        HerobrineAI.getPluginCore().getConfigDB().AttackOP = true;
        HerobrineAI.getPluginCore().getConfigDB().BuildPyramids = Herobrine.getActionManager().isAllowed(CreatePyramid.class);
        HerobrineAI.getPluginCore().getConfigDB().BuildTemples = Herobrine.getActionManager().isAllowed(CreateTomb.class);
        HerobrineAI.getPluginCore().getConfigDB().BuryPlayers = Herobrine.getActionManager().isAllowed(BuryPlayer.class);
        HerobrineAI.getPluginCore().getConfigDB().DestroyTorches = Herobrine.getActionManager().isAllowed(DestroyTorches.class);
        HerobrineAI.getPluginCore().getConfigDB().Explosions = Herobrine.getActionManager().isAllowed(RandomExplosion.class);
        HerobrineAI.getPluginCore().getConfigDB().Lighting = Herobrine.getActionManager().isAllowed(RandomLightning.class);
        HerobrineAI.getPluginCore().getConfigDB().PlaceSigns = Herobrine.getActionManager().isAllowed(PlaceSign.class);
        HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Attack = !Herobrine.getConfigFile().getBoolean("Herobrine.ignoreProtectedRegions");
        HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Books = !Herobrine.getConfigFile().getBoolean("Herobrine.ignoreProtectedRegions");
        HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Build = !Herobrine.getConfigFile().getBoolean("Herobrine.ignoreProtectedRegions");
        HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Haunt = !Herobrine.getConfigFile().getBoolean("Herobrine.ignoreProtectedRegions");
        HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Signs = !Herobrine.getConfigFile().getBoolean("Herobrine.ignoreProtectedRegions");
        HerobrineAI.getPluginCore().getConfigDB().SendMessages = Herobrine.getActionManager().isAllowed(SendMessage.class);
        HerobrineAI.getPluginCore().getConfigDB().SpawnBats = Herobrine.getActionManager().isAllowed(BatAttack.class);
        HerobrineAI.getPluginCore().getConfigDB().SpawnWolves = Herobrine.getActionManager().isAllowed(WolfAttack.class);
        HerobrineAI.getPluginCore().getConfigDB().UseHeads = Herobrine.getActionManager().isAllowed(GiftHead.class);
        HerobrineAI.getPluginCore().getConfigDB().UseNPC_Guardian = Herobrine.getActionManager().isAllowed(BossAttack.class);
        HerobrineAI.getPluginCore().getConfigDB().UseNPC_Warrior = Herobrine.getActionManager().isAllowed(BossAttack.class);
        HerobrineAI.getPluginCore().getConfigDB().UsePotionEffects = Herobrine.getActionManager().isAllowed(PossessPlayer.class);
        HerobrineAI.getPluginCore().getConfigDB().WriteBooks = Herobrine.getActionManager().isAllowed(GiftBook.class);
        // HerobrineAI.getPluginCore().getConfigDB().Burn = Herobrine.getActionManager().isAllowed(BurnPlayer.class);
        // HerobrineAI.getPluginCore().getConfigDB().Curse = Herobrine.getActionManager().isAllowed(PossessPlayer.class);
        
    }

    @Override
    public boolean checkPermissions(Location loc, Plugin plugin) {
        return true;
    }
}
