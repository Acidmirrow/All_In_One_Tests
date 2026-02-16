package staff.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfOddNumbers {

    /*
    Given the triangle of consecutive odd numbers:
             1
          3     5
       7     9    11
   13    15    17    19
21    23    25    27    29
    Calculate the sum of the numbers in the nth row of this triangle (starting at index 1) e.g.: (Input --> Output)
     */


    public static int rowSumOddNumbers(int n) {
    return (int)Math.pow(n,3);
    }

    @Test
    public void test1() {
        assertEquals(1, rowSumOddNumbers(1));
        assertEquals(74088, rowSumOddNumbers(42));
    }
}
