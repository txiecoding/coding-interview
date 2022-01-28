package com.github.txie84.coding_interview;

/**
 * bit-wise operator: 6&4, 1|2, 8>>1, -16>>>2, 1<<10, ~0, 15^x
 * Integer.MIN_VALUE, Float.MAX_VALUE, Double.SIZE, Boolean.TRUE
 * Double.valueOf("1.23"), Boolean.valueOf(true), Integer.parseInt("42"), Float.toString(-1.23)
 * Character.getNumericValue(x) or x - '0'
 * Double.compare(x, 1.23) == 0 is better than x == 1.23
 * Math.abs(-34.5), Math.ceil(2.17), Math.floor(3.14), Math.min(x, -4), Math.max(3.14, y), pow(2.71, 3.14), sqrt(225)
 * box-types vs primitive types: primitive types is faster and take less space, box-types are object 
 * auto-boxing: Integer x = 1;
 * limits of auto-boxing: worse performance, unexpected behavior like OutOfMemoryError, NullPointerException
 * Random.nextInt(16), Random.nextInt(), Random.nextBoolean(), Random.nextDouble()
 */

public class PrimitiveTypes {
    public static short countBits(int x) {
        short numBits = 0;
        while (x != 0) {
            numBits += (x & 1);
            x >>>= 1;
        }
        return numBits;
    }

    /**
     * 5.1 Compute the parity of a word
     * compute parity of a number, parity = 1 if number of 1 is odd, else 0 
     * brute-force, O(n)
     */
    public static short parity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }

    /**
     * 5.1 Compute the parity of a word
     * parity for very large 64-bit number
     * array lookup + bit mask
     * O(length of x / WORD_SIZE)
     */
    public static short parityLarge(long x) {
        final int[] precomputedParity = new int[]{0, 1, 1, 0}; // should contain 2^WORD_SIZE elements
        final int WORD_SIZE = 16;
        final int BIT_MASK = 0xFFFF;
        return (short) (
            precomputedParity[(int)((x >>> (3 * WORD_SIZE)) & BIT_MASK)]
            ^ precomputedParity[(int)((x >>> (2 * WORD_SIZE)) & BIT_MASK)]
            ^ precomputedParity[(int)((x >>> (1 * WORD_SIZE)) & BIT_MASK)]
            ^ precomputedParity[(int)((x >>> (0 * WORD_SIZE)) & BIT_MASK)]
        );
    }

    /**
     * 5.7 Compute x^y
     * O(n)
     */
    public static double power(double x, int y) {
        double result = 1.0;
        long power = y;
        if (y < 0) {
            power = -power;
            x = 1.0 / x;
        }
        while (power != 0) {
            if ((power & 1) != 0) {
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }
        return result;
    }

    /**
     * 5.8 Reverse digits
     * result = result * 10 + xRemaining % 10;
     * O(n)
     */
    public static long reverse(int x) {
        boolean isNegative = x < 0;
        long result = 0;
        long xRemaining = Math.abs(x);
        while (xRemaining != 0) {
            result = result * 10 + xRemaining % 10;
            xRemaining /= 10;
        }
        return isNegative ? -result : result;
    }

    /**
     * 5.3 Reverse bits
     * 
     */
}
