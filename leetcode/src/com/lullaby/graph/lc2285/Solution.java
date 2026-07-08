package com.lullaby.graph.lc2285;

import java.util.Arrays;

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] number = new long[n];
        for (int[] v : roads) {
            number[v[0]]++;
            number[v[1]]++;
        }
        Arrays.sort(number);
        long num = 1;
        long answer = 0;
        for (long i : number) {
            answer = answer + i * num++;
        }
        return answer;
    }
}
