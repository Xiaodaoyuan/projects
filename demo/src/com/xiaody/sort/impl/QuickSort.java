package com.xiaody.sort.impl;

import com.xiaody.sort.Sorter;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Xiaody on 2017/2/15.
 */
public class QuickSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        List<String> list1 = new ArrayList<>();
        list1.forEach(l-> System.out.println(l));
        Map<String,String> map = new HashMap<>();
        map.forEach((k,v)-> System.out.println(k));
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] list, int start, int end) {
        
    }

    public static <T> T find(T[] x){
        T temp = null;
        for(int i = 0, nTimes = 0; i< x.length;i++) {
            if(nTimes == 0) {
                temp= x[i];
                nTimes= 1;
            }
            else {
                if(x[i].equals(temp)) {
                    nTimes++;
                }
                else {
                    nTimes--;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
//        String[]strs = {"maybe","maybe","maybe","hello","hello","hello","kiss","hello"};
//        System.out.println(find(strs));
        Random ran = new Random();
        System.out.println(Math.random());
    }

}
