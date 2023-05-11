package com.example.RestApiRJM.test;

public class DemoSingleton {

	
	public static void main(String[] args) {
		Singleton sing= Singleton.getInstance("Food");
		Singleton sing2= Singleton.getInstance("Bar");
		
		System.out.println(sing.value);
		System.out.println(sing2.value);
	}
	
}
