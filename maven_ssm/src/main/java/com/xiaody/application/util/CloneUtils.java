package com.xiaody.application.util;


import com.esotericsoftware.kryo.Kryo;
import com.rits.cloning.Cloner;

public final class CloneUtils {
    private static ThreadLocal<Kryo> kryo = new ThreadLocal<Kryo>();

    private CloneUtils() {
    }

    public static <T> T clone(T source) {
        if (source == null)
            return null;

        // there is some issue when integrate kryo clone with MyBatis, need more investigation
        return robustClone(source);
    }

    public static <T> T robustClone(T source) {
        Cloner cloner = new Cloner();
        return cloner.deepClone(source);
    }

    public static <T> T kryoClone(T source) {
        if (source == null) {
            return null;
        }

        try {
            return getOrCreateLocalKryo().copy(source);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Kryo getOrCreateLocalKryo() {
        Kryo localKryo = kryo.get();
        if (localKryo == null) {
            localKryo = new Kryo();

            kryo.set(localKryo);
        }

        return localKryo;
    }
}
