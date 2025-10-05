package com.arrayHashing;

import java.util.Arrays;

public class TwoIntegerSumII {
	
	 public int[] twoSum(int[] numbers, int target) {
		 
		 for(int i=0;i<numbers.length;i++)
		 {
			 for(int j=i;j<numbers.length;j++)
			 {
				 if(numbers[i]!=numbers[j])
				 {
					if( numbers[i]+numbers[j]==target && numbers[i]<numbers[j])
					{
						return new int[]{numbers[i],numbers[j]};
					}
				 }
			 }
		 }
		 
		 return new int[0];
	        
	    }

	public static void main(String[] args) {
		int numbers[] = {1,2,3,4}, target = 3;
		
		TwoIntegerSumII tis=new TwoIntegerSumII();
		int[] twoSum = tis.twoSum(numbers, target);
		System.out.println(Arrays.toString(twoSum));
		
		
            
	}

}
