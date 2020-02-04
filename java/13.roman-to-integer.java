import java.util.HashMap;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */
class Solution {
    public int romanToInt(String s) {
        int[] map = new int[26];
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
        char prev = 'A';
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (map[c - 'A'] > map[prev - 'A']) {
                sum = sum - 2 * map[prev - 'A'];
            }
            sum += map[c - 'A'];
            prev = c;
        }
        return sum;
    }
}
