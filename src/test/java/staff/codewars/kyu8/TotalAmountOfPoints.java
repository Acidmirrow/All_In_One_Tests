package staff.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalAmountOfPoints {
    /*
    Our football team has finished the championship.
    Our team's match results are recorded in a collection of strings. Each match is represented by a string in the format "x:y", where x is our team's score and y is our opponents score.
    For example: ["3:1", "2:2", "0:1", ...]
    Points are awarded for each match as follows:
    if x > y: 3 points (win)
    if x < y: 0 points (loss)
    if x = y: 1 point (tie)
    We need to write a function that takes this collection and returns the number of points our team (x) got in the championship by the rules given above.
     */

    public static int points(String[] games) {
        int points=0;
        int ourTeam=0;
        int opponentsScore;
        for (int i = 0; i < games.length; i++) {
            String[] fruitArray = games[i].split(":");
            ourTeam = Integer.parseInt(fruitArray[0]);
            opponentsScore = Integer.parseInt(fruitArray[1]);
            if(ourTeam>opponentsScore)
            {
                points=points+3;
            }
            if (ourTeam==opponentsScore){
                points=points+1;
            }
        }
        return points;
    }

    public static int points2 (String[] games) {
        int total = 0;
        for(String s : games){
            int x = Integer.parseInt(s.split(":",2)[0],10);
            int y = Integer.parseInt(s.split(":",2)[1],10);
            if(x > y){ total += 3;}
            if(x == y){ total += 1;}
        }
        return total;
    }

    @Test
    public void basicTests() {
        assertEquals(30, points(new String[]
                {"1:0","2:0","3:0","4:0","2:1","3:1","4:1","3:2","4:2","4:3"}));

        assertEquals(10, points(new String[]
                {"1:1","2:2","3:3","4:4","2:2","3:3","4:4","3:3","4:4","4:4"}));

        assertEquals(0, points(new String[]
                {"0:1","0:2","0:3","0:4","1:2","1:3","1:4","2:3","2:4","3:4"}));

        assertEquals(15, points(new String[]
                {"1:0","2:0","3:0","4:0","2:1","1:3","1:4","2:3","2:4","3:4"}));

        assertEquals(12, points(new String[]
                {"1:0","2:0","3:0","4:4","2:2","3:3","1:4","2:3","2:4","3:4"}));
    }



}
