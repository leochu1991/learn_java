package com.example.leetcode._1_two_sum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // 保存map，key为nums[i],value为i
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // 遍历nums，target-nums[i]在map中，且下标不为i
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain) && map.get(remain) != i) {
                res[0] = i;
                res[1] = map.get(remain);
                break;
            }
        }
        return res;
    }
}
