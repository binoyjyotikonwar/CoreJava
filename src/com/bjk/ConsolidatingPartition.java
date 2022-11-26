package com.bjk;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConsolidatingPartition {
	public static void main(String[] args) {
//        List used = new ArrayList<>();
        List<Integer> used = new ArrayList<>();
        used.add(3);
        used.add(2);
        used.add(1);
        used.add(3);
        used.add(1);
//        used.add(5);
//        used.add(1);
        
//        used.add(2);
//        used.add(2);
//        used.add(3);
     

//        List total = new ArrayList<>();
        List<Integer> total = new ArrayList<>();
        total.add(3);
        total.add(5);
        total.add(3);
        total.add(5);
        total.add(5);
        
//        total.add(3);
//        total.add(3);
//        total.add(3);

        int minPartition = 0;

        List sortedTotal = total.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        

        int totalNumber = 0;
        for (int i : used) {
            totalNumber += i;
        }

        int counterTotal = 0;
        int currTotal;
        while (totalNumber > 0) {
            currTotal = (int) sortedTotal.get(counterTotal);
            totalNumber = totalNumber - currTotal;

            if (totalNumber > 0) { //e.q +5 when 10-5 , used = 10, total = 5
                minPartition++;
                counterTotal++;
                continue;
            }

            //e.q if used = 5, total = 5
            //e.q if used = 1, total = 5 (last item)
            minPartition++;
        }

        System.out.println(minPartition);
    }
}
