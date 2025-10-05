package com.arrayHashing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumber {
	
	public static boolean isPrime(int n)
	{
		if(n<=1) return false;
		
		for(int i=2;i<Math.sqrt(n);i++)
		{
			if(n%i==0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
             
		List<Integer> collect = IntStream.range(0, 50).filter(PrimeNumber :: isPrime).mapToObj(Integer :: valueOf).collect(Collectors.toList());
		System.out.println(collect);
	}

}
