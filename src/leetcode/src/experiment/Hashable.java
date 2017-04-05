package experiment;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Hashable {
	
	public static void main(String[] args) {
		Map<Hashable, String> map = new HashMap<>();
		map.put(new Hashable(1), "1");
		map.put(new Hashable(2), "2");
		System.out.println(map.containsKey(new Hashable(3)));
		map.put(new Hashable(3), "3");
		System.out.println(map.get(new Hashable(5)));
		/*
		BigDecimal d1 = new BigDecimal("0.00000000000000000000000000000001");
		BigDecimal d2 = new BigDecimal("2.0");
		BigDecimal d3 = new BigDecimal("1.00");
		BigDecimal d4 = new BigDecimal("0.00");
		System.out.println(d1.hashCode());
		System.out.println(d2.hashCode());
		System.out.println(d3.hashCode());
		System.out.println(d4.hashCode());
		System.out.println(d1.equals(d4));
		System.out.println(d1.stripTrailingZeros().equals(d4.stripTrailingZeros()));
		System.out.println(d1.stripTrailingZeros());
		System.out.println(d4.stripTrailingZeros());
		*/
	}
	
	public int val;
	
	public Hashable(int val) {
		this.val = val;
	}
	
	@Override
	public int hashCode() {
		return val % 2;
	}
	
	@Override
	public boolean equals(Object o) {
		return true;
	}
}
