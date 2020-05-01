package com.gself.study.jdataStructure;

/**
 * Created by gtt on 2020/3/23.
 */
public class HeapSortDemo {
    public static void main(String[] args) {
        HeapSortDemo th = new HeapSortDemo();
        int []arr = {9,8,7,6,5,4,3,2,1};
        th.heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("---");
        th.combine(arr,0,8,"");

    }
    public void combine(int[]arr,int start,int remain,String res){
        if(remain>arr.length-start){
            return;
        }
        if(remain==0){
            System.out.println(res);
            return;
        }
        combine(arr,start+1,remain-1,(res+arr[start]+" "));
        combine(arr,start+1,remain,res);

    }
    public void heapSort(int[]arr){
        int heapSize = arr.length;
        for(int i=0;i<heapSize;i++){
            heapInsert(arr,i);
        }
        swap(arr,0,--heapSize);
        while(heapSize>0){
            heapfy(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }



    public void heapInsert(int []arr,int index){
        while(arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index  = (index-1)/2;
        }
    }

    public void heapfy(int[]arr,int index,int heapSize){
        int left = index*2+1;
        while(left<heapSize){
            int largets = (left+1)<heapSize&&arr[left+1]>arr[left]?left+1:left;
            largets = arr[index]>largets?index:largets;
            if(largets==index){
                break;
            }
            swap(arr,index,largets);
            index = largets;
            left = largets*2+1;
        }
    }






    public void swap(int[]arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y]=temp;
    }
}
