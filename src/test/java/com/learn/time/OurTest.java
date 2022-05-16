package com.learn.time;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OurTest {
    @Test
    public void givenPrimitiveType_whenGettingClassObject_thenOnlyStaticTypeWorks() {
        Class intType = int.class;
        assertNotNull(intType);
        assertEquals("int", intType.getName());
        assertTrue(intType.isPrimitive());
    }
}
