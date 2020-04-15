package ksh.hacker;

import java.io.IOException;

/**
 *	Given a time in -hour AM/PM format, convert it to military (24-hour) time.

Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.

Function Description

Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.

timeConversion has the following parameter(s):

s: a string representing time in  hour format
Input Format

A single string  containing a time in -hour clock format (i.e.:  or ), where  and .

Constraints

All input times are valid
Output Format

Convert and print the given time in -hour format, where .

Sample Input 0

07:05:45PM
Sample Output 0

19:05:45
Contest ends in 10 days
 */
public class TimeConversion {
	static String timeConversion(String s) {
		String h = s.substring(0, 2);
		String m = s.substring(3, 5);
		String ss = s.substring(6, 8);
		String tr = s.substring(8,10);		
		if("PM".equals(tr)) {
			h = "12".equals(h) ? h : String.valueOf(Integer.parseInt(h)+12); 
		}else {
			h = "12".equals(h) ? "00": h;
		}
		return h+":"+m+":"+ss;
	}
//	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//		String s = scan.nextLine();
		// String s = "07:05:45PM";
		String s = "12:00:00PM";
		String result = timeConversion(s);

		System.out.println(result);
		// bw.write(result);
		// bw.newLine();

		// bw.close();
	}
}
