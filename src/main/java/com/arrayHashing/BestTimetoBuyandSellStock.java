package com.arrayHashing;

public class BestTimetoBuyandSellStock {

	public int maxProfit(int[] prices) {

		int maxprofit=0;
		for(int i=0;i<prices.length;i++)
		{
			for(int j=i+1;j<prices.length;j++)
			{
                  int differ=prices[j]-prices[i];
                  maxprofit=(int)Math.max(maxprofit, differ);
			} 
		}
         return maxprofit;
	}

	public static void main(String[] args) {
		int prices[] = {10,1,5,6,7,1};
		BestTimetoBuyandSellStock btbss=new BestTimetoBuyandSellStock();
		int maxProfit = btbss.maxProfit(prices);
		System.out.println(maxProfit);

	}

}
