package com.arrayHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsofArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {

		List<Integer> list=new ArrayList();
		int multiple=1;
		for(int i=0;i<nums.length;i++)
		{
			multiple=1;
			for(int j=0;j<nums.length;j++)
			{
                 if(i==j)
                 {
                	 continue;
                 }else {
                	 multiple*=nums[j];
                 }
			}
			list.add(multiple);
		}
		
		System.out.println(list);
         int[] array = list.stream().mapToInt(Integer:: intValue).toArray();
         
		return array;     
	}

	public static void main(String[] args) {

		int 	nums[] = {1,2,4,6};
		ProductsofArrayExceptSelf pae=new ProductsofArrayExceptSelf();
		int[] productExceptSelf = pae.productExceptSelf(nums);
		System.out.println(Arrays.toString(productExceptSelf));

	}

}
