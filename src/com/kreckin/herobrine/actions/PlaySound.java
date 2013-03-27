package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.api.Action;
import com.kreckin.herobrine.util.Util;
import java.util.ArrayList;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PlaySound extends Action {
    
    private final ArrayList<Sound> sounds;

    public PlaySound() {
        super(true);
        this.sounds = new ArrayList<Sound>();
        this.sounds.add(Sound.AMBIENCE_CAVE);
        this.sounds.add(Sound.AMBIENCE_RAIN);
        this.sounds.add(Sound.AMBIENCE_THUNDER);
        this.sounds.add(Sound.BREATH);
        this.sounds.add(Sound.CAT_HISS);
        this.sounds.add(Sound.CREEPER_HISS);
        this.sounds.add(Sound.DOOR_CLOSE);
        this.sounds.add(Sound.DOOR_OPEN);
        this.sounds.add(Sound.ENDERDRAGON_GROWL);
        this.sounds.add(Sound.GHAST_MOAN);
        this.sounds.add(Sound.GHAST_SCREAM);
        this.sounds.add(Sound.GHAST_SCREAM2);
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        Sound sound = this.sounds.get(Util.getRandom().nextInt(this.sounds.size() - 1));
        player.playSound(player.getLocation(), sound, 1F, 1F);
        return ("Played: " + sound.toString());
    }
}
