package com.lullaby.greed.lc1642;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        int num = 0;
        while (num < heights.length - 1) {
            int height = heights[num + 1] - heights[num];
            if (height > 0) {
                priorityQueue.offer(height);
                if (priorityQueue.size() > ladders) {
                    bricks -= priorityQueue.poll();
                    if (bricks < 0) return num;
                }
            }
            num++;
        }
        return num;
    }
}