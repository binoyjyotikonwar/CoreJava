package com.konwar.Streams;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
//Java 8 flatMap example
public class FlatMapExample {
	public static void main(String[] args) throws IOException {
//		String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

		  // array to a stream
//		  Stream<String[]> stream1 = Arrays.stream(array);
//
//		  // same result
//		  Stream<String[]> stream2 = Stream.of(array);
//		  
//		  System.out.println(stream1);
//		  System.out.println(stream2);
//		  
//		  List<String[]> result = stream1
//				  .filter( x -> !x.equals("a"))
//				  .collect(Collectors.toList());
		  
		  String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

		  // convert array to a stream
		  Stream<String[]> stream1 = Arrays.stream(array); 
		  List<String[]> result = stream1
			      .filter(x -> !x.equals("a"))      // x is a String[], not String!
			      .collect(Collectors.toList());
		  
		  System.out.println(result.size());  
		  System.out.println(result);  
		  result.forEach(System.out::println);
		
		  
		  
		  Stream<String[]> stream2 = Arrays.stream(array); 
		  List<String[]> result2 = stream2
				  .filter(x->{
					  for(String s : x) {
						  if(s.equals("a")) {
							  return false;
						  }
					  }
					  return true;
				  }).collect(Collectors.toList());
		  
		  result2.forEach(x -> System.out.println(Arrays.toString(x)));
				
		  //convert a 2d array into a 1d array, 
		  
		  String[][] array2 = new String[][] {{"a","b"},{"c","d"},{"e","f"}};
		  String[] result3 = Stream.of(array2)
				  .flatMap(Stream::of)
				  .toArray(String[]::new);
		  
		  System.out.println("convert a 2d array into a 1d array"); 
		  for(String s : result3) {
			  System.out.println(s);
		  }
		  
		  
		  //Now, we can easily filter out the a; let see the final version.
		  List<String> clollect = Stream.of(array2)
				  .flatMap(Stream::of)
				  .filter(x -> !"a".equals(x))
				  .collect(Collectors.toList());
		  System.out.println("Now, we can easily filter out the a; let see the final version.");  
		  clollect.forEach(System.out::println);
		  
		  
		  Developer o1 = new Developer();
		  o1.setName("Binoy");
		  o1.addBook("Java 8 in action");
		  o1.addBook("Spring boot in Action");
		  o1.addBook("Effective Java (3rd Edition)");
		  
		  
		  Developer o2 = new Developer();
		  o2.setName("Konwar");
		  o2.addBook("Java 8 in action");
		  o2.addBook("aws in Action");
		  o2.addBook("Effective Java (3rd Edition)");
		  
		  List<Developer> list = new ArrayList<>();
		  list.add(o1);
		  list.add(o2);
		  
		  list.forEach(System.out::println);
		  

		  Set<String> collect4 =
	                list.stream()
	                        .map(x -> x.getBook())                              //  Stream<Set<String>>
	                        .flatMap(x -> x.stream())                           //  Stream<String>
	                        .filter(x -> !x.toLowerCase().contains("aws"))   //  filter awsss book
	                        .collect(Collectors.toSet()); 
		  
		  Set<String> collect5 = 
				  list.stream()
				  .flatMap(x-> x.getBook().stream())
				  .filter(x -> !x.toLowerCase().contains("aws"))
				  .collect(Collectors.toSet());
		  
		  
		  
		  collect4.forEach(System.out::println);
		  
		  collect5.forEach(System.out::println);
		  
		  
		  //The orders is a stream of purchase orders, and each purchase order contains a collection of line items, then we can use flatMap to produce a Stream or Stream<LineItem> containing all the line items in all the orders. Furthermore, we also add a reduce operation to sum the line items’ total amount.
		  
		  List<Order> orders = findAll();
		  
		  BigDecimal sumOfLineItems = orders.stream()
				  .flatMap(order -> order.getLineItems().stream())
				  .map(line -> line.getTotal())
				  .reduce(BigDecimal.ZERO,BigDecimal::add);  //  reduce to sum all
		  
		  
		  
		  BigDecimal sumOfOrder= orders.stream()
				  .map(order -> order.getTotal())
				  .reduce(BigDecimal.ZERO, BigDecimal::add);
		  
		  
		  
		  System.out.println(sumOfLineItems);                         // 3194.20
	      System.out.println(sumOfOrder); 
	      
	      if(!sumOfOrder.equals(sumOfLineItems)) {
	    	  System.out.println("The sumOfOrder is not equals to sumOfLineItems!");
	      }
	      
	      
	     // Path path = Paths.get("C:\\test\\test.txt");
	      Path path = Paths.get("/Users/apple/Documents/WORK/java/test.txt");
	      
//	      //Path path = Paths.get(File.separator + "Users" + File.separator + "apple" + File.separator + "Documents" +File.separator+ "WORK"+ File.separator +"java" + File.separator + "test.txt");
	      
	      
	      Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
	      System.out.println(lines);
	      
	      // result a stream of words, good!
	        Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));
	     // count the number of words.
	        
	        
//	        words.forEach(System.out::println);
	        
	        long noOfWords = words.count();

	        System.out.println(noOfWords);  
	        System.out.println(words);  
	        
	        
	        int[]  array6 = {1,2,3,4,5,6};
	        Stream<int[]> streamArray = Stream.of(array6);
	        
	        IntStream intStream = streamArray
	        		.flatMapToInt(x -> Arrays.stream(x));
	        		
	        intStream.forEach(x-> System.out.println(x));
	        
	        long[] array7 = {1, 2, 3, 4, 5, 9};

	        Stream<long[]> longArray = Stream.of(array7);

	        LongStream longStream = longArray.flatMapToLong(x -> Arrays.stream(x));

	        System.out.println(longStream.count());
	        
	      
	}
	
	private static List<Order> findAll(){
		LineItem item1 = new LineItem(1, "apple", 1, new BigDecimal("1.20"), new BigDecimal("1.20"));
        LineItem item2 = new LineItem(2, "orange", 2, new BigDecimal(".50"), new BigDecimal("1.00"));
        Order order1 = new Order(1, "A0000001", Arrays.asList(item1, item2), new BigDecimal("2.20"));

        LineItem item3 = new LineItem(3, "monitor BenQ", 5, new BigDecimal("99.00"), new BigDecimal("495.00"));
        LineItem item4 = new LineItem(4, "monitor LG", 10, new BigDecimal("120.00"), new BigDecimal("1200.00"));
        Order order2 = new Order(2, "A0000002", Arrays.asList(item3, item4), new BigDecimal("1695.00"));

        LineItem item5 = new LineItem(5, "One Plus 8T", 3, new BigDecimal("499.00"), new BigDecimal("1497.00"));
        Order order3 = new Order(3, "A0000003", Arrays.asList(item5), new BigDecimal("1497.00"));

	    return Arrays.asList(order1, order2, order3);
	
	
	}
	
	
}
