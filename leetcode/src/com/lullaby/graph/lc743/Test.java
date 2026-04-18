package com.lullaby.graph.lc743;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(solution.networkDelayTime(times, 4, 2));
    }
}
