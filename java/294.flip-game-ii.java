// [294] Flip Game II
class Solution {
    public boolean canWin(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                if (!canWin(s.substring(0, i) + "--" + s.substring(i + 1)))
                    return true;
            }
        }
        return false;
    }
}