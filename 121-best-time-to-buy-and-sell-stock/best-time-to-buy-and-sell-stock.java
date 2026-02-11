class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            if (price < minPrice){
                //new best day
                minPrice = price;
            }else if (price - minPrice > maxProfit){
                //if sold today , would it be a new record
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}