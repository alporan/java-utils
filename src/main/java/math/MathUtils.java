package math;

public abstract class MathUtils {

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
}