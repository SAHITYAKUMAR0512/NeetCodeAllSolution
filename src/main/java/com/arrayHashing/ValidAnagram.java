package com.arrayHashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ValidAnagram {

	public static void main(String[] args) {
		String s = "racecar", t = "carrace";
		char[] charArray = s.toCharArray();
		char[] charArray2 = t.toCharArray();
		List<char[]> asList = Arrays.asList(charArray);
		List<char[]> asList2 = Arrays.asList(charArray2);
        
		    String collect = asList.stream().flatMap(li->new String(li).chars().mapToObj(c->Character.toString(c))).sorted()
		    		.collect(Collectors.joining());
		    System.out.println(collect);
		
		
		
		
		
		
		
		
		     
		Arrays.sort(charArray);
		Arrays.sort(charArray2);
		System.out.println(Arrays.toString(charArray));
		System.out.println(Arrays.toString(charArray2));
		String word1=new String(charArray);
		String word2=new String(charArray2);
		
		System.out.println(word1);
		System.out.println(word2);
		


	}

}
