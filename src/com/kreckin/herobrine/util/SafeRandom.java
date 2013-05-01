package com.kreckin.herobrine.util;

import com.kreckin.herobrine.Herobrine;
import java.util.Random;

public class SafeRandom extends Random {

    private int sinceReseed;

    public int nextInt(int min, int max) {
        if (min < 0 || max <= 0) {
            return -1;
        }
        sinceReseed++;
        if (sinceReseed > 10) {
            sinceReseed = 0;
            setSeed(nextLong());
        }
        return super.nextInt(min, max);
    }
}
