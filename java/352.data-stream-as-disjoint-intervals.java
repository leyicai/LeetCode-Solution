import java.util.List;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=352 lang=java
 *
 * [352] Data Stream as Disjoint Intervals
 */
//69.23%
// class SummaryRanges {
//     /** Initialize your data structure here. */
//     public SummaryRanges() {
//         intervals = new ArrayList<>();
//     }

//     public void addNum(int val) {
//         int[] newInterval = new int[] { val, val };
//         int i = 0, overlap = 0;
//         while (i < intervals.size() && intervals.get(i)[1] < val - 1) {
//             i++;
//         }
//         while (i < intervals.size() && intervals.get(i)[0] <= newInterval[1] + 1) {
//             newInterval[0] = Math.min(newInterval[0], intervals.get(i)[0]);
//             newInterval[1] = Math.max(newInterval[1], intervals.get(i)[1]);
//             overlap++;
//             i++;
//         }
//         // for(int[] inter : intervals){
//         // System.out.println(Arrays.toString(inter));
//         // }
//         if (overlap > 0) {
//             int j = 0;
//             while (j < overlap) {
//                 intervals.remove(i - overlap);
//                 j++;
//             }
//         }
//         // for(int[] inter : intervals){
//         // System.out.println(Arrays.toString(inter));
//         // }
//         intervals.add(i - overlap, newInterval);
//     }

//     public int[][] getIntervals() {
//         return intervals.toArray(new int[intervals.size()][]);
//     }

//     private List<int[]> intervals;
// }

// // treemap 79.33%
// class SummaryRanges {
//     /** Initialize your data structure here. */
//     public SummaryRanges() {
//         tree = new TreeMap<>();
//     }

//     public void addNum(int val) {
//         Integer lowKey = tree.floorKey(val), highKey = tree.higherKey(val);
//         if (lowKey != null && highKey != null && tree.get(lowKey)[1] == val - 1 && tree.get(highKey)[0] == val + 1) {
//             // merge with both low and high
//             tree.get(lowKey)[1] = tree.get(highKey)[1];
//             tree.remove(highKey);
//         } else if (lowKey != null && tree.get(lowKey)[1] >= val - 1) {
//             // merge with lower one
//             tree.get(lowKey)[1] = Math.max(tree.get(lowKey)[1], val);
//         } else if (highKey != null && tree.get(highKey)[0] == val + 1) {
//             // merge with higher one
//             tree.put(val, new int[] { val, tree.get(highKey)[1] });
//             tree.remove(highKey);
//         } else {
//             // add new interval
//             tree.put(val, new int[] { val, val });
//         }
//     }

//     public int[][] getIntervals() {
//         return tree.values().toArray(new int[tree.size()][]);
//     }

//     private TreeMap<Integer, int[]> tree;
// }

class SummaryRanges {
    /** Initialize your data structure here. */
    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        Integer floor = tree.floorKey(val);
        if (floor == null || tree.get(floor)[1] + 1 < val) {
            // cannot merge with lower one, try merge with higher one or add new interval
            int[] interval = tree.remove(val + 1);
            tree.put(val, new int[] { val, interval == null ? val : interval[1] });
        } else {
            // try to merge with lower one
            if (val <= tree.get(floor)[1]) {
                // included in current interval
                return;
            }
            // merge with lowerone as well as try to merge with higher one(if needed)
            int[] interval = tree.remove(val + 1);
            tree.get(floor)[1] = interval == null ? val : interval[1];
        }
    }

    public int[][] getIntervals() {
        return tree.values().toArray(new int[tree.size()][]);
    }

    private TreeMap<Integer, int[]> tree;
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges(); obj.addNum(val); int[][] param_2 =
 * obj.getIntervals();
 */
