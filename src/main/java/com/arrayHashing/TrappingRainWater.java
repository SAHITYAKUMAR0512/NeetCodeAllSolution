package com.arrayHashing;

import java.util.Arrays;

public class TrappingRainWater {
	
	 public int trap(int[] height) {
		 int length = height.length;
		 if(length==0) return 0;
		 int trapwater=0;
		 int min[]=new int[length];
		 int max[]=new int[length];
		 min[0]=height[0];
		 for(int i=1;i<length;i++)
		 {
			 min[i]=(int)Math.max(min[i-1], height[i]);
		 }
		 System.out.println(Arrays.toString(min));
		 max[length-1]=height[length-1];
		 for(int i=length-2;i>=0;i--)
		 {
			 max[i]=(int)Math.max(max[i+1], height[i]);
		 }
		 
		 System.out.println(Arrays.toString(max));
		 for(int i=0;i<length;i++)
		 {
			 
			 trapwater+=(int)Math.min(min[i], max[i])-height[i];
			 System.out.println(min[i]+ "    "+max[i]+ " "+height[i]);
			 System.out.println(trapwater);
			
		 }
		 
	       
		return  trapwater;
	    }

	public static void main(String[] args) {
		int  height[] = {4,2,0,3,2,5};
		TrappingRainWater trw=new TrappingRainWater();
		int trap = trw.trap(height);
		System.out.println("");
		System.out.println(trap);
	}

}
