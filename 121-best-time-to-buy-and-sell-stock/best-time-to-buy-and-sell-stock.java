class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int num:prices)
        {
            min=Math.min(min,num);
            maxprofit=Math.max(maxprofit,num-min);
        }
        return maxprofit;
    }
}