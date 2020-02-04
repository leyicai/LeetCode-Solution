/**
 * MaxHeight
 */
public class MaxHeight {

    public int maxHeight(int[] positions, int[] heights) {
        int max = 0;
        for (int i = 1; i < heights.length; i++) {
            int temp = calculateMax(positions[i - 1], positions[i], heights[i - 1], heights[i]);
            if (temp > max)
                max = temp;
        }
        return max;
    }

    private int calculateMax(int pos1, int pos2, int h1, int h2) {
        if (pos2 - pos1 == 1)
            return 0;
        if (pos2 - pos1 == 2)
            return Math.min(h1, h2) + 1;
        if (h1 == h2)
            return h1 + (pos2 - pos1) / 2;
        int diff = Math.abs(h2 - h1);
        if (diff >= pos2 - pos1) {
            // two table is close. max height is bounded by the lower table
            return Math.min(h1, h2) + (pos2 - pos1);
        } else {
            // two table is far. max height is determined by the higher table
            if (h1 > h2) {
                return calculateMax(pos1, pos2 - diff, h1, h1);
            } else {
                return calculateMax(pos1 + diff, pos2, h2, h2);
            }
        }
    }

    public static void main(String[] args) {
        MaxHeight mh = new MaxHeight();
        System.out.println(mh.maxHeight(new int[] { 1, 10 }, new int[] { 1, 5 }));
        System.out.println(mh.maxHeight(new int[] { 1, 3, 7 }, new int[] { 4, 3, 3 }));
        // System.out.println(mh.maxHeight(new int[] { 1, 2, 4, 7 }, new int[] { 4, 5,
        // 7, 11 }));
    }
}