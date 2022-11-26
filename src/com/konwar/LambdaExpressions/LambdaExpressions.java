package com.konwar.LambdaExpressions;

import java.util.Arrays;
import java.util.List;

public class LambdaExpressions {
	public static void main(String[] args) {

		//we can use a lambda expression to shorten the code like this: 
		List<String> list = Arrays.asList("node", "java","python", "ruby");
		list.forEach(str -> System.out.println(str));
		
		
		System.out.print("||||||||||");
		System.out.println("--------");
		
		//To gain better readability, we can replace lambda expression with method reference.
		list.forEach(System.out:: println);
	}
}