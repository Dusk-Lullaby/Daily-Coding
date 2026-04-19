package com.lullaby.graph.lc785;

//import java.util.ArrayDeque;
//import java.util.Deque;
//
///**
// * 解法一：BFS
// * O(n + m)
// * n 是点的个数，m 是边的个数，遍历所有节点和所有边
// */
//class Solution {
//    public boolean isBipartite(int[][] graph) {
//        // 标记数组，0代表未搜索，1和2代表集合的种类
//        int[] mark = new int[graph.length];
//        Deque<Integer> queue = new ArrayDeque<>();
//        // 遍历所有节点
//        for (int i = 0; i < graph.length; i++) {
//            // 如果该节点未被搜索就加入队列
//            if (mark[i] == 0) {
//                queue.offer(i);
//                // 设置为集合1
//                mark[i] = 1;
//                // BFS
//                while (!queue.isEmpty()) {
//                    int num = queue.poll();
//                    for (int neighbor : graph[num]) {
//                        // 未被搜索就加入队列
//                        if (mark[neighbor] == 0) {
//                            queue.offer(neighbor);
//                            // 如果当前节点是1，那么待搜索节点就是2，反之为1
//                            mark[neighbor] = mark[num] == 1 ? 2 : 1;
//                        // 如果当前节点和待搜索节点属于同一个集合，即mark[A] == mark[B]那么说明直接返回false
//                        } else if (mark[neighbor] == mark[num]) {
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//
//        return true;
//    }
//}


/**
 * 解法二：DFS
 * O(N + M)
 * n 是点的个数，m 是边的个数，遍历所有节点和所有边
 */
class Solution {
    // 标记数组，0代表未被搜索，1和2代表所属集合
    int[] mark;
    // 是否是二分图
    boolean flag = true;

    public boolean isBipartite(int[][] graph) {
        // 初始化
        mark = new int[graph.length];
        // 遍历所有节点
        for (int i = 0; i < graph.length; i++) {
            // 如果当前节点未被搜索，则进行DFS
            if (mark[i] == 0) {
                dfs(i, 1, graph);
            }
        }

        return flag;
    }

    /**
     * DFS
     * @param u 当前节点
     * @param num 当前节点所属集合
     * @param graph 图
     */
    public void dfs(int u, int num, int[][] graph) {
        // 如果不是二分图，直接返回
        if (!flag) {
            return;
        }
        // 将当前节点打上所属集合标记
        mark[u] = num;
        // 遍历所有邻接节点
        for (int vertex : graph[u]) {
            // 如果没有被搜索
            if (mark[vertex] == 0) {
                // 如果当家节点是集合1，那么邻接节点就是2，反之为1
                dfs(vertex, num == 1 ? 2 : 1, graph);
            // 如果当前节点和邻接节点属于同一个集合，直接返回false
            } else if (mark[vertex] == num) {
                flag = false;
                return;
            }
        }
    }
}