package com.udemy.java8.practises;

import java.util.ArrayList;
import java.util.List;

public class Java8Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1, "Adarsh", "Patna"));
		persons.add(new Person(2, "Adarsh", "Mumbai"));
		persons.add(new Person(3, "Ria", "Kolkata"));
		persons.add(new Person(4, "Yashu", "Patna"));
		persons.add(new Person(5, "Ankur", "Madhubani"));
		persons.add(new Person(6, "Ankur", "Delhi"));
		
		findByNameAndCity(persons, "Adarsh", "Patna");
	}

	public static Person findByNameAndCity(List<Person> personList, String name, String city) {
		Person person = personList.stream().filter(t->{
			System.out.println(t);
			return t.getName().equalsIgnoreCase(name)&&t.getCity().equalsIgnoreCase(city);
		}).findAny().orElse(null);
		System.out.println(person.getId() + " " + person.getName());
		return person;
	}
}

class Person {
	private int id;
	private String name;
	private String city;

	public Person() {
		
	}

	public Person(int id, String name, String city) {
		this.id = id;
		this.name = name; 
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
	

}