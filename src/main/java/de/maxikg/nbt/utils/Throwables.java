package de.maxikg.nbt.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Throwables {

    public static RuntimeException propagate(Throwable throwable) {
        if (throwable instanceof RuntimeException)
            throw (RuntimeException) throwable;
        else
            throw new RuntimeException(throwable);
    }
}
