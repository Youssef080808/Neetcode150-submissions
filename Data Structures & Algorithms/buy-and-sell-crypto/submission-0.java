class Solution {
    public int maxProfit(int[] prices) {
        int max = prices[prices.length-1];
        int profit = 0;
        for (int i = prices.length-2; i >= 0; i--){
            if (prices[i] >= max){
                max = prices[i];
            } else {
                if (max - prices[i] > profit){
                    profit = max - prices[i];
                }
            }
        }
        return profit;
    }
}
//[7,1,5,3,6,4] max = 6, pro = 0, i = 3;