package ksh.hacker;

import java.time.LocalDate;

public class DateAndTime {
	public static void main(String[] args) {
		LocalDate ld = LocalDate.of(2020, 3, 22);
		String str = ld.getDayOfWeek().toString();
		System.out.println(ld.getDayOfWeek());
	}
}
