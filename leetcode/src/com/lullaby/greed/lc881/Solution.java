package com.lullaby.greed.lc881;

import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left < right) {
            int sum = people[left] + people[right];
            if (sum > limit) {
               res++;
               right--;
            } else {
                res++;
                left++;
                right--;
            }
        }
        if (left == right) {
            res++;
        }
        return res;
    }
}