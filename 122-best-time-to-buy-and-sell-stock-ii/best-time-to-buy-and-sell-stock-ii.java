class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        //from second day
        for (int i = 1;i<prices.length;i++){
            // if today's price is higher than yesterday's "buy" yesterday and "sell" today
            if (prices[i] > prices[i-1]){
                totalProfit += (prices[i] - prices[i - 1]);
            }
        }

        return totalProfit;
    }
}