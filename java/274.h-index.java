/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */
class Solution {
    /*
     * Sort in descending order If index > #reference at the index, #reference is
     * result
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = citations.length;
        for (int i = 0; i < citations.length; i++, h--) {
            if (h <= citations[i])
                return h;
        }
        return h;
    }
}

class Solution {
    /*
     * Counting sort An array of size n, count the number of papers that are cited i
     * times. if citations > n; put at [n] Count from the end of the array, stop
     * wheen count > n faster ****
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] arr = new int[n + 1];
        for (int c : citations) {
            if (c < n) {
                arr[c]++;
            } else {
                arr[n]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += arr[i];
            if (count >= i)
                return i;
        }
        return 0;
    }
}
