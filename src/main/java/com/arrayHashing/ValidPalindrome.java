package com.arrayHashing;

public class ValidPalindrome {
	
	 public boolean isPalindrome(String s) {
		 String words="";
		
		 
		 char[] charArray = s.toCharArray();
		 for(char c:charArray)
		 {
			 if(Character.isLetterOrDigit(c))
			 {
				 words+=Character.toString(c);
			 }
		 }
		 System.out.println(words);
		 StringBuffer sb=new StringBuffer(words);
		String string = sb.reverse().toString();
		
	    return words.equalsIgnoreCase(string);    
	    }

	public static void main(String[] args) {
		String s = "Was it a car or a cat I saw?";
		ValidPalindrome vp=new ValidPalindrome();
		boolean palindrome = vp.isPalindrome(s);
		System.out.println(palindrome);
		
	}

}
