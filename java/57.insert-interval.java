import java.util.List;

/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */
// sort and merge 41.56%
// class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         int n = intervals.length;
//         int[] starts = new int[n + 1];
//         int[] ends = new int[n + 1];
//         for (int i = 0; i < n; i++) {
//             starts[i] = intervals[i][0];
//             ends[i] = intervals[i][1];
//         }
//         starts[n] = newInterval[0];
//         ends[n] = newInterval[1];
//         Arrays.sort(starts);
//         Arrays.sort(ends);

//         List<int[]> res = new ArrayList<>();
//         for (int i = 0, j = 0; i <= n; i++) {
//             if (i == n || ends[i] < starts[i + 1]) {
//                 res.add(new int[] { starts[j], ends[i] });
//                 j = i + 1;
//             }
//         }
//         return res.toArray(new int[res.size()][]);
//     }
// }
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length < 1) {
            return new int[][] { newInterval };

        }
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while (i < intervals.length) {
            res.add(intrervals[i++]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
