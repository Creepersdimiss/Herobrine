package com.kreckin.herobrine.util;

public class Validate {
    
    public static void isSafe(Object... objects) {
        if (objects == null) {
            throw (new IllegalArgumentException("Null object!"));
        }
        for (int index = 0; index < objects.length; index++) {
            if (objects[index] == null) {
                throw (new IllegalArgumentException("Null object at index: " + index + "!"));
            }
        }
    }
}
