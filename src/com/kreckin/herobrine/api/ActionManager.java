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
import com.kreckin.herobrine.actions.CreatePillar;
import com.kreckin.herobrine.actions.BurnPlayer;
import com.kreckin.herobrine.actions.CreateBlankTree;
import com.kreckin.herobrine.actions.CreateInfection;
import com.kreckin.herobrine.actions.DecayFlowers;
import com.kreckin.herobrine.actions.EffectExplosion;
import com.kreckin.herobrine.actions.PlaceChest;
import com.kreckin.herobrine.actions.SpinPlayer;
import com.kreckin.herobrine.actions.StealItem;
import com.kreckin.herobrine.actions.ThrowPlayer;
import com.kreckin.herobrine.actions.WolfAttack;
import java.util.ArrayList;

public class ActionManager {

    private final ArrayList<Action> actions;
    
    public ActionManager() {
        actions = new ArrayList<Action>();
        registerAction(new PlaceTorch());
        registerAction(new PlaceSign());
        registerAction(new DestroyTorches());
        registerAction(new CreateRingOfFire());
        registerAction(new BuryPlayer());
        registerAction(new CreateGrave());
        registerAction(new CreateTNTTrap());
        registerAction(new StealItem());
        registerAction(new RearrangeInventory());
        registerAction(new PossessPlayer());
        registerAction(new WolfAttack());
        registerAction(new BatAttack());
        registerAction(new CreatePyramid());
        registerAction(new PlaySound());
        registerAction(new GiftBook());
        registerAction(new SendMessage());
        registerAction(new RandomLightning());
        registerAction(new RandomExplosion());
        registerAction(new DimTorches());
        registerAction(new ThrowPlayer());
        registerAction(new GiftHead());
        registerAction(new CreateTotem());
        registerAction(new SpinPlayer());
        registerAction(new DuplicateItem());
        registerAction(new RandomStorm());
        registerAction(new BossAttack());
        registerAction(new DestroyChests());
        registerAction(new CreateTomb());
        registerAction(new CreateRingOfTorches());
        registerAction(new MobAttack());
        registerAction(new PlaceChest());
        registerAction(new CreateInfection());
        registerAction(new DecayFlowers());
        registerAction(new BurnPlayer());
        registerAction(new EffectExplosion());
        registerAction(new CreatePillar());
        registerAction(new CreateBlankTree());
    }
    
    public final void registerAction(Action action) {
        actions.add(action);
    }
    
    public boolean isAllowed(Class<? extends Action> action) {
        return (!Herobrine.getConfigFile().getStringList("Herobrine.disallowedActions").contains(action.getSimpleName()));
    }

    public ArrayList<Action> getActions() {
        return actions;
    }
}
