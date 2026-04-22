package com.lullaby.graph.lc802;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Deque<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> edges = new ArrayList<>();
        int[] outDegree = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            edges.add(new ArrayList<>());
            outDegree[i] = graph[i].length;
            if (graph[i].length == 0) {
                queue.offer(i);
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                edges.get(graph[i][j]).add(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int vertex : edges.get(u)) {
                if (--outDegree[vertex] == 0) {
                    queue.offer(vertex);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < outDegree.length; i++) {
            if (outDegree[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}