package com.gself.study.jExercise;

/**
 *
 * 二分查找算法
 * Created by gtt on 2020/3/26.
 */
public class BinarySearchDemo {
    public int binaSe(int []arr,int target){
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int mid = (r+l)/2;
            if(arr[mid]>target){
                r = mid-1;
            }else if(arr[mid]<target){
                l=mid+1;
            }else{
                return mid;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7,8,9};
        BinarySearchDemo search = new BinarySearchDemo();
        System.out.println(search.binaSe(arr,4));

    }
}
