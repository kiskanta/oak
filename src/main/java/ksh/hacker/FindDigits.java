package ksh.hacker;

import java.io.IOException;
import java.util.Scanner;

public class FindDigits {
	// Complete the findDigits function below.
	static int findDigits(int n) {
		int temp = n, count =0;
	      while(temp !=0){
	        int d = temp % 10;
	        temp /= 10;
	        
	        if(d>0 && n%d ==0){
	          count++;
	        }
	      }
	      return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int result = findDigits(n);
			System.out.println(result);
		}

		scanner.close();
	}
}
