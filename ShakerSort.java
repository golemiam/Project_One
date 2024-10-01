package com.example.shakersort;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;


public class ShakerSort {
    public static void main(String[] args) {
        ShakerSort randomObject = new ShakerSort();
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int rannum = randomObject.Randomness(100);
            numberList.add(rannum);
        }
        System.out.println((Math.min(numberList.get(2), numberList.get(5))));
        boolean swapped;
        do {
            for (int i = 0; i < arr.length - 1; i++) {
                int temp
            }
        }
        //int mini = Math.min(numberList);
        //System.out.println(mini);
        //System.out.println(numberList);

    }
    public static int Randomness (int num) {
        Random random = new Random();
        int first = random.nextInt(num);
        System.out.println(first);
        return first;
    }

}
