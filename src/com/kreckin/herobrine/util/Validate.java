package com.kreckin.herobrine.util;

public class Validate {
    
    public static void isSafe(Object... objects) {
        if (objects == null) {
            throw (new IllegalArgumentException("Null object!"));
        }
        for (Object object : objects) {
            if (object == null) {
                throw (new IllegalArgumentException("Null object!"));
            }
        }
    }
}
