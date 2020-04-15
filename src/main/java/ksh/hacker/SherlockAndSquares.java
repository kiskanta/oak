package ksh.hacker;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author KingShore
 *
 */
public class SherlockAndSquares {
	// Complete the squares function below.
	static int squares(int a, int b) {
		int frSr = (int)Math.sqrt(a);
		int count =0;
		while(frSr* frSr <= b) {
			if(frSr* frSr >= a) {
				count++;
			}
			frSr++;
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] ab = scanner.nextLine().split(" ");

			int a = Integer.parseInt(ab[0]);

			int b = Integer.parseInt(ab[1]);

			int result = squares(a, b);
			System.out.println(" - "+result);

		}

		scanner.close();
	}
}
