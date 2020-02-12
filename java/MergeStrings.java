
/**
 * MergeStrings
 */
import java.util.*;

public class MergeStrings {

    private static String mergeStrings(String s1, String s2) {
        if (s1 == null || s1.length() == 0)
            return s2;
        if (s2 == null || s2.length() == 0)
            return s1;
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            res.append(s1.charAt(i)).append(s2.charAt(i));
            i++;
        }
        if (i < s1.length())
            res.append(s1.substring(i));
        else if (i < s2.length())
            res.append(s2.substring(i));
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeStrings("geeks", "forgeeks").equals("gfeoerkgseeks"));
        System.out.println(mergeStrings("hello", "geeks").equals("hgeelelkos"));
        System.out.println(mergeStrings("hello", "").equals("hello"));
        System.out.println(mergeStrings("", "hello").equals("hello"));
    }
}