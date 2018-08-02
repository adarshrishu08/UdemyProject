package com.udemy.java8.practises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Java8Practise {
	

	public static void main(String[] args) {
		String[] names = {"Yashu","Adarsh","Ayush","Ayendreyee","Rishu","Sinha","Ria","Sudhir","Ankur"};
		int[] numbers = {5,3,8,10,4,9,1,11,2,7,6};
		sortName(names);
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=20; i++){
			list.add(i);
		}
		
		Consumer<Integer> consumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer arg0) {
				
			}
		};
		list.forEach(consumer);
		list.forEach(System.out::println);
		list.forEach(i->System.out.println(i));
		sumStream(numbers);
//		list.stream().map
		sumOfGreaterThan(15, list);
	}
	
	public static void sortName(String[] names){
		Arrays.sort(names, new Comparator<String>() {
			@Override
			public int compare(String name1, String name2) {
				return name1.compareTo(name2);
			}
		});
		Arrays.sort(names, (n1,n2)->n1.compareTo(n2));
		NameComparator nameCompare = new NameComparator();
		Arrays.sort(names, nameCompare::compare);
//		Arrays.sort(names, );
		printElements(names);
	}
	
	public static void printElements(String[] names){
		List<String> stringList = Arrays.asList(names);
		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		stringList.forEach(System.out::println);
	}
	
	public static int sumOfGreaterThan(int i, List<Integer> list){
		int sum = 0;
		
		return sum;
	}
	
	/*To Test Stream API Features*/
	public static void sumStream(int[] intArr){
		List<Integer> list = Arrays.stream(intArr).boxed().collect(Collectors.toList());
		int sum = list.stream().filter(t->t>5).mapToInt(v->v).sum();
		System.out.println("Sum of greater than 5 :"+sum);
	}
	/*To Test Stream API Features*/

}

class NameComparator implements Comparator<String>{

	@Override
	public int compare(String name1, String name2) {
		// TODO Auto-generated method stub
		return name1.compareTo(name2);
	}
	
	
}
