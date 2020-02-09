package ksh.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
	public static void main(String[] args) {
		// sortBy name
		List<Employee> firstNameSort = getEmployees();
		firstNameSort.sort(Comparator.comparing(e -> e.getFirstName()));
		firstNameSort.sort(Comparator.comparing(e -> e.getFirstName()));

		List<Employee> firstNameSortReverse = getEmployees();
		Comparator<Employee> compartorFirstName = Comparator.comparing(e -> e.getFirstName());
		firstNameSortReverse.sort(compartorFirstName.reversed());

		
		var addThenList = getEmployees();
		Comparator<Employee> empThenCompare = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
		addThenList.sort(empThenCompare);
		
		System.out.println(firstNameSort);
		System.out.println(firstNameSortReverse);
		System.out.println(addThenList);
	}

	private static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(6, "Yash", "Chopra", 25));
		employees.add(new Employee(2, "Aman", "Sharma", 28));
		employees.add(new Employee(3, "Aakash", "Yaadav", 52));
		employees.add(new Employee(5, "David", "Kameron", 19));
		employees.add(new Employee(4, "James", "Hedge", 72));
		employees.add(new Employee(8, "Balaji", "Subbu", 88));
		employees.add(new Employee(7, "Karan", "Johar", 59));
		employees.add(new Employee(1, "Lokesh", "Gupta", 32));
		employees.add(new Employee(9, "Vishu", "Bissi", 33));
		employees.add(new Employee(10, "Lokesh", "Ramachandran", 60));
		return employees;
	}
}

class Employee {
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Employee(Integer id, String firstName, String lastName, Integer age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

}

class Book {
	private String author;
	private String name;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book(String author, String name) {
		super();
		this.author = author;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", name=" + name + "]";
	}

}

class Item {
	private String name;
	private int price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "]";
	}

}