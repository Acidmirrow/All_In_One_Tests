package staff.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ConvertNumberToReversedArrayOfDigits {

    /*
    Given a random non-negative number, you have to return the digits of this number within an array in reverse order.
     */

    public static int[] digitize(long n) {
        String[] str = String.valueOf(n).split("");
        String[] str2 = new String[str.length];
        for (int i = 0; i < str.length; i++) {
            str2[str.length-i-1]=str[i];
        }
        int [] res = new int[str2.length];
        for (int i = 0; i < str2.length; i++) {
            res[i]=Integer.parseInt(str2[i]);
        }
        return res;
    }

    @Test
    public void sampleTests() {
        assertArrayEquals(new int[] {1,3,2,5,3}, digitize(35231));
        assertArrayEquals(new int[] {0}, digitize(0));
        assertArrayEquals(new int[] {7,5,3,2,8,5,3,2}, digitize(23582357));
        assertArrayEquals(new int[] {8,3,7,4,6,7,4,8,9}, digitize(984764738));
        assertArrayEquals(new int[] {0,2,9,3,9,8,2,6,7,5,4}, digitize(45762893920L));
        assertArrayEquals(new int[] {4,9,3,8,3,8,2,0,7,8,4,5}, digitize(548702838394L));
    }
}
