package Abstraction.Interfaces;

import java.util.Arrays;

interface Sortable {
    void sort(int[] arr);
}

class BubbleSort implements Sortable {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j] > arr[j+1]) {
                    // swap.
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

class SelectionSort implements Sortable {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                //find min.
                if(arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            // swap the min index with proper i,
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;

            for(int k = 0; k < arr.length; k++){
                System.out.print(arr[k] + " ");
            }
            System.out.println(" ");
        }
    }
}

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {5,1,2,3,4};
        SelectionSort selectionSort = new SelectionSort();
        System.out.println("Initial array: ");
        System.out.println(Arrays.toString(arr));


        selectionSort.sort(arr);
        System.out.println("Selection Sort: ");
        System.out.println(Arrays.toString(arr));

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        System.out.println("Bubble sort: ");
        System.out.println(Arrays.toString(arr));
    }
}