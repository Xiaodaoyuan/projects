package com.xiaody.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xiaody on 2017/3/21.
 */
public class FindSubString {

    public static int findSubString(String s, String t, int pos) {
        if (pos < 0 || pos >= s.length()) {
            return -1;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int i = pos;
        int j = 0;
        while (i < sChar.length && j < tChar.length) {
            if (sChar[i] == tChar[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == tChar.length - 1) {
                return i - j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findSubString("goodgofoglego1oglego1ogle", "google", 5));
    }
}
