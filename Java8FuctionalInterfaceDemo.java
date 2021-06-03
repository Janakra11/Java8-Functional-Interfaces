package com.pack.core.java.jdk8.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import sun.security.util.Length;
//Consumer functional interfaces 2 method 1)accept(T t) and andThen()
class ConsumerClass implements Consumer<List<Integer>>
{
	public void accept(List<Integer> list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			list.set(i, list.get(i)* 2);
		}
	}
	
}
//Supplier functional interface one method T get()
class SupplierClass implements Supplier<Double> {

	public Double get() {
		// TODO Auto-generated method stub
		return Math.random();
	}
	
}

public class Java8FuctionalInterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);
        
        System.out.println("Before applying Consumer List is \n"+ list);

		 // Consumer to multiply 2 to every integer of a list
        ConsumerClass consumerClass = new ConsumerClass();
        consumerClass.accept(list);
        
        System.out.println("After applying Consumer List is \n"+ list);
        
        //Supplier functional use 
        SupplierClass supplierClass = new SupplierClass();
        // Print the random value using get()
        System.out.println("Using Supplier interface to get random no : \n" +supplierClass.get());
        
        //Predicate Function interface method boolean test(T t)
        List<String> names = Arrays.asList("Janakraj", "Amar", "Sachin", "Amit", "Raju", "James", "Jason");
        System.out.println("Before Applying predicat fuctional interface names list is\n"+names);        
        Predicate<String> namesStartWith = x =>x.startsWith("J");
        System.out.println("after Applying predicat fuctional interface names list is\n"); 
        names.stream().filter(namesStartWith).forEach(System.out::println);
        
        //function functional interface one method R apply(T t)
        List<String> names2 = Arrays.asList("Janakraj", "Amar", "Sachin", "Amit", "Raju", "James", "Jason");
        
        Function<String, Integer> nameMappingFucntion = String::Length;
        List<Integer> nameLength = names2.stream().filter(nameMappingFucntion).collect(Collector.toList());
        
        System.out.println("Print name with is string length as \n" + nameLength);
	}

}
