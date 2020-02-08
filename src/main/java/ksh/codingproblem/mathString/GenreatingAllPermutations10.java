package ksh.codingproblem.mathString;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenreatingAllPermutations10 {

	public void permitAndPrint(String prefix, String str){
		int n = str.length();
		
		if(n==0) {
			System.out.print(prefix+" ");
		}else {
			for(int i=0; i< n; i++) {
				//System.out.println(i+" "+str);
				permitAndPrint(prefix+str.charAt(i), str.substring(i+1, n)+str.substring(0, i));
			}
		}
	}
	
	public Set<String> permitAndStore(String prefix, String str){
		var permutation = new HashSet<String>();
		
		int n =str.length();
		if (n== 0) {
			permutation.add(prefix);
		}else {
			for(int i=0; i< n; i++) {
				permutation.addAll(permitAndStore(prefix+str.charAt(i), str.substring(i+1, n)+ str.substring(0, i)));
			}
		}
		return permutation;
	}

	public void permitAndStream(String prefix, String str){
		int n = str.length();
		if(n ==0) {
			System.out.print(prefix+" ");
		}else {
			IntStream.range(0, n)
				.parallel()
				.forEach( 
					i -> permitAndStream(
							prefix+str.charAt(i), 
							str.substring(i+1, n)+ str.substring(0, i))
				);
		}
	}
	
	public Stream<String> permuteAndReturnStream(String str){
		
		if(str == null || str.isBlank()) {
			return  Stream.of("");
		}	
		return IntStream.range(0, str.length())
                .parallel()
                .boxed()
                .flatMap(i -> permuteAndReturnStream(str.substring(0, i) + str.substring(i + 1))
                	.map(c -> str.charAt(i) + c)
                );
	}
	
	public static void main(String[] args) {
		GenreatingAllPermutations10 genratePermutation = new GenreatingAllPermutations10();
		
	}
	
	
}
