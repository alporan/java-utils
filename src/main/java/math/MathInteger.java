package math;

public class MathInteger {
	
	/**
	 * Returns {@code true} if {@code x} represents a power of two.
	 */
	public static boolean isPowerOfTwo(int x) {
		return x > 0 & (x & (x - 1)) == 0;
	}
	
}
