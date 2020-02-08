package ksh.fund;

import java.util.logging.Logger;

public class String12Changes {

	/**
	 * indenting - adjusts the indentation of each line of this string. 
	 * @param str 
	 * @param chars N>0, inserts n number of space characters.
	 * @return indented value
	 */
	public String indentingString(String str, int chars){
		if(str == null || str.isBlank() || chars<0) {
			throw new IllegalArgumentException("Please Check the indenting try."); 
			//return null;
		}
		System.out.println("String Before Indenting lenght is "+str.length());
		String indentStr = str.indent(chars);
		System.out.println("String after Indenting lenght is "+indentStr.length());
		return indentStr;
	}
	
	public static void main(String[] args) {
		String12Changes str12Change = new String12Changes();
		
		String indentSpace =str12Change.indentingString("A test String", 5);
		System.out.println(indentSpace);
	}
}
