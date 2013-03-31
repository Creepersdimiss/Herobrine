package com.kreckin.herobrine.actions;

import com.kreckin.herobrine.Herobrine;
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
        for (String soundName : Herobrine.getConfigFile().getStringList("Herobrine.allowedSounds")) {
            if (Sound.valueOf(soundName) == null) {
                continue;
            }
            this.sounds.add(Sound.valueOf(soundName));
        }
    }

    @Override
    public String callAction(Player player, Object[] metadata) {
        if (this.sounds.isEmpty()) {
            return "Failed, there are no sounds in the configuration file!";
        }
        Sound sound;
        if (this.sounds.size() == 1) {
            sound = this.sounds.get(0);
        } else {
            sound = this.sounds.get(Util.getRandom().nextInt(this.sounds.size()));
        }
        player.playSound(player.getLocation(), sound, 1F, 1F);
        return ("Played: " + sound.toString());
    }
}
