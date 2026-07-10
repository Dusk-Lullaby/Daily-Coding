package com.lullaby.graph.lc2368;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> graph = new ArrayList<>();
    int[] limit;
    int count;
    boolean[] sign;
    int size = 0;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        count = n;
        limit = restricted;
        sign = new boolean[n];
        for (int u : restricted) {
            sign[u] = true;
        }
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] info : edges) {
            graph.get(info[0]).add(info[1]);
            graph.get(info[1]).add(info[0]);
        }

        dfs(0);
        return size;
    }

    public void dfs(int vertex) {
        size++;
        sign[vertex] = true;
        for (int u : graph.get(vertex)) {
            if (!sign[u]) {
                dfs(u);
            }
        }
    }
}
