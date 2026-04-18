package com.lullaby.graph.lc547;

//class Solution {
//
//    public int findCircleNum(int[][] isConnected) {
//        boolean[] mark = new boolean[isConnected.length];
//        int count = 0;
//        for (int i = 0; i < isConnected.length; i++) {
//            if (!mark[i]) {
//                dfs(i, mark, isConnected);
//                count++;
//            }
//        }
//
//        return count;
//    }
//
//    public void dfs(int u, boolean[] mark, int[][] isConnected) {
//        mark[u] = true;
//        for (int vertex = 0; vertex < isConnected[u].length; vertex++) {
//            if (!mark[vertex] && isConnected[u][vertex] == 1) {
//                dfs(vertex, mark, isConnected);
//            }
//        }
//    }
//}


import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] mark = new boolean[isConnected.length];
        int count = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < isConnected.length; i++) {
            if (!mark[i]) {
                count++;
                queue.offer(i);
                mark[i] = true;
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int vertex = 0; vertex < isConnected[u].length; vertex++) {
                        if (!mark[vertex] && isConnected[u][vertex] == 1) {
                            queue.offer(vertex);
                            mark[vertex] = true;
                        }
                    }
                }
            }
        }

        return count;
    }
}