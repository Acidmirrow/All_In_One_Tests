package staff.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CountByX {

    /*
    Create a function with two arguments that will return an array of the first n multiples of x.
    Assume both the given number and the number of times to count will be positive numbers greater than 0.
    Return the results as an array or list ( depending on language ).
     */

    public static int[] countBy(int x, int n){
        if (x <= 0 || n <= 0) {
            throw new IllegalArgumentException("Both arguments must be > 0");
        }

        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            result[i - 1] = x * i;
            System.out.println(result[i-1]);
        }
        return result;
    }

    @Test
    public void fixedTests() {
        assertArrayEquals(new int[] {1,2,3,4,5,6,7,8,9,10}, countBy(1,10));
        assertArrayEquals(new int[] {2,4,6,8,10}, countBy(2,5));
        assertArrayEquals(new int[] {3,6,9,12,15,18,21}, countBy(3,7));
        assertArrayEquals(new int[] {50,100,150,200,250}, countBy(50,5));
        assertArrayEquals(new int[] {100,200,300,400,500,600}, countBy(100,6));
    }
}
