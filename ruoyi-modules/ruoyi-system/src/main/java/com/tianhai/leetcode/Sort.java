package com.tianhai.leetcode;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author: wuynje
 * @Date: 2021/9/9 21:37
 * @Description:
 */
public class Sort {

    private int[] nums = {3, 5, 2, 6, 7, 4, 12, 8,8,100,23,56,33,98};

    /**
     * 选择排序
     */
    void sort1() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 冒泡排序
     */
    void sort2() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 快速排序
     */
    void sort3() {
        this.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    void quickSort(int[] n, int left, int right) {
        if (left >= right) {
            return;
        }
        int start = left;
        int end = right;
        int base = n[left];
        while (left < right) {
            while (left < right && n[right] >= base) {
                right--;
            }
            while (left < right && n[left] <= base) {
                left++;
            }
            if (left < right) {
                int tmp = n[left];
                n[left] = n[right];
                n[right] = tmp;
            }
        }
        //与基准位交换
        int tmp = n[start];
        n[start] = n[right];
        n[right] = tmp;
        this.quickSort(n, start, left-1);
        this.quickSort(n, left+1, end);

    }

    public int reverse(int x) {
        Integer y = x;
        //先去掉符号
        if(y<0){
            y = y*-1;
        }
        String s = y.toString();
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length-1;
        while(left<right){
            char tmp = c[left];
            c[left] = c[right];
            c[right] = tmp;
            left++;
            right--;
        }
        String r = "";
        for(int i = 0;i<c.length;i++){
            if(c[i]!=0){
                r = r+c[i];
            }
        }

        int res = Integer.parseInt(r);
        if(x<0){
            res = res*-1;
        }

        return res;
    }

    public static void main(String[] args) {
//        new Sort().sort3();
        new Sort().reverse(1534236469);
    }


}
