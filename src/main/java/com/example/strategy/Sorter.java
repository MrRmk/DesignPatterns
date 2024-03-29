package com.example.strategy;

public class Sorter<T> {
    /**
     * 选择排序
     * @param arr
     */
    /*public static void sort(int[] arr){
        for (int i=0; i<arr.length; i++) {
            int minPos = i;

            for(int j=i+1; j<arr.length; j++){
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }
    //交换
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    */

    public void sort(T[] arr, Comparator<T> comparator){
        for (int i=0; i<arr.length; i++) {
            int minPos = i;

            for(int j=i+1; j<arr.length; j++){
                minPos = comparator.compare( arr[j], arr[minPos] )==-1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }
    void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
