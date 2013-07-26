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
import com.kreckin.herobrine.actions.FlashMob;
import com.kreckin.herobrine.actions.PlaceChest;
import com.kreckin.herobrine.actions.SpinPlayer;
import com.kreckin.herobrine.actions.StealItem;
import com.kreckin.herobrine.actions.ThrowPlayer;
import com.kreckin.herobrine.actions.WolfAttack;
import java.util.ArrayList;
import java.util.List;

public class ActionManager {

    private final List<Action> actions = new ArrayList<>();
    private State state = State.UNLOADED;

    public void loadDefaultActions() {
        if (state.equals(State.LOADED)) {
            return;
        }
        state = state.LOADED;
        attemptLoad(new PlaceTorch());
        attemptLoad(new PlaceSign());
        attemptLoad(new DestroyTorches());
        attemptLoad(new CreateRingOfFire());
        attemptLoad(new BuryPlayer());
        attemptLoad(new CreateGrave());
        attemptLoad(new CreateTNTTrap());
        attemptLoad(new StealItem());
        attemptLoad(new RearrangeInventory());
        attemptLoad(new PossessPlayer());
        attemptLoad(new WolfAttack());
        attemptLoad(new BatAttack());
        attemptLoad(new CreatePyramid());
        attemptLoad(new PlaySound());
        attemptLoad(new GiftBook());
        attemptLoad(new SendMessage());
        attemptLoad(new RandomLightning());
        attemptLoad(new RandomExplosion());
        attemptLoad(new DimTorches());
        attemptLoad(new ThrowPlayer());
        attemptLoad(new GiftHead());
        attemptLoad(new CreateTotem());
        attemptLoad(new SpinPlayer());
        attemptLoad(new DuplicateItem());
        attemptLoad(new RandomStorm());
        attemptLoad(new BossAttack());
        attemptLoad(new DestroyChests());
        attemptLoad(new CreateTomb());
        attemptLoad(new CreateRingOfTorches());
        attemptLoad(new MobAttack());
        attemptLoad(new PlaceChest());
        attemptLoad(new CreateInfection());
        attemptLoad(new DecayFlowers());
        attemptLoad(new BurnPlayer());
        attemptLoad(new EffectExplosion());
        attemptLoad(new CreatePillar());
        attemptLoad(new CreateBlankTree());
        attemptLoad(new FlashMob());
    }
    
    public void attemptLoad(Action action) {
        if (isAllowed(action.getClass())) {
            actions.add(action);
        }
    }

    public boolean isAllowed(Class<? extends Action> action) {
        return (!Herobrine.getConfigFile().getStringList("Herobrine.disallowedActions").contains(action.getSimpleName()));
    }

    public List<Action> getActions() {
        return actions;
    }
}
