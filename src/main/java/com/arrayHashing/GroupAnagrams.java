package com.arrayHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupAnagrams {
	 public List<List<String>> groupAnagrams(String[] strs) {
		 List<String> collect = Arrays.stream(strs).collect(Collectors.toList());
		 Map<String,List<String>> collect2 = collect.stream().collect(Collectors.groupingBy(s->{
			char[] ch= s.toCharArray();
			Arrays.sort(ch);
			return new String(ch);
		 }));
		 System.out.println(collect2);
		 Map<String, List<String>> collect3 = collect.stream().collect(Collectors.groupingBy(s->s.chars().mapToObj(String :: valueOf)
				 .sorted().collect(Collectors.joining())));
		 return null;
	 }
	
	
	 public List<List<String>> groupAnagrams2(String[] strs) {
		  List<List<String>> list=new ArrayList<List<String>>();
		  List<String> collect = Arrays.stream(strs).collect(Collectors.toList());
		  System.out.println(collect);
		  Map<String,List<String>> map=new HashMap<>();
          for(String word:collect)
          {
        	  char[] charArray = word.toCharArray();
        	  Arrays.sort(charArray);
        	  String w=new String(charArray);
        	  if(!map.containsKey(w))
        		  map.put(w, new ArrayList<>());
        	  
        	  map.get(w).add(word);
          }
          System.out.println(map);
          List<List<String>> collect2 = map.values().stream().collect(Collectors.toList());
          
             
     
      
		 return collect2;
	    }
	 
	

	 public boolean validAnagrams(String word,String word2)
	 {
		 char[] charArray = word.toCharArray();
		 Arrays.sort(charArray);
		 char[] charArray2 = word2.toCharArray();
		 Arrays.sort(charArray2);
		 return Arrays.equals(charArray, charArray2);
	 }
	public static void main(String[] args) {
		String strs[]= {"act","pots","tops","cat","stop","hat"};
		GroupAnagrams ga=new GroupAnagrams();
		List<List<String>> groupAnagrams = ga.groupAnagrams(strs);
		System.out.println(groupAnagrams);
		String sk="sahitya";
		IntStream chars = sk.chars();
		chars.forEach(s->System.out.println(s));
		System.out.println(chars);

	}

}
