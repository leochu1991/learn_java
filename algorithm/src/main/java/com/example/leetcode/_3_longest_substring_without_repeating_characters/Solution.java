package com.example.leetcode._3_longest_substring_without_repeating_characters;

import java.util.HashSet;

/**
 * 3.无重复字符的最长子串（子串：substring，连续；子序列：subsequence，不连续）
 * 滑动窗口，时间复杂度左右指针遍历，O(2*n)，即O(n)，空间复杂度hashSet，即O(n)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 左右指针left，right，字符串下标
        int res = 0, left = 0, right = 0;
        // s中不重复子串字符集合
        HashSet<Character> charSet = new HashSet<>();
        while (right < s.length()) {
            // set中不包含重复字符，移动right遍历
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                right++;
                res = Math.max(res, charSet.size());
            } else {
                // 否则移除s[left]处字符，直到set中没有重复字符
                charSet.remove(s.charAt(left));
                left++;
            }
        }

        return res;
    }
}
