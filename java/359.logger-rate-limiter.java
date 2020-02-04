import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=359 lang=java
 *
 * [359] Logger Rate Limiter
 */

// @lc code=start
class Logger {

    private int timer;
    private Map<String, Integer> logs;

    /** Initialize your data structure here. */
    public Logger() {
        this.timer = 0;
        this.logs = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false. If this method returns false, the message will not
     * be printed. The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        timer = Math.max(timer, timestamp);
        if (logs.get(message) == null || logs.get(message) <= timer - 10) {
            // should print. update timestamp
            logs.put(message, timestamp);
            return true;
        }
        return false;
    }
}

class Logger {

    private Map<String, Integer> logs;

    /** Initialize your data structure here. */
    public Logger() {
        this.logs = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false. If this method returns false, the message will not
     * be printed. The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < logs.getOrDefault(message, 0))
            return false;
        logs.put(message, timestamp + 10); // put expire time of the msg
        return true;
    }
}
/**
 * Your Logger object will be instantiated and called as such: Logger obj = new
 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
// @lc code=end
