package org.speedfirst.test;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Test for the equality of java (== or equals)
 */
public class JavaEqualsTest {

    @Test
    public void testShortAndLongEquals() {
        short v1 = 18;
        Long v2 = new Long("18");
        Long v3 = new Long(18);
        Short v4 = new Short(v1);

        assertTrue(v1 == v2);
        assertFalse(v2.equals(v1)); //NOTE!! v1 == v2 but not equals
        assertFalse(v2 == v3);
        assertFalse(v3.equals(v1));
        assertFalse(v3.equals(v4));
    }
}
