import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int len = 0, i = 0, j;
        while (i < words.length) {
            len = 0;
            j = i;
            while (j < words.length && len + words[j].length() + j - i <= maxWidth) {
                // determine words can be fitted in current line
                // j-i: min number of space(s)
                len += words[j].length();
                j++;
            }
            StringBuilder line = new StringBuilder();
            if (j - i == 1 || j == words.length) {
                // if last line or only one word, left align
                for (int k = i; k < j; k++) {
                    line.append(words[k] + " ");
                }
                line.deleteCharAt(line.length() - 1);
                while (line.length() < maxWidth)
                    line.append(" ");
            } else {
                // middle align padding
                int avgSpace = (maxWidth - len) / (j - i - 1);
                int extra = (maxWidth - len) % (j - i - 1);
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        int cnt = 0;
                        while (cnt++ < avgSpace)
                            line.append(" ");
                        if (extra-- > 0)
                            line.append(" ");
                    }
                }
            }
            res.add(line.toString());
            i = j;
        }
        return res;
    }
}
