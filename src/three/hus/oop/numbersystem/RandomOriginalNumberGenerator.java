package three.hus.oop.numbersystem;

import java.util.Random;

public class RandomOriginalNumberGenerator {

    private static final String DIGITS = "0123456789ABCDEF";

    private static void checkBoundaries(int upper, int lower, int limit) {
        if ((upper <= 0 || upper > limit) ||
                (lower <= 0 || lower > limit) ||
                (lower > upper)) throw new IllegalArgumentException();
    }

    // Inclusive (Closed)
    private static int generateRandomRadix(int lowerbound, int upperbound) {
//        checkBoundaries(lowerbound, upperbound, 16);
        Random random = new Random();
        return random.nextInt(upperbound - lowerbound + 1) + lowerbound;
    }

    // Inclusive (Closed)
    private static String generateRandomNumberString(int radix,
                                                     int lengthLowerBound,
                                                     int lengthUpperBound) {
        Random random = new Random();
        int length = random.nextInt(lengthUpperBound - lengthLowerBound + 1) + lengthLowerBound;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int digitIndex = random.nextInt(radix);
            char digit = DIGITS.charAt(digitIndex);
            sb.append(digit);
        }
        return sb.toString();
    }

    public static OriginalNumber generateOriginalNumber(int radixLowerBound,
                                                        int radixUpperBound,
                                                        int lengthLowerBound,
                                                        int lengthUpperBound) {
        int radix = generateRandomRadix(radixLowerBound, radixUpperBound);

        return new OriginalNumber(generateRandomNumberString(radix,
                lengthLowerBound, lengthUpperBound), radix);
    }

}
