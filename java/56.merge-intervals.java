/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<int[]> res = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || ends[i] < starts[i + 1]) {
                // int[] newInterval = new int[2];
                // newInterval[0] = starts[j];
                // newInterval[1] = ends[i];
                res.add(new int[] { starts[j], ends[i] });
                j = i + 1;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2)
            return intervals;
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        res.add(newInterval);
        for (int[] i : intervals) {
            if (i[0] <= newInterval[1])
                newInterval[1] = Math.max(i[1], newInterval[1]);
            else {
                newInterval = i;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
