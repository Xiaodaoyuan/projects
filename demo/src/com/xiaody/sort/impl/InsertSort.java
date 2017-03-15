package com.xiaody.sort.impl;

import com.xiaody.sort.Sorter;

/**
 * Created by Xiaody on 2017/2/15.
 */
public class InsertSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j].compareTo(list[j - 1]) < 0) {
                    T temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                }
            }
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] list, int start, int end) {

    }
}
