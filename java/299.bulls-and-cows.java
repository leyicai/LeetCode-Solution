/*
 * @lc app=leetcode id=299 lang=java
 *
 * [299] Bulls and Cows
 */
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] digits = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                bulls++;
            } else {
                if (digits[s] < 0)
                    // s has already appeared in guess
                    cows++;
                if (digits[g] > 0)
                    // g has already appeared in secret
                    cows++;
                digits[s]++;
                digits[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}

// with two arrays
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] secretArr = new int[10];
        int[] guessArr = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secretArr[secret.charAt(i) - '0']++;
                guessArr[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretArr[i], guessArr[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
