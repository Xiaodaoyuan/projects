package com.xiaody.sort.impl;

import com.xiaody.sort.Sorter;

/**
 * Created by Xiaody on 2017/2/15.
 */
public class ChooseSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        for (int i = 0; i < list.length; i++) {
            int index = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[index]) < 0) {
                    index = j;
                }
                if (i != index) {
                    T temp = list[i];
                    list[i] = list[index];
                    list[index] = temp;
                }
            }
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] list, int start, int end) {

    }
}
