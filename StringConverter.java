// Nate Gould 9/20/2023 CS 1061 Homework 5
public class StringConverter {
	public static int convert(String ns) {
		if (!ns.matches("[-0-9]*")) {
			throw new NumberFormatException();
		}
		if (ns.charAt(0) == '-') {
			return converterHelper(ns.substring(1, ns.length()), 1, 0) * -1;
		}
		
		return converterHelper(ns, 1, 0);
	}
	
	private static int converterHelper(String ns, int depth, int sum) {
		sum += (ns.charAt(ns.length()-1) - '0') * depth;
		if (ns.length() == 1)
			return sum;
		else {
			return converterHelper(ns.substring(0, ns.length()-1), depth*10, sum);
		}
	}
}