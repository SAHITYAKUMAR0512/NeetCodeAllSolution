package com.arrayHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopKFrequentElements {
	 public int[] topKFrequent(int[] nums, int k) {
		 Map<Integer,Integer> map=new HashMap<>();
		 for(int a:nums)
		 map.put(a, map.getOrDefault(a,0)+1);
		 List<Integer> l=new ArrayList<Integer>();
		   int[] array = map.values().stream().sorted(Comparator.reverseOrder()).limit(k).mapToInt(Integer :: intValue).toArray();
		   System.out.println(Arrays.toString(array));
		   for(int a:array)
		   {
			   for(Map.Entry<Integer,Integer> m:map.entrySet())
			   {
				if(m.getValue()==a && !l.contains(m.getKey()))
					l.add(m.getKey());
			   }
		   }
		   
          int[] array2 = l.stream().mapToInt(Integer :: valueOf).toArray();
		 System.out.println(map);
		 
		 return array2;
         
     }

	public static void main(String[] args) {
       
		int  nums[] = {1,2}, k = 2;
		TopKFrequentElements top=new TopKFrequentElements();
		int[] topKFrequent = top.topKFrequent(nums, k);
		System.out.println(Arrays.toString(topKFrequent));
	}

}
