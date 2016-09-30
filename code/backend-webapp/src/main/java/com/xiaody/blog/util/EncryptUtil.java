package com.xiaody.blog.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by Xiaody on 2016/9/30.
 */
public class EncryptUtil {

    public static String hash(String input) {
        if (input == null)
            return null;

        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(input.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1, digest);

            String result = bigInt.toString(16);
            if (result.length() > 32)
                result = result.substring(0, 32);

            // forget to padding left 0 to len-32, which does not meet MD5 standard

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
