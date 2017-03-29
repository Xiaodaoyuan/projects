package com.xiaody.algorithm;

/**
 * Created by Xiaody on 17/3/13.
 * <p>
 * 题目：找出数组中出现次数超过一半的数字
 */
public class MoreThanHalf {

    public static int moreThanHalf(int[] num) {
        int result = -1;
        int times = 0;
        for (int i = 0; i < num.length; i++) {
            if (times == 0) {
                result = num[i];
                times++;
            } else {
                if (result == num[i]) {
                    times++;
                } else {
                    times--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int num[] = {1, 3, 3, 4, 1, 3, 3};
        System.out.println(moreThanHalf(num));
    }
}
