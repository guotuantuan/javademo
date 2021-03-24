package com.gself.study.jExercise.algorithmDemo;

public class AgDemo {
    public static void main(String[] args) {
        AgDemo agDemo = new AgDemo();
        int[] arr = {5, 4, 3, 2, 1};
        agDemo.selectSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            int index = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    index = j;
                }
            }
            swap(arr,index,i);
        }
    }

    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }

        }
    }

    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
