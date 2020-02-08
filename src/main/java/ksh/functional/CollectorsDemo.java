package ksh.functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {
	
	public static void main(String[] args) {
		List<Student> stuList = stuList().stream()
			.sorted(Comparator.comparingDouble(Student::getPercentage).reversed())
			.limit(3)
			.collect(Collectors.toList());
		
		System.out.println(stuList);
		
		Set<String> subjSet = stuList().stream().map(Student::getSubject).collect(Collectors.toSet());
		System.out.println(subjSet);
		
		var map = stuList().stream().collect(Collectors.toMap(Student::getId, Student::getName));
		System.out.println(map);
		
		var colleaction = stuList().stream().limit(3).collect(Collectors.toCollection(LinkedList::new));
		System.out.println(colleaction);
		
		var join = stuList().stream().map(Student::getName).collect(Collectors.joining(", "));
		System.out.println(join);
		
		var length= stuList().stream().count();
		System.out.println(length);
		
		var longSize = stuList().stream().collect(Collectors.counting());
		System.out.println("Counting : "+longSize);
		
		// maxBy
		Optional<Double> highPercentage = stuList().stream().map(Student::getPercentage).collect(Collectors.maxBy(Comparator.naturalOrder()));
		System.out.println(highPercentage);
		
		Optional<Double> minPercentage = stuList().stream().map(Student::getPercentage).collect(Collectors.minBy(Comparator.naturalOrder()));
		System.out.println(minPercentage);
		
		//summingInt(), summingLong() summingDouble()
		var doubleSum = stuList().stream().collect(Collectors.summingDouble(Student::getPercentage));
		System.out.println(doubleSum);
		
		var avaragePercentage = stuList().stream().collect(Collectors.averagingDouble(Student::getPercentage));
		System.out.println(avaragePercentage);
		
		var summarizingDouble= stuList().stream().collect(Collectors.summarizingDouble(Student::getPercentage));
		System.out.println("Summarizing Average"+summarizingDouble.getAverage());
		System.out.println("Summarizing Count"+summarizingDouble.getCount());
		System.out.println("Summarizing Max"+summarizingDouble.getMax());
		System.out.println("Summarizing Min"+summarizingDouble.getMin());
		
		var stuIdColelactorGroupMap = stuList().stream().collect(Collectors.groupingBy(Student::getId));
		System.out.println("Student Grouping "+stuIdColelactorGroupMap);
		
		Map<Boolean, List<Student>> stuPercentagePartitioning= stuList().stream().collect(Collectors.partitioningBy(student -> student.getPercentage()> 80.0));
		System.out.println("Partitioning - "+stuPercentagePartitioning);
		
		List<Student> first3Students = stuList().stream().limit(3)
			.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		System.out.println("ColleactingAndThen - "+first3Students);
		
		//var umodifiable = stuList().stream().collect(Collectors.toUnmodifiableMap(Student::getId, s -> s));
		var umodifiable = stuList().stream().collect(Collectors.toUnmodifiableMap(Student::getId, Function.identity()));
		System.out.println(umodifiable);
	}
	
	public static List<Student> stuList(){
		var studentList = new ArrayList<Student>();
        
		studentList.add(new Student("Paul", 11, "Economics", 78.9));
		studentList.add(new Student("Zevin", 12, "Computer Science", 91.2));
		studentList.add(new Student("Harish", 13, "History", 83.7));
		studentList.add(new Student("Xiano", 14, "Literature", 71.5));
		studentList.add(new Student("Soumya", 15, "Economics", 77.5));
		studentList.add(new Student("Asif", 16, "Mathematics", 89.4));
		studentList.add(new Student("Nihira", 17, "Computer Science", 84.6));
		studentList.add(new Student("Mitshu", 18, "History", 73.5));
		studentList.add(new Student("Vijay", 19, "Mathematics", 92.8));
		studentList.add(new Student("Harry", 20, "History", 71.9));
		return studentList;
	}
}

class Student {
	String name;
	int id;
	String subject;
	double percentage;

	public Student(String name, int id, String subject, double percentage) {
		super();
		this.name = name;
		this.id = id;
		this.subject = subject;
		this.percentage = percentage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", subject=" + subject + ", percentage=" + percentage + "]";
	}

}
