package com.lullaby.graph.lc2368;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 7;
        int[][] edges = {{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
        int[] T = {4,5};
        System.out.println(solution.reachableNodes(n, edges, T));
    }
}
