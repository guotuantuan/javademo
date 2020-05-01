package com.gself.study.jExercise;

/**
 *
 * 根据堆排序将数组排序，然后求排列组合多少种
 * Created by gtt on 2020/3/22.
 */
public class CombineTestDemo {
    static int []arr = {9,8,7,6,5,4,3,2,1};
    public static void main(String[] args) {

        int m = 5;
        CombineTestDemo combineTest = new CombineTestDemo();
        combineTest.heapSort(arr);
        System.out.println("排序后：");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("组合：");
        combineTest.comb(0,m,"");

    }


    //对排序
    public void heapSort(int[]arr){
        int heapSize = arr.length;
        //建立大根堆
        for(int i=0;i<heapSize;i++){
            heapInsert(arr,i);
        }
        //调整数组中位置方法
        swap(arr,0,--heapSize);
        while(heapSize>0){
            heapfy(arr,0,heapSize);
            //调整数组中位置方法
            swap(arr,0,--heapSize);
        }

    }

    //构建大根堆
    public void heapInsert(int[] arr,int index){
        while(arr[index]>arr[(index-1)/2]){
            //调整数组中位置方法
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    //调整大根堆
    public void heapfy(int[]arr,int index,int heapSize){
        int left = index*2+1;
        while(left<heapSize){
            int largets = left+1<heapSize&&arr[left+1]>arr[left]?left+1:left;

            largets = arr[largets]>arr[index]?largets:index;
            if(largets==index){
                break;
            }
            //调整数组中位置方法
            swap(arr,largets,index);
            index = largets;
            left = index*2+1;
        }
    }

    //求组合方法
    public void comb(int index,int remain,String res){
        //递归终止条件，剩下的数字不够寻找足够的组合
        if(remain>arr.length-index){
            return;
        }
        //递归终止条件，直到remain==0，
        if(remain==0){
            System.out.println(res);
            return ;
        }
        //将这个数字加入到组合结果中，寻找其余组合，然后从index后一个位置递归这个方法，直到remain等于0，组合寻找结束
        comb(index+1,remain-1,(res+arr[index]+" "));
        //从index后一个位置递归，将后一个位置数字作为组合第一个数字
        comb(index+1,remain,res);

    }
    public void swap(int[]arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y]=temp;
    }

}
