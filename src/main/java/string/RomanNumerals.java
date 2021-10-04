package string;

import java.util.regex.Pattern;

public class RomanNumerals {

	private RomanNumerals() {
		throw new IllegalStateException("Utility class");
	}

	private static final Pattern ROMAN = Pattern.compile(
			"^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

	/**
	 * Returns {@code true} if {@code s} represents a roman numeral.
	 */
	public static boolean isRomanNumeral(String s) {
		return ROMAN.matcher(s).matches();
	}
}
