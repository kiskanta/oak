package ksh.functional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ComparatorMap {
	public static void main(String[] args) {
		var map = new HashMap<String, String>();
		map.put("C", "c");
		map.put("B", "b");
		map.put("Z", "z");
		
		List<Map.Entry<String, String>> sortedBy = map.entrySet().stream()
			.sorted(Map.Entry.comparingByKey())
			.collect(Collectors.toList());
		
		sortedBy.forEach(System.out::println);
	}
}
