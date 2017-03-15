package com.xiaody.algorithm;

/**
 * Created by Xiaody on 2017/2/23.
 */
public class Josephu {

    /**
     * 约瑟夫环问题
     * @param n  环的总数
     * @param m  数到m的数删除
     * @return  依次删除的数在数组中下标的集合
     */
    public static int[] getDeleteIndex(int n, int m) {
        boolean[] array = new boolean[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = true;
        }
        int count = 0;
        int number = 0;
        int index = 0;
        int[] returnArray = new int[n];
        while (count < n) {
            if (array[index]) {
                number++;
                if (number == m) {
                    array[index] = false;
                    returnArray[count] = index;
                    count++;
                    number = 0;
                }
            }
            index++;
            if (index >= array.length) {
                index = 0;
            }
        }
        return returnArray;
    }

    public static void main(String[] args) {
        int[] array = getDeleteIndex(30, 9);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
