package ksh.hacker;

import java.io.IOException;
import java.util.Scanner;

public class CatsandAmouse {
    /**
     * 
     * @param x cat A position
     * @param y cat B position
     * @param z A Mouse C position
     * @return 
     */
    static String catAndMouse(int x, int y, int z) {
    	 int disA= Math.abs(x-z);
    	 int disB= Math.abs(y-z);
    	 
    	 if (disA < disB) {
    		return "Cat A";
		}else if(disA > disB){
			return "Cat B";
		}else {
			return "Mouse C";
		}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);
            System.out.println(result);
        }
        scanner.close();
    }
}
