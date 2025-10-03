package com.arrayHashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
		int nums[] = {1, 2, 3};
		boolean status=true;
		Set<Integer> set=new HashSet<>();
		       for(int a:nums)
		       {
		    	   if(!set.add(a))
		    	   {
		    		  status=false; 
		    	   }else {
		    		   set.add(a);
		    	   }
		       }
		   System.out.println(status);

	}

}
