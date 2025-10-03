package com.arrayHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Encode_and_Decode_Strings {
	
	 public String encode(List<String> strs) {
		 if(strs.size()==0)
		 {
			 return "";
		 }
		 String collect = strs.stream().collect(Collectors.joining("0p"));
		 System.out.println("collect " +collect);
		 return new StringBuffer(collect+"abc").reverse().toString();

	    }

	    public List<String> decode(String str) {
	    	if(str.isBlank())
	    	{
	    		List<String> l=new ArrayList();
		    	return l;
	    	}
	    if( str.equalsIgnoreCase("cba"))
	    {
	    	List<String> l=new ArrayList();
	    	l.add(new String(""));
	    	return l;
	    }
         StringBuffer sb=new StringBuffer(str.substring(3));
         String[] split = sb.reverse().toString().split("0p");
              List<String> collect = Arrays.stream(split).collect(Collectors.toList());
              return collect;
	    }

	public static void main(String[] args) {
		 String[] str={"bavneet","kaur"};
		 System.out.println(Arrays.toString(str));
		 List<String> collect = Arrays.stream(str).collect(Collectors.toList());
		 String encode = new Encode_and_Decode_Strings().encode(collect);
		 System.out.println(encode);
		 List<String> decode = new Encode_and_Decode_Strings().decode(encode);
		 System.out.println(decode);

	}


}
