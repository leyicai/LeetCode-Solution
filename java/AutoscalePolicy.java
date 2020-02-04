class Result {

    /*
     * Complete the 'finalInstances' function below.
     *
     * The function is expected to return an INTEGER. The function accepts following
     * parameters: 1. INTEGER instances 2. INTEGER_ARRAY averageUtil
     */

    public static int finalInstances(int instances, List<Integer> averageUtil) {
        // Write your code here
        double MAX = Math.pow(10, 8);
        for (int i = 0; i < averageUtil.size(); i++) {
            if (averageUtil.get(i) > 60 && instances < MAX) {
                instances *= 2;
                i += 10;
            } else if (averageUtil.get(i) < 25 && instances > 1) {
                instances = (instances + 1) / 2;
                i += 10;
            }
        }
        return instances;

    }

}