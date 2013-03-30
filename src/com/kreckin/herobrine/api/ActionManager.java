package com.kreckin.herobrine.api;

import com.kreckin.herobrine.Herobrine;
import com.kreckin.herobrine.actions.BatAttack;
import com.kreckin.herobrine.actions.BuryPlayer;
import com.kreckin.herobrine.actions.CreateGrave;
import com.kreckin.herobrine.actions.CreatePyramid;
import com.kreckin.herobrine.actions.CreateRingOfFire;
import com.kreckin.herobrine.actions.CreateRingOfTorches;
import com.kreckin.herobrine.actions.CreateTNTTrap;
import com.kreckin.herobrine.actions.CreateTomb;
import com.kreckin.herobrine.actions.CreateTotem;
import com.kreckin.herobrine.actions.DestroyChests;
import com.kreckin.herobrine.actions.DestroyTorches;
import com.kreckin.herobrine.actions.DimTorches;
import com.kreckin.herobrine.actions.DuplicateItem;
import com.kreckin.herobrine.actions.GiftBook;
import com.kreckin.herobrine.actions.GiftHead;
import com.kreckin.herobrine.actions.MobAttack;
import com.kreckin.herobrine.actions.PlaceSign;
import com.kreckin.herobrine.actions.PlaceTorch;
import com.kreckin.herobrine.actions.PlaySound;
import com.kreckin.herobrine.actions.PossessPlayer;
import com.kreckin.herobrine.actions.RandomExplosion;
import com.kreckin.herobrine.actions.RandomLightning;
import com.kreckin.herobrine.actions.RandomStorm;
import com.kreckin.herobrine.actions.RearrangeInventory;
import com.kreckin.herobrine.actions.SendMessage;
import com.kreckin.herobrine.actions.BossAttack;
import com.kreckin.herobrine.actions.PlaceChest;
import com.kreckin.herobrine.actions.SpinPlayer;
import com.kreckin.herobrine.actions.StealItem;
import com.kreckin.herobrine.actions.ThrowPlayer;
import com.kreckin.herobrine.actions.WolfAttack;
import java.util.ArrayList;
import java.util.logging.Level;

public class ActionManager {

    private final ArrayList<Action> actions;
    
    public ActionManager() {
        this.actions = new ArrayList<Action>();
        this.registerAction(new PlaceTorch());
        this.registerAction(new PlaceSign());
        this.registerAction(new DestroyTorches());
        this.registerAction(new CreateRingOfFire());
        this.registerAction(new BuryPlayer());
        this.registerAction(new CreateGrave());
        this.registerAction(new CreateTNTTrap());
        this.registerAction(new StealItem());
        this.registerAction(new RearrangeInventory());
        this.registerAction(new PossessPlayer());
        this.registerAction(new WolfAttack());
        this.registerAction(new BatAttack());
        this.registerAction(new CreatePyramid());
        this.registerAction(new PlaySound());
        this.registerAction(new GiftBook());
        this.registerAction(new SendMessage());
        this.registerAction(new RandomLightning());
        this.registerAction(new RandomExplosion());
        this.registerAction(new DimTorches());
        this.registerAction(new ThrowPlayer());
        this.registerAction(new GiftHead());
        this.registerAction(new CreateTotem());
        this.registerAction(new SpinPlayer());
        this.registerAction(new DuplicateItem());
        this.registerAction(new RandomStorm());
        this.registerAction(new BossAttack());
        this.registerAction(new DestroyChests());
        this.registerAction(new CreateTomb());
        this.registerAction(new CreateRingOfTorches());
        this.registerAction(new MobAttack());
        this.registerAction(new PlaceChest());
        if (Herobrine.getConfigFile().getBoolean("Herobrine.verboseLog")) {
            Herobrine.log("Action Count: " + this.actions.size(), Level.INFO);
        }
    }
    
    public final void registerAction(Action action) {
        this.actions.add(action);
        if (Herobrine.getConfigFile().getBoolean("Herobrine.verboseLog")) {
            Herobrine.log("Registered: " + action.getClass().getSimpleName(), Level.INFO);
        }
    }

    public ArrayList<Action> getActions() {
        return this.actions;
    }
}
