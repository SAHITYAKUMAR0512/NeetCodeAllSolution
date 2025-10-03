package com.arrayHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		
		int first,second;
		first=second=0;
		for(int i=0;i<nums.length;i++)
		{
			for(int j=i+1;j<nums.length;j++)
			{
				if(nums[i]+nums[j]==target)
				{
					first=i;
					second=j;
				}
			}
		}
		int r[]= {first,second};
		return r;
	}
	
	 public int[] twoSumpApprochBacktracking(int[] nums, int target) {
		 System.out.println(Arrays.toString(nums));
		 Arrays.sort(nums);
		 List<List<Integer>> list=new ArrayList<List<Integer>>();
		 List<Integer> temp=new ArrayList<Integer>();
		 int sum=0;
		 
		 permute(nums, 0, list, target, temp, sum);
		 System.out.println(list);
		 int k=0;
		 for(int a:nums)
		 {
			 if(list.get(0).contains(a))
			 {
				 temp.add(k);
			 }
			 k++;
		 }
		System.out.println(temp);
	        
		 return null;
	    }
	 
	 public void permute(int[] nums,int start,List<List<Integer>> list,int target,List<Integer> temp,int sum)
	 {
		 if(sum==target)
		 {
			 list.add(new ArrayList(temp));
			 return;
		 }
		 for(int i=start;i<nums.length;i++)
		 {
			     int num = nums[i];
			     sum+=num;
			     temp.add(num);
			     permute(nums,i+1, list, target, temp,sum);
			     temp.remove(temp.size()-1);
			     sum -= num;
			     
		 }
		
		 
	 }
	
	public static void main(String[] args) {
		int nums[] = {3,4,5,6}, target = 8;
		TwoSum t=new TwoSum();
		int[] twoSum = t.twoSum(nums, target);
		System.out.println(Arrays.toString(twoSum));
	}

}
