package com.konwar.Streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsMapExamples {
	public static void main(String[] args) {

		
		List<String> alpha = Arrays.asList("a","b","c","d");
		//Before Java8
		System.out.println("<--Before Java 8-->");
		List<String>  alphaUpper = new ArrayList<>();
		for (String s : alpha)
		{
			alphaUpper.add(s.toUpperCase());
		}
		System.out.println(alpha); 
        System.out.println(alphaUpper);
        System.out.println("<--after Java 8-->");
        // Java 8
        List<String> collect = alpha.stream().map(String :: toUpperCase).collect(Collectors.toList());
        System.out.println(collect); 
        
        // Extra, streams apply to any data type.
        System.out.println("<--Extra, streams apply to any data type Java 8-->");
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream().map(n->n *2).collect(Collectors.toList());
        System.out.println(collect1);
        
        
        List<Staff> staff = Arrays.asList(
        		new Staff("Binoy",30, new BigDecimal(1000000)),
        		new Staff("Jack",27, new BigDecimal(200000)),
        		new Staff("law",33, new BigDecimal(300000)));
        
      //Before Java 8
        System.out.println("<--Before Java 8-->");
        List<String> result = new ArrayList<>();
        for (Staff x : staff) {
            result.add(x.getName());
        }
        System.out.println(result); 
        
        System.out.println("<--after Java 8-->");
      //Java 8
        List<String> collect2 = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(collect2); 
        
        
      //Before Java 8
        System.out.println("<--Before Java 8-->");
        List<Staff> staff2 = Arrays.asList(
                new Staff("konwar", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        List<StaffPublic> result2 = convertToStaffPublic(staff);
        System.out.println(result2);
        
        
        
        
        
        System.out.println("<--after Java 8-->");
        // convert inside the map() method directly.
        List<StaffPublic> result3 = staff2.stream().map(
        		temp -> {
        			StaffPublic obj = new StaffPublic();
        			obj.setName(temp.getName());
        			obj.setAge(temp.getAge());
        			if("konwar".equals(temp.getName())) {
        				obj.setExtra("This field is for Binoy only");
        			}
        			return obj;
        		}).collect(Collectors.toList());
        
        System.out.println(result3);
        
        
        
	}

	private static List<StaffPublic> convertToStaffPublic(List<Staff> staff) {
		List<StaffPublic> result = new ArrayList<>();
		for(Staff temp : staff) {
			StaffPublic obj = new StaffPublic();
			obj.setName(temp.getName());
			obj.setAge(temp.getAge());
			if("konwar".equals(temp.getName())) {
				obj.setExtra("This field is for Binoy only");
			}
			result.add(obj);
			
		}
		return result;
	}
}

class Staff {
	private String name;
	private int age;
	private BigDecimal salary;

	public Staff() {

	}

	public Staff(String name, int age, BigDecimal salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}

class StaffPublic {

    private String name;
    private int age;
    private String extra;
    public StaffPublic() {
    	
    }
    
	public StaffPublic(String name, int age, String extra) {
		super();
		this.name = name;
		this.age = age;
		this.extra = extra;
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
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "StaffPublic [name=" + name + ", age=" + age + ", extra=" + extra + "]";
	}
    
    
    
}