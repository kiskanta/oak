package ksh.fund;

public class String11Changes {

	public void stripWays(String s){
		
		System.out.printf("'%s'%n", s);
		
		String strip = s.strip();
		System.out.printf("strip():%n '%s'%n", strip);
		
		String stripLeading = s.stripLeading();
		System.out.printf("stripLeading():%n '%s'%n", stripLeading);
		
		String stripTrailing = s.stripTrailing();
		System.out.printf("stripTrailing():%n '%s'%n", stripTrailing);
		
		String stripTrim = s.trim();
		System.out.printf("trim():%n '%s'%n", stripTrim);
	}
	
	public String reapt(String str, int reapt) {
		if(reapt<0) {
			System.out.println("Can't repat");
			throw new IllegalArgumentException("Please Check the reapt value and try.");
		}
		return str.repeat(reapt);
	}
	
	public void blank(String str){
		boolean empty = str.isEmpty();
		System.out.println("Empty value is "+empty);
		
		boolean blank = str.isBlank();
		System.out.println("blank value is "+blank);
	}
	
	public void lines(String str){
		str.lines().forEach(System.out::println);
	}
	public static void main(String[] args) {
		String11Changes str11 = new String11Changes();
		String s ="	test String	";
		String strUnicode = " test String\u205F";
		String strTrim = " test String\u0009";
		
		str11.stripWays(s);
		
		System.out.println("-----------");
		str11.stripWays(strUnicode);
		
		System.out.println("########");
		str11.stripWays(strTrim);
		
		System.out.println(str11.reapt("-", 7));
		System.out.println(str11.reapt("-", 0));
		
		str11.lines("jujube\nsatsuma\nguava");
		
		str11.blank("    ");
	}
}
