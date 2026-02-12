class Solution {
    public int maxProfit(int[] prices) {
        //Initialize buy states to negative infinity because we want to maximize
        //A negative number (minimize the cost)
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0 ;

        for (int price : prices){
            //Maximize balance after first buy (cheapest price)
            buy1 = Math.max(buy1,-price);
            //Maximize balance after after seconf buy
            sell1 = Math.max(sell1 , buy1 + price);
            //Max balannce after second buy (reinvesting first profit)
            buy2 = Math.max(buy2,sell1-price);
            //Maximize balance after second sell
            sell2 = Math.max(sell2,buy2 + price);
        }
        return sell2 ;
        
    }
}