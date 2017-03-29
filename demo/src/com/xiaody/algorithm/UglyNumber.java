package com.xiaody.algorithm;

/**
 * Created by Xiaody on 17/3/13.
 * <p>
 * 题目：我们把只包含因子2，3和5的数称为丑数。求按从小到大的顺序第1500个丑数。
 * 例如6，8都是丑数，14不是，因为14包含因子7。我们习惯把1当作第一个丑数。
 */
public class UglyNumber {

    public static int findUglyNumber(int index) {
        int num[] = new int[index];
        int next = 0;
        num[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while (next < index) {
            int num2 = num[index2] * 2;
            int num3 = num[index3] * 3;
            int num5 = num[index5] * 5;
            int suitableNum = getSuitableNum(num2, num3, num5);

        }
        return 0;
    }

    public static int getSuitableNum(int num2, int num3, int num5) {
        int suitableNum = num2;
        if (suitableNum > num3) {
            suitableNum = num3;
        }
        if (suitableNum > num5) {
            suitableNum = num5;
        }
        return suitableNum;
    }

    public static void main(String[] args) {
        System.out.println(findUglyNumber(2));
    }
}
