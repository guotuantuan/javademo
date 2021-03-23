package com.gself.study.jExercise.algorithmDemo;

public class AgDemo {
    public static void main(String[] args) {
        AgDemo agDemo = new AgDemo();
        int[] arr = {5, 4, 3, 2, 1};
        agDemo.bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public void bubbleSort(int[]arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }

        }
    }

    public void swap(int []arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
