package com.kreckin.herobrine.util;

import java.util.Random;

public class SafeRandom extends Random {

    private int sinceReseed;

    @Override
    public int nextInt(int max) {
        if (max <= 0) {
            return 0;
        }
        sinceReseed++;
        if (sinceReseed > 10) {
            sinceReseed = 0;
            setSeed(nextLong());
        }
        return super.nextInt(max);
    }
}
