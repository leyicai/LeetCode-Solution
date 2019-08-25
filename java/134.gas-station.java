/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, start, end;
        start = gas.length - 1;
        end = 0;
        sum += gas[start] - cost[start];
        while (end < start) {
            if (sum < 0) {
                start--;
                sum += gas[start] - cost[start];
            } else {
                sum += gas[end] - cost[end];
                end++;
            }
        }
        return sum < 0 ? -1 : start;
    }
}
