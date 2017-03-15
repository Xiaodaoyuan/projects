package com.xiaody.sort;

import java.util.Comparator;

/**
 * Created by Xiaody on 2017/2/15.
 */
public interface Sorter {

    /**
     * 排序
     *
     * @param list 待排序的数组
     */
    <T extends Comparable<T>> void sort(T[] list);

    /**
     * 排序
     *
     * @param list 待排序的数组
     * @param start 开始位置
     * @param end 结束位置
     */
    <T extends Comparable<T>> void sort(T[] list, int start, int end);
}
