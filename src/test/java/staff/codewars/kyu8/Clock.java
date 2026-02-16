package staff.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Clock {

    /*
    Clock shows h hours, m minutes and s seconds after midnight.
    Your task is to write a function which returns the time since midnight in milliseconds.
     */

    public static int Past(int h, int m, int s) {
        return s*1000+m*60*1000+h*60*60*1000;

    }

    @Test
    public void test1(){

        assertEquals(61000, Clock.Past(0,1,1));
    }
}
