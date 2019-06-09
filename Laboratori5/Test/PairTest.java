/**
 * @author Boris Llona Alonso
 * @author Flor Martinez Malaret
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class PairTest {
    @Test
    public void firstInt(){
        Pair<Integer, Integer> pairInt = new Pair<>(1,2);
        assertEquals(Integer.valueOf(1), pairInt.first());
    }

    @Test
    public void secondInt(){
        Pair<Integer, Integer> pairInt = new Pair<>(1,2);
        assertEquals(Integer.valueOf(2), pairInt.second());
    }

    @Test
    public void firstSecondString(){
        Pair<String, String> pairStrings = new Pair<>("Boris","Flor");
        assertEquals(pairStrings.first(), "Boris");
        assertEquals(pairStrings.second(), "Flor");
        assertNotEquals(pairStrings.first(),pairStrings.second());
    }

}


