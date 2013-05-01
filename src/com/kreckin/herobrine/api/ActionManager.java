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
import com.kreckin.herobrine.util.Validate;
import java.util.ArrayList;

public class ActionManager {

    private final ArrayList<Action> actions;
    
    public ActionManager() {
        actions = new ArrayList<Action>();
        addAction(new PlaceTorch());
        addAction(new PlaceSign());
        addAction(new DestroyTorches());
        addAction(new CreateRingOfFire());
        addAction(new BuryPlayer());
        addAction(new CreateGrave());
        addAction(new CreateTNTTrap());
        addAction(new StealItem());
        addAction(new RearrangeInventory());
        addAction(new PossessPlayer());
        addAction(new WolfAttack());
        addAction(new BatAttack());
        addAction(new CreatePyramid());
        addAction(new PlaySound());
        addAction(new GiftBook());
        addAction(new SendMessage());
        addAction(new RandomLightning());
        addAction(new RandomExplosion());
        addAction(new DimTorches());
        addAction(new ThrowPlayer());
        addAction(new GiftHead());
        addAction(new CreateTotem());
        addAction(new SpinPlayer());
        addAction(new DuplicateItem());
        addAction(new RandomStorm());
        addAction(new BossAttack());
        addAction(new DestroyChests());
        addAction(new CreateTomb());
        addAction(new CreateRingOfTorches());
        addAction(new MobAttack());
        addAction(new PlaceChest());
        addAction(new CreateInfection());
        addAction(new DecayFlowers());
        addAction(new BurnPlayer());
        addAction(new EffectExplosion());
        addAction(new CreatePillar());
        addAction(new CreateBlankTree());
    }
    
    public final void addAction(Action action) {
        Validate.isSafe(action);
        actions.add(action);
    }
    
    public boolean isAllowed(Class<? extends Action> action) {
        Validate.isSafe(action);
        return (!Herobrine.getConfigFile().getStringList("Herobrine.disallowedActions").contains(action.getSimpleName()));
    }

    public ArrayList<Action> getActions() {
        return actions;
    }
}
