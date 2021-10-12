package com.tianhai.leetcode;

import java.util.Arrays;

public class WC142 {
    public static void main(String[] args) {
        //哈希表，也可以先排序，再比较，
       /* Map map = new HashMap();
       for(int i=0;i<nums.length;i++){
         Object o = map.get(nums[i]); 
         if(o != null){
             return true;
         }else{
             map.put(nums[i],i);
         }
       }
        return false;*/
        int[] nums = {2,6,4,7,9,6};
        int left = 0;//左指针
        int right = nums[nums.length-1];//右指针
        sort(nums,left,right);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] nums,int left,int right){
        //先排序后比较
        //选择快排
        int base = nums[0];//基准数
        int i = left;
        while(left<right){
            while(left<right && nums[right-1]>base){
                right--;
            }
            while(left<right && nums[left]<base){
                left++;
            }
            if(left<right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        nums[i] = nums[left];
        nums[left] = base;
        sort(nums, i, left);
        sort(nums, i + 1, right);

    }

}