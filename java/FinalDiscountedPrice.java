class Result {

    /*
     * Complete the 'finalPrice' function below.
     *
     * The function accepts INTEGER_ARRAY prices as parameter.
     */

    public static void finalPrice(List<Integer> prices) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        long sum = 0;
        for (int i = 0; i < prices.size(); i++) {
            while (!s.isEmpty() && prices.get(s.peek()) >= prices.get(i)) {
                sum += prices.get(s.pop()) - prices.get(i);
            }
            s.push(i);
        }
        while (!s.empty()) {
            int idx = s.pop();
            sum += prices.get(idx);
            res.add(0, idx);
        }

        System.out.println(sum);
        System.out.println(res.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }

}