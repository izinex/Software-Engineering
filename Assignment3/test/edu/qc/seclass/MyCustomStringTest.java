package edu.qc.seclass;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;


    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }


    @Test
    public void testCountNumbers2() {
        mycustomstring.setString("");
        assertEquals(0,mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers3() {
        mycustomstring.setString("Hello there are no numbers here");
        assertEquals(0,mycustomstring.countNumbers());
    }

    @Test (expected = NullPointerException.class)
    public void testCountNumbers4() {
        mycustomstring.setString(null);
        assertEquals(0,mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("th3r3 sh0u1d b3 10 d1g14s 1n h3r3");
        assertEquals(10, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("111and");
        assertEquals(1, mycustomstring.countNumbers());
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("Why do we have to do so many test cases");
        assertEquals("yoea    nttas", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.setString("Why do we have to do so many test cases");
        assertEquals("W   vtdsmye s", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString("123jhasdjik");
        assertEquals("2jadi", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString("123jhasdjik");
        assertEquals("2jadi", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString("123jhasdjik");
        assertEquals("3aj", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString("   4   4   4");
        assertEquals("444", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(4, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString("   4   4   4");
        assertEquals("   ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(4, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("   4   4   4");
        assertEquals("   4   4   4", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        mycustomstring.setString("godspl4n");
        assertEquals("sn", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(4, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString("godspl4n");
        assertEquals("gp", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(4, true));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("godspl4n");
        assertEquals("gp", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true));
    }

    @Test (expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        mycustomstring.setString(null);
        assertEquals("gp", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true));
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("1 2 3 4 5");
        mycustomstring.convertDigitsToNamesInSubstring(1, 3);
        assertEquals("One Two 3 4 5", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("1n thi3 fl0or");
        mycustomstring.convertDigitsToNamesInSubstring(1, 12);
        assertEquals("Onen thiThree flZeroor", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("1st f1oor 2nd");
        mycustomstring.convertDigitsToNamesInSubstring(5, 12);
        assertEquals("1st fOneoor Twond", mycustomstring.getString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString("1st f1oor 2nd");
        mycustomstring.convertDigitsToNamesInSubstring(4, 3);
        assertEquals("0", mycustomstring.getString());
    }

    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString("1st f1oor 2nd");
        mycustomstring.convertDigitsToNamesInSubstring(25, 30);
        assertEquals("0", mycustomstring.getString());
    }

    @Test (expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(5, 8);
        assertEquals("0", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("1st f1oor 2nd");
        mycustomstring.convertDigitsToNamesInSubstring(9, 13);
        assertEquals("1st f1oor Twond", mycustomstring.getString());
    }

}
