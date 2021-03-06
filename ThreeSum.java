package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            int n = nums.length;
            if(n == 0) return result;

            Arrays.sort(nums);

            for(int p1 = 0 ; p1 < n-2 ; p1++){
                if (p1 > 0 && nums[p1 - 1] == nums[p1]) continue;
                int l = p1+1;
                int r = n-1;
                while(l < r){
                    int sum = nums[l] + nums[r]  + nums[p1];
                    if(sum == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[p1]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        result.add(list);
                        while (l < r && nums[l] == nums[l+1]) l++;//skip same
                        while (l < r && nums[r] == nums[r-1]) r--;//skip same
                    }
                    if(sum < 0){
                        l++;
                    }else{//always consume one element even when sum == 0
                        r--;
                    }
                }
            }

            return result;
        }
    }
}
