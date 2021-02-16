package com.rukon.test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int a[] = {2, 3};

        countingSort(a, 2, 3);
        int result[] = new int[a.length];
        int count[] = new int[6];

        for (int i = 0; i < a.length; i++){
            count[a[i]-1]++;
//            for(int j=0; j< count.length; j++){
//                if(a[i]==j){
//                 count[j] = count[j]+1;
//                }

           // }


        }
        System.out.println(Arrays.toString(count));
        for(int i = 0; i < count.length-1; i++){
            count[i+1] = count[i]+ count[i+1];
        }
        System.out.println(Arrays.toString(count));

        for (int i = 0; i < a.length; i++){

            for (int j = 0; j < count.length; j++){
                if(a[i]==j){
                    result[count[j]-1]= a[i];
                    count[j] -=1;
                }
            }
        }

        System.out.println(Arrays.toString(result));


    }

    public static void countingSort(int[] input, int min, int max) {

        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }
        }

    }
}
