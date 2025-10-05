package com.arrayHashing;

public class ContainerWithMostWater {
	
	 public int maxArea(int[] heights) {
		 int max=0;
		   int length = heights.length;
		 for(int i=0;i<length;i++)
		 {
			   for(int j=i+1;j<length;j++)
			   {
				  int a= heights[i];
				   int b=heights[j];
				   int min = Math.min(a, b);
				     max=  Math.max(max, min*(j-i));
			   }
		 }
	        return max;
	    }

	public static void main(String[] args) {
	int  height[] = {1,7,2,5,4,7,3,6};
	ContainerWithMostWater cwm=new ContainerWithMostWater();
	int maxArea = cwm.maxArea(height);
	System.out.println(maxArea);

	}

}
