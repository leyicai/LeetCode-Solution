import java.util.HashMap;
import java.util.Map;

class AuthenticationTokens {
    public static int numberOfTokens(int expiryLimit, int[][] commands) {
        Map<Integer, Integer> tokens = new HashMap<>(); // k:tokenID, v:expiryTime
        int currTime = 0;
        for (int[] command : commands) {
            currTime = command[2];
            removeDeadToken(tokens, currTime);
            if (command[0] == 0) {
                // GET
                tokens.put(command[1], command[2] + expiryLimit);
            } else {
                // RESET
                if (tokens.get(command[1]) != null) {
                    tokens.put(command[1], command[2] + expiryLimit);
                }
            }
        }
        removeDeadToken(tokens, currTime);
        return tokens.keySet().size();
    }

    private static void removeDeadToken(Map<Integer, Integer> tokens, int currTime) {
        for (Map.Entry<Integer, Integer> entry : tokens.entrySet()) {
            if (entry.getValue() < currTime)
                tokens.remove(entry.getKey());
        }
    }

    public static void main(String[] args) {
        int expiryLimit = 4;
        int[][] commands = new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 1, 5 }, { 1, 2, 6 } };
        System.out.println(numberOfTokens(expiryLimit, commands));
    }
}
