package com.arrayHashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		boolean status=true;
		Set<Character> set =new HashSet<Character>();
		for(char[] a:board)
		{
			for(char b:a)
			{
				//System.out.println(b);
				if(b!='.')
				{
				if(!set.add(b))
				{
					return false;
				}else {
				set.add(b);
				}
				}
			}
			set.clear();
		}
		
		set.clear();
		System.out.println("all row clear");
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				    char c= board[j][i];
				    if(c!='.')
				    {
				    if(!set.add(c))
				    {
				    	return false;
				    }else {
				    	set.add(c);
				    }
				    }
			}
			set.clear();
		}
	
		set.clear();
		System.out.println("all Column clear");
		int length = board.length;
		System.out.println(length);
		for(int i=0;i<board.length;i+=3)
		{
			for(int j=0;j<board.length;j+=3)
			{
	           for(int k=i;k<i+3;k++)
	           {
	        	   for(int l=j;l<j+3;l++)
	        	   {
	        		     char c = board[k][l];
	        		     System.out.println(c);
	        		     if(c!='.')
	        		     {
	        		    	if(!set.add(c))
	        		    	{
	        		    		return false;
	        		    	}else {
	        		    		set.add(c);
	        		    	}
	        		     }
	        	   }
	           }
	          // System.out.println(set);
	           set.clear();
			}
		}
      return status;
	}

	public static void main(String[] args) {
		char[][] board = 
			       {{'1','2','.','.','3','.','.','.','.'},
					{'4','.','.','5','.','.','.','.','.'},
					{'.','9','8','.','.','.','.','.','3'},
					{'5','.','.','.','6','.','.','.','4'},
					{'.','.','.','8','.','3','.','.','5'},
					{'7','.','.','.','2','.','.','.','6'},
					{'.','.','.','.','.','.','2','.','.'},
					{'.','.','.','4','1','9','.','.','8'},
					{'.','.','.','.','8','.','.','7','9'}};
		ValidSudoku vs=new ValidSudoku();
		boolean validSudoku = vs.isValidSudoku(board);
		System.out.println(validSudoku);

	}

}
