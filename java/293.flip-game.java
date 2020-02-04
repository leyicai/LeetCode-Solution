import java.util.List;
import java.util.ArrayList;

// [293] Flip Game
class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                res.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
            }
        }
        return res;
    }
}

// indexOf
class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        int start = 0, i = 0;
        while (start < s.length() && s.indexOf("++", start) != -1) {
            i = s.indexOf("++", start);
            res.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
            start = i + 2;
        }
        return res;
    }
}
