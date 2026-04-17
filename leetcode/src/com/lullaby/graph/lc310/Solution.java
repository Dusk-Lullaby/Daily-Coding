package com.lullaby.graph.lc310;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

///**
// * DFS
// */
//class Solution {
//
//    List<List<Integer>> graph = new ArrayList<>();
//    boolean[] mark;
//    int minHeight;
//
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        for (int i = 0; i < n; i++) {
//            graph.add(new ArrayList<>());
//        }
//        for (int[] info : edges) {
//            graph.get(info[0]).add(info[1]);
//            graph.get(info[1]).add(info[0]);
//        }
//
//        int[] height = new int[n];
//        int min = 100000000;
//        for (int i = 0;i < n; i++) {
//            mark = new boolean[n];
//            minHeight = -1;
//            dfs(i, 0);
//            height[i] = minHeight;
//            min = Math.min(minHeight, min);
//        }
//
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (height[i] == min) {
//                res.add(i);
//            }
//        }
//
//        return res;
//    }
//
//    public void dfs(int u, int step) {
//        mark[u] = true;
//        minHeight = Math.max(minHeight, step);
//
//        for (int vertex : graph.get(u)) {
//            if (!mark[vertex]) {
//                dfs(vertex, step + 1);
//            }
//        }
//    }
//}


class Solution {

    List<List<Integer>> graph = new ArrayList<>();
    int[] degree;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            return new ArrayList<>(List.of(0));
        }

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        degree = new int[n];
        for (int[] info : edges) {
            graph.get(info[0]).add(info[1]);
            graph.get(info[1]).add(info[0]);
            degree[info[0]]++;
            degree[info[1]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int remainSize = n;
        while (remainSize > 2) {
            int queueSize = queue.size();
            remainSize -= queueSize;
            for (int i = 0; i < queueSize; i++) {
                int num = queue.poll();
                for (int vertex : graph.get(num)) {
                    if (--degree[vertex] == 1) {
                        queue.offer(vertex);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }

        return res;
    }
}