package com.arrayHashing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		char[] charArray = s.toCharArray();
		List<List<Character>> list=new ArrayList();
		List<Character> l=new ArrayList<Character>();
		
		for(char ch:charArray)
		{
			System.out.println(ch);
			if(!l.contains(ch))
			{
              
				l.add(ch);
			}else
			{
				list.add(new ArrayList(l));
				l.clear();
				l.add(ch);
			}
		}
		list.add(new ArrayList(l));
		l.clear();
		System.out.println(list);
List<List<Character>> collect = list.stream().map(li->li.stream().sorted().collect(Collectors.toList()))
.distinct().collect(Collectors.toList());


 System.out.println(collect);
 Long long1 = collect.stream().map(li->li.stream().count()).max(Comparator.naturalOrder()).orElse(0l);
 
		
		return long1.intValue();

	}

	public static void main(String[] args) {

		String s = "";
		LongestSubstringWithoutRepeatingCharacters lsrc=new LongestSubstringWithoutRepeatingCharacters();
		int lengthOfLongestSubstring = lsrc.lengthOfLongestSubstring(s);
		System.out.println(lengthOfLongestSubstring);

	}

}
