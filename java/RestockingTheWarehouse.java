class Result {

    /*
     * Complete the 'restock' function below.
     *
     * The function is expected to return an INTEGER. The function accepts following
     * parameters: 1. INTEGER_ARRAY itemCount 2. INTEGER target
     */

    public static int restock(List<Integer> itemCount, int target) {
        // Write your code here
        int purchased = 0;
        for (Integer i : itemCount) {
            purchased += i;
            if (purchased >= target)
                break;
        }
        return Math.abs(target - purchased);
    }

}