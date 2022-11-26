package com.konwar.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//	In this tutorial, we will show you few Java 8 examples to demonstrate the 
//   use of Streams filter(), collect(), findAny() and orElse()

public class StreamsFilterExamples {
	public static void main(String[] args) {

		// BeforeJava8
		List<String> lines = Arrays.asList("spring", "node", "Binoy");
		List<String> result = getFilterOutput(lines, "Binoy");
		for (String temp : result) {
			System.out.println(temp); // output : spring, node
		}

		// NowJava8
		List<String> alines = Arrays.asList("spring", "node", "Binoy");

		List<String> aResult = alines.stream().filter(line -> !"Binoy".equals(line)).collect(Collectors.toList());
		aResult.forEach(System.out::println);
		
		
		
		//BeforeJava8
		List<Person> persons= Arrays.asList(
				new Person("Binoy", 35),
				new Person("Mahesh",32),
				new Person("Jow", 40));
		
		Person result2 = getStudentBYName(persons, "Jow");
		System.out.println(result2);
		
		
		//NowJava8
		List<Person> persons2= Arrays.asList(
				new Person("Binoy", 35),
				new Person("Mahesh",32),
				new Person("Jow", 20));

		Person result3 = persons2.stream()									// Convert to steam
				.filter(x -> "Mahesh".equals(x.getName()))					// we want "Mahesh" only
				.findAny()													// If 'findAny' then return found
				.orElse(null);												// If not found, return null
		
		System.out.println(result3);
		
		Person result4 = persons.stream()
                .filter(x -> "ahmook".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println(result4);
        
        
        //For multiple condition.
        
        Person result5 = persons2.stream()
                .filter((p) -> "Jow".equals(p.getName()) && 20 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println("result 5 :" + result5);

        
      //or like this
        Person result6 = persons.stream()
                .filter(p -> {
                    if ("jack".equals(p.getName()) && 20 == p.getAge()) {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);

        System.out.println("result 6 :" + result6);
        
        
        
        //Streams filter() and map()
        System.out.print("||||||||||");
        
        List<Person> persons3 = Arrays.asList(
                new Person("Binoy", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );
         String name = persons3.stream()
        		 .filter(x -> "jack".equals(x.getName()))
        		 .map(Person :: getName)
        		 .findAny()
        		 .orElse("");
         
         System.out.println("name : " + name);
         
         
         List<String> collect = persons3.stream()
        		 .map(Person :: getName)
        		 .collect(Collectors.toList());
         
         collect.forEach(System.out::println);
		
	}

	private static Person getStudentBYName(List<Person> persons, String name) {
		Person result = null;
		for(Person temp: persons) {
			if(name.equals(temp.getName())) {
				result = temp;
			}
		}
		return result;
	}

	private static List<String> getFilterOutput(List<String> lines, String name) {
		List<String> result = new ArrayList<>();
		for (String line : lines) {
			if (!"Binoy".equals(line)) {
				result.add(line);
			}
		}
		return result;
	}

}

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	

}
