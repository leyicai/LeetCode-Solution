import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        // add the first end time
        for (int[] interval : intervals) {
            Integer earliestEndTime = rooms.peek();
            if (earliestEndTime == null) {
                rooms.add(interval[1]);
                continue;
            }
            if (interval[0] < earliestEndTime) {
                // need more room
                rooms.add(interval[1]);
            } else {
                // update end time of the room
                rooms.poll();
                rooms.add(interval[1]);
            }
        }
        return rooms.size();
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return 0;
        }
        int n = intervals.length;
        int[] startTime = new int[n];
        int[] endTime = new int[n];
        for (int i = 0; i < n; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        // sort startTime and endTime seperately
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int res = 0, start = 0, end = 0;

        while (start < n && end < n) {
            if (startTime[start] < endTime[end]) {
                // need more room
                res++;
            } else {
                // can reuse finished room
                end++;
            }
            start++;
        }
        return res;
    }
}
// @lc code=end
