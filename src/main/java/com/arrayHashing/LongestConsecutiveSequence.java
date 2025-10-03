package com.arrayHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
	
	 public int longestConsecutive(int[] nums) {
		 Arrays.sort(nums);
		        List<Integer> collect = Arrays.stream(nums).boxed().distinct().collect(Collectors.toList());
		        System.out.println(collect);
		        List<Integer> list=new ArrayList();
		        List<List<Integer>> finalList=new ArrayList<List<Integer>>();
		        if(collect.size()<1)
		        {
		        	return 0;
		        }
		        list.add(collect.get(0));
		        for(int i=1;i<collect.size();i++)
		        {
		        	if(collect.get(i)-collect.get(i-1)==1)
		        	{
		        		list.add(collect.get(i));
		        	}else {
		        		
		        		finalList.add(new ArrayList(list));
		        		list.clear();
		        		list.add(collect.get(i));
		        	}
		        }
        		finalList.add(new ArrayList(list));
        		list.clear();
		        System.out.println(finalList);
		        Long long1 = finalList.stream().map(li->li.stream().count()).max(Comparator.naturalOrder()).get();
		        int intValue = long1.intValue();
		        return  intValue;
	    }

	public static void main(String[] args) {
	   int 	nums[] = {2,20,4,10,3,4,5};
		LongestConsecutiveSequence lcs=new LongestConsecutiveSequence();
		
		int longestConsecutive = lcs.longestConsecutive(nums);
		System.out.println(longestConsecutive);

	}

}
