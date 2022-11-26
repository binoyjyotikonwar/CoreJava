package com.bjk;

import java.util.ArrayList;
import java.util.List;

public class Program3 {
	public static void main(String[] args) {
		List<Integer> used = new ArrayList<>();

		List<Integer> totalCapacity = new ArrayList<>();

		used.add(1);
		used.add(2);
		used.add(3);

		totalCapacity.add(3);
		totalCapacity.add(3);
		totalCapacity.add(3);
		
		
		
//		used.add(2);
//		used.add(2);
//		used.add(3);
//
//		totalCapacity.add(3);
//		totalCapacity.add(3);
//		totalCapacity.add(3);

		System.out.println(minPartitions(used, totalCapacity));

	}

	public static int minPartitions(List<Integer> used, List<Integer> totalCapacity) {
		// Write your code here
		int sizeOfUsedPartion = used.size();
		int sizeOfMemoryUsed = totalCapacity.size();
		List<Integer> newMemory = new ArrayList<>();
		while (sizeOfMemoryUsed != 0) {
			for (int i = 0; i < sizeOfUsedPartion; i++) {
				for (int j = 0; j < i; j++) {
					if ((used.get(i) + used.get(j)) <= totalCapacity.get(i)) {
						newMemory.add((used.get(i) + used.get(j)));
//						sizeOfMemoryUsed --;
						break;
					}
				}

			}
		}
		return newMemory.size();
	}
}
