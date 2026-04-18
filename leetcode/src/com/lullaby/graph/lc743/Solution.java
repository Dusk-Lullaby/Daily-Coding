package com.lullaby.graph.lc743;

//import java.util.ArrayList;
//import java.util.List;
//
//class Solution {
//
//    List<List<int[]>> edges = new ArrayList<>();
//    boolean[] mark;
//    int[] path;
//    static final int INF = 0x3f3f3f3f;
//
//    public int networkDelayTime(int[][] times, int n, int k) {
//        mark = new boolean[n + 1];
//        path = new int[n + 1];
//        edges.add(new ArrayList<>());
//        for (int i = 1; i <= n; i++) {
//            edges.add(new ArrayList<>());
//            path[i] = INF;
//        }
//        for (int[] info : times) {
//            edges.get(info[0]).add(new int[]{info[1], info[2]});
//            if (info[0] == k) {
//                path[info[1]] = info[2];
//            }
//        }
//
//        mark[k] = true;
//        path[k] = 0;
//        for (int i = 0; i < n - 1; i++) {
//            int min = INF;
//            int tempIndex = -1;
//            for (int j = 1; j <= n; j++) {
//                if (!mark[j] && min > path[j]) {
//                    tempIndex = j;
//                    min = path[j];
//                }
//            }
//            if (tempIndex == -1) break;
//            mark[tempIndex] = true;
//
//            for (int[] info : edges.get(tempIndex)) {
//                if (!mark[info[0]] && path[tempIndex] + info[1] < path[info[0]]) {
//                    path[info[0]] = path[tempIndex] + info[1];
//                }
//            }
//        }
//
//        int res = -1;
//        for (int i = 1; i <= n; i++) {
//            int dist = path[i];
//            res = Math.max(res, dist);
//            if (res == INF) return -1;
//        }
//
//        return res;
//    }
//}



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    static final int INF = 0x3f3f3f3f;
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        // 建图
        @SuppressWarnings("unchecked")
        List<int[]>[] edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] info : times) {
           edges[info[0]].add(new int[] {info[1], info[2]});
        }
        dist[k] = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        priorityQueue.offer(new int[] {k, 0});

        while (!priorityQueue.isEmpty()) {
            int[] u = priorityQueue.poll();

            if (dist[u[0]] < u[1]) {
                continue;
            }

            for (int[] neighbor : edges[u[0]]) {
                if (dist[u[0]] + neighbor[1] < dist[neighbor[0]]) {
                    priorityQueue.offer(new int[] {neighbor[0], dist[u[0]] + neighbor[1]});
                    dist[neighbor[0]] = dist[u[0]] + neighbor[1];
                }
            }
        }

        int res = -1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) return -1;
            res = Math.max(res, dist[i]);
        }

        return res;
    }
}