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
    
    public ActionManager() {
        actions.add(new PlaceTorch());
        actions.add(new PlaceSign());
        actions.add(new DestroyTorches());
        actions.add(new CreateRingOfFire());
        actions.add(new BuryPlayer());
        actions.add(new CreateGrave());
        actions.add(new CreateTNTTrap());
        actions.add(new StealItem());
        actions.add(new RearrangeInventory());
        actions.add(new PossessPlayer());
        actions.add(new WolfAttack());
        actions.add(new BatAttack());
        actions.add(new CreatePyramid());
        actions.add(new PlaySound());
        actions.add(new GiftBook());
        actions.add(new SendMessage());
        actions.add(new RandomLightning());
        actions.add(new RandomExplosion());
        actions.add(new DimTorches());
        actions.add(new ThrowPlayer());
        actions.add(new GiftHead());
        actions.add(new CreateTotem());
        actions.add(new SpinPlayer());
        actions.add(new DuplicateItem());
        actions.add(new RandomStorm());
        actions.add(new BossAttack());
        actions.add(new DestroyChests());
        actions.add(new CreateTomb());
        actions.add(new CreateRingOfTorches());
        actions.add(new MobAttack());
        actions.add(new PlaceChest());
        actions.add(new CreateInfection());
        actions.add(new DecayFlowers());
        actions.add(new BurnPlayer());
        actions.add(new EffectExplosion());
        actions.add(new CreatePillar());
        actions.add(new CreateBlankTree());
        actions.add(new FlashMob());
    }

    public boolean isAllowed(Class<? extends Action> action) {
        return (!Herobrine.getConfigFile().getStringList("Herobrine.disallowedActions").contains(action.getSimpleName()));
    }

    public List<Action> getActions() {
        return actions;
    }
}
