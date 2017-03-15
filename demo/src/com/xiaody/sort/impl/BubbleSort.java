package com.xiaody.sort.impl;

import com.xiaody.sort.Sorter;

/**
 * Created by Xiaody on 2017/2/15.
 */
public class BubbleSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        for (int i = 1; i < list.length && swapped; i++) {
            swapped = false;
            for (int j = 0; j < list.length - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] list, int start, int end) {
        boolean swapped = true;
        for (int i = start + 1; i < end && swapped; i++) {
            swapped = false;
            for (int j = start; j < end - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }


}
