package com.konwar.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamsExamples {
	public static void main(String[] args) {
		System.out.println("Normal...");
		IntStream range = IntStream.rangeClosed(1, 10);
		range.forEach(System.out::println);

		System.out.println("Parallel...");
		IntStream range2 = IntStream.rangeClosed(1, 10);
		range2.parallel().forEach(System.out::println);

		System.out.println("Normal...");
		List<String> alpha = getData();
		alpha.stream().forEach(System.out::println);

		System.out.println("Parallel...");
		List<String> alpha2 = getData();
		alpha2.parallelStream().forEach(System.out::println);

		// We can test it with isParallel()
		System.out.println("Normal...");
		IntStream range3 = IntStream.rangeClosed(1, 10);
		System.out.println(range3.isParallel()); // false
		range3.forEach(System.out::println);

		System.out.println("Parallel...");

		IntStream range4 = IntStream.rangeClosed(1, 10);
		IntStream range4Parallel = range4.parallel();
		System.out.println(range4Parallel.isParallel()); // true
		range4Parallel.forEach(System.out::println);

		// print the current thread name like this:
		System.out.println("Normal...");
		IntStream range5 = IntStream.rangeClosed(1, 10);
		range5.forEach(x -> {
			System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
		});

		System.out.println("Parallel...");

		IntStream range6 = IntStream.rangeClosed(1, 10);
		range6.parallel().forEach(x -> {
			System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
		});

		
		//Java 8 streams to print all prime numbers up to 1 million:
		long count = Stream.iterate(0, n -> n+1)
				.limit(1_000_000)
				//.parallel()   with this 23s, without this 1m 10s
				.filter(ParallelStreamsExamples:: isPrime)
				.peek(x -> System.out.format("%s\t",x))
				.count();
		
		System.out.println("\nTotal: " + count);

		
		
		
		
		
	}

	private static List<String> getData() {
		List<String> alpha = new ArrayList<>();
		int n = 97;
		while (n <= 122) {
			char c = (char) n;
			alpha.add(String.valueOf(c));
			n++;
		}
		return alpha;
	}
	
	public static boolean isPrime(int number) {
		if(number <=1) return false;
		return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
	}
}
