package com.gself.study.jdataStructure;

/**
 * Created by gtt on 2020/3/24.
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        QuickSortDemo th = new QuickSortDemo();
//        int []arr = {9,8,7,6,5,4,3,2,1};
        int []arr = new int[]{3,2,4,4,6,7,8,4};
        th.quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public void quickSort(int[]arr,int l,int r){
        if(l<r){
            int[]help = partition(arr,l,r);
            quickSort(arr,l,help[0]-1);
            quickSort(arr,help[1]+1,r);
        }
    }
    public int[] partition(int []arr,int l,int r){
        int less = l-1;
        int more = r;
        while(l<more){
            if(arr[l]>arr[r]){
                swap(arr,l,--more);
            }else if(arr[l]<arr[r]){
                swap(arr,++less,l++);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }



    public void swap(int[]arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y]=temp;
    }

}
