package staff.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumArrays {

    /*
    Write a function that takes an array of numbers and returns the sum of the numbers. The numbers can be negative or non-integer. If the array does not contain any numbers then you should return 0.
     */

    public class SumArray {

        public static double sum(double[] numbers) {
            double sum_of_numbers = Arrays.stream(numbers).sum();

            return sum_of_numbers;
        }
    }

    @Test
    public void testSum() {
        assertEquals(0,      SumArray.sum(new double[] { }),                1e-4);
        assertEquals(-2.398, SumArray.sum(new double[] {-2.398}),           1e-4);
        assertEquals(6,      SumArray.sum(new double[] {1, 2, 3}),          1e-4);
        assertEquals(6.6,    SumArray.sum(new double[] {1.1, 2.2, 3.3}),    1e-4);
        assertEquals(9.2,    SumArray.sum(new double[] {1, 5.2, 4, 0, -1}), 1e-4);
        assertEquals(320,    SumArray.sum(new double[] {30, 89, 100, 101}), 1e-4);
    }
}
