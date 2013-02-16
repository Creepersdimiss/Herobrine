package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.actions.AltarSummon;
import com.kreckin.herobrine.actions.BatAttack;
import com.kreckin.herobrine.actions.BuryPlayer;
import com.kreckin.herobrine.actions.CreateGrave;
import com.kreckin.herobrine.actions.CreatePyramid;
import com.kreckin.herobrine.actions.CreateRingOfFire;
import com.kreckin.herobrine.actions.CreateTNTTrap;
import com.kreckin.herobrine.actions.DestroyTorches;
import com.kreckin.herobrine.actions.GiftBook;
import com.kreckin.herobrine.actions.PlaceSign;
import com.kreckin.herobrine.actions.PlaceTorch;
import com.kreckin.herobrine.actions.PlaySound;
import com.kreckin.herobrine.actions.PossessPlayer;
import com.kreckin.herobrine.actions.RandomExplosion;
import com.kreckin.herobrine.actions.RandomLightning;
import com.kreckin.herobrine.actions.RearrangeInventory;
import com.kreckin.herobrine.actions.SendMessage;
import com.kreckin.herobrine.actions.StealItem;
import com.kreckin.herobrine.actions.WolfAttack;
import java.util.ArrayList;
import java.util.logging.Level;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ActionManager {

    private final ArrayList<Action> actions;
    
    public ActionManager() {
        this.actions = new ArrayList<Action>();
        this.registerAction(Herobrine.getInstance(), new PlaceTorch());
        this.registerAction(Herobrine.getInstance(), new PlaceSign());
        this.registerAction(Herobrine.getInstance(), new DestroyTorches());
        this.registerAction(Herobrine.getInstance(), new CreateRingOfFire());
        this.registerAction(Herobrine.getInstance(), new BuryPlayer());
        this.registerAction(Herobrine.getInstance(), new CreateGrave());
        this.registerAction(Herobrine.getInstance(), new CreateTNTTrap());
        this.registerAction(Herobrine.getInstance(), new StealItem());
        this.registerAction(Herobrine.getInstance(), new RearrangeInventory());
        this.registerAction(Herobrine.getInstance(), new PossessPlayer());
        this.registerAction(Herobrine.getInstance(), new WolfAttack());
        this.registerAction(Herobrine.getInstance(), new BatAttack());
        this.registerAction(Herobrine.getInstance(), new CreatePyramid());
        this.registerAction(Herobrine.getInstance(), new PlaySound());
        this.registerAction(Herobrine.getInstance(), new AltarSummon());
        this.registerAction(Herobrine.getInstance(), new GiftBook());
        this.registerAction(Herobrine.getInstance(), new SendMessage());
        this.registerAction(Herobrine.getInstance(), new RandomLightning());
        this.registerAction(Herobrine.getInstance(), new RandomExplosion());
    }
    
    public final void registerAction(Plugin plugin, Action action) {
        this.actions.add(action);
        Herobrine.log("\"" + plugin.getDescription().getName() + "\" Registered: " + action.getClass().getSimpleName(), Level.INFO);
    }

    public ArrayList<Action> getActions() {
        return this.actions;
    }
}
