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
import com.kreckin.herobrine.actions.RearrangeInventory;
import com.kreckin.herobrine.actions.SendMessage;
import com.kreckin.herobrine.actions.StealItem;
import com.kreckin.herobrine.actions.WolfAttack;
import java.util.ArrayList;
import java.util.logging.Level;

public class ActionManager {

    private final ArrayList<Action> actions;
    
    public ActionManager() {
        this.actions = new ArrayList<Action>();
        this.actions.add(new PlaceTorch());
        this.actions.add(new PlaceSign());
        this.actions.add(new DestroyTorches());
        this.actions.add(new CreateRingOfFire());
        this.actions.add(new BuryPlayer());
        this.actions.add(new CreateGrave());
        this.actions.add(new CreateTNTTrap());
        this.actions.add(new StealItem());
        this.actions.add(new RearrangeInventory());
        this.actions.add(new PossessPlayer());
        this.actions.add(new WolfAttack());
        this.actions.add(new BatAttack());
        this.actions.add(new CreatePyramid());
        this.actions.add(new PlaySound());
        this.actions.add(new AltarSummon());
        this.actions.add(new GiftBook());
        this.actions.add(new SendMessage());
        for (Action action : this.actions) {
            Herobrine.log("Registered Action: " + action.getClass().getSimpleName(), Level.INFO);
        }
    }

    public ArrayList<Action> getActions() {
        return this.actions;
    }
}
