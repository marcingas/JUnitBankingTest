package pl.marcin.challenge;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class UtilitiesTest {
    Utilities utilities;
    @Before
    public void setup(){
        utilities = new Utilities();
    }

    @org.junit.Test
    public void everyNthChar()throws Exception {
       assertArrayEquals(new char[]{'e','l'},
               utilities.everyNthChar(new char[]{'h','e','l','l','o'},2));
    }
    @org.junit.Test
    public void everyNthCharNTest()throws Exception {
        char[]chararr = new char[]{'h','e','l','l','o'};
        assertArrayEquals(new char[]{'h','e','l','l','o'},
                utilities.everyNthChar(chararr,(chararr.length +1)));
    }

    @org.junit.Test
    public void removePairs() throws Exception{
       String check = utilities.removePairs("AABCDDEFF");
       assertEquals("ABCDEF",check);
       assertEquals("ABCABDEF",utilities.removePairs("ABCCABDEEF"));
       assertNull("Did not get null returned when arg was null",utilities.removePairs(null));
       assertEquals("A",utilities.removePairs("A"));
       assertEquals("",utilities.removePairs(""));

    }

    @org.junit.Test
    public void converter() throws Exception {
        assertEquals(300,utilities.converter(10,5));
    }
    @org.junit.Test(expected = ArithmeticException.class)
    public void converterArithmeticException() throws Exception {
        utilities.converter(10,0);
    }

    @org.junit.Test
    public void nullOddLength() throws Exception {
       assertNotNull(utilities.nullOddLength("ABCD"));
       assertNull(utilities.nullOddLength("ABCDE"));
    }
}