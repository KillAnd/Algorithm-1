package com.example.demo;

import com.example.demo.service.StringList;
import com.example.demo.service.StringListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    private final StringList stringList = new StringListImpl();

    @BeforeEach
    void before() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
    }


    @Test
    public void checkingTheAddition() {
        stringList.add("a");
        stringList.add("b");
        Assertions.assertEquals(5, stringList.size());
        Assertions.assertTrue(stringList.contains("a"));
        Assertions.assertTrue(stringList.contains("b"));
    }

    @Test
    public void checkingTheAdditionForIndex() {
        stringList.add(1, "c");
        Assertions.assertEquals(4, stringList.size());
        Assertions.assertEquals(stringList.get(1), "c");
        Assertions.assertEquals(stringList.get(2), "b");
    }

    @Test
    public void checkingForTheSet() {
        stringList.set(0, "c");
        Assertions.assertEquals(3, stringList.size());
        Assertions.assertEquals(stringList.get(0), "c");
        Assertions.assertEquals(stringList.get(1), "b");
    }

    @Test
    public void checkingForRemove() {
        stringList.remove("c");
        Assertions.assertEquals(2, stringList.size());
    }

    @Test
    public void checkingForRemoveIndex() {
        stringList.remove(2);
        Assertions.assertEquals(2, stringList.size());
    }

    @Test
    public void checkingForContains() {
         Assertions.assertTrue(stringList.contains("a"));
         Assertions.assertTrue(stringList.contains("b"));
         Assertions.assertFalse(stringList.contains("d"));
    }

    @Test
    public void checkingForIndexOf() {
        Assertions.assertEquals(0,stringList.indexOf("a"));
        Assertions.assertEquals(1,stringList.indexOf("b"));
        Assertions.assertEquals(2,stringList.indexOf("c"));
    }

    @Test
    public void checkingForIndexOfReverse() {
        Assertions.assertEquals(0,stringList.lastIndexOf("a"));
        Assertions.assertEquals(1,stringList.lastIndexOf("b"));
        Assertions.assertEquals(2,stringList.lastIndexOf("c"));
    }

    @Test
    public void checkingForGet() {
        assertEquals("a", stringList.get(0));
        assertEquals("b", stringList.get(1));
        assertEquals("c", stringList.get(2));
    }
    @Test
    void testEquals() {
        StringList otherList = new StringListImpl();
        otherList.add("a");
        otherList.add("b");
        otherList.add("c");
        assertTrue(stringList.equals(otherList));
    }
    @Test
    void testSize() {
        assertEquals(3, stringList.size());
        stringList.add("d");
        stringList.add("e");
        stringList.add("f");
        assertEquals(6, stringList.size());
    }
    @Test
    void testIsEmpty() {
        assertFalse(stringList.isEmpty());
        stringList.remove("a");
        stringList.remove("b");
        stringList.remove("c");
        assertTrue(stringList.isEmpty());
    }
    @Test
    void testClear() {
        stringList.clear();
        assertEquals(0, stringList.size());
        assertTrue(stringList.isEmpty());
    }
    @Test
    void testToArray() {
        String[] array = stringList.toArray();
        assertEquals(3, array.length);
        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
    }
}