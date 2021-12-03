package math;

import java.util.*;
import java.util.stream.Collectors;

public class MathUtils {

	private MathUtils() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Returns {@code true} if {@code n} represents a prime number.
	 */
	public static boolean isPrime(long n) {
		if (n < 2)
			return false;

		if (n == 2 || n == 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		long sqrtN = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= sqrtN; i += 6) {
			if (n % (i - 1) == 0 || n % (i + 1) == 0)
				return false;
		}
		return true;
	}

	/**
	 * Returns {@code true} if {@code n} represents a power of two.
	 */
	public static boolean isPowerOfTwo(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}

	/**
	 * @param values array of integers
	 * @return median of given {@code values}
	 */
	public static double median(int[] values) {
		List<Integer> valueList = Arrays.stream(values).boxed().collect(Collectors.toList());
		return median(valueList);
	}

	/**
	 * @param values collection of integers
	 * @return median of given {@code values}
	 */
	public static double median(Collection<Integer> values) {
		List<Integer> integers = new ArrayList<>(values);
		Collections.sort(integers);
		int listSize = integers.size();
		return listSize % 2 == 0
				? (integers.get(listSize / 2) + integers.get(listSize / 2 - 1)) / 2.0
				: integers.get(listSize / 2);
	}

	/**
	 * @param value signed integer
	 * @return median of given {@code value}
	 */
	public static long reverse(int value) {
		boolean isNegative = false;
		long result = 0;

		if (value < 0) {
			isNegative = true;
			value *= -1;
		}
		while (value > 0) {
			result = result * 10 + value % 10;
			value = value / 10;
		}

		if (isNegative)
			result *= -1;

		return result;
	}
}