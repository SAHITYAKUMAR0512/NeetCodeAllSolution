package com.arrayHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		 List<List<Integer>> list=new ArrayList<List<Integer>>();
		 for(int i=0;i<nums.length;i++)
		 {
			 for(int j=i+1;j<nums.length;j++)
			 {
				 for(int k=j+1;k<nums.length;k++)
				 {
						 if(nums[i]+nums[j]+nums[k]==0)
						 {
							 list.add(List.of(nums[i],nums[j],nums[k]));
						 }
				 }
			 }
		 }
		
	return list.stream().distinct().toList();
	}
	
	 public List<List<Integer>> threeSum2(int[] nums) {
		 
		 List<List<Integer>> list=new ArrayList<List<Integer>>();
		 List<Integer> temp=new ArrayList<Integer>();
		 permute(nums, list,0,temp,0);
        List<List<Integer>> collect = list.stream().map(li->li.stream().map(Integer :: valueOf).sorted().collect(Collectors.toList()))
        .distinct().collect(Collectors.toList());
		 return collect;
	    }
	 public void permute(int[] nums,List<List<Integer>> list,int start,List<Integer> temp,int tempnum)
	 {
		// System.out.println("--------method start----------"+"tempnum :"+tempnum +"  start :"+start);
		 if(tempnum==0 && temp.size()==3)
		 {
			 list.add(new ArrayList(temp));
			 return ;
		 }
		 for(int i=start;i<nums.length;i++)
		 {
			 int j = nums[i];
			 temp.add(j);
			 tempnum+=j;
			// System.out.println("temp added :"+temp +"  tempnums :"+tempnum);
			 permute(nums, list,i+1, temp, tempnum);
			// System.out.println("before removing :"+temp +"  tempnums :"+tempnum);
			 temp.remove(temp.size()-1);
			 tempnum-=j;
			//System.out.println("removed :"+temp +"  tempnums :"+tempnum);
		 }
	 }

	public static void main(String[] args) {
		int nums[] = {-1,0,1,2,-1,-4};
		ThreeSum ts=new ThreeSum();
		List<List<Integer>> threeSum = ts.threeSum(nums);
		System.out.println(threeSum);

	}

}
