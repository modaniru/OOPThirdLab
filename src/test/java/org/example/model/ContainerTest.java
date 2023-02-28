package org.example.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    @Test
    public void testAddElement() {
        //given
        Container<String> res = new Container<>();
        Container<String> excepted = new Container<>("some", "text", "here");
        //where
        res.addAll("some", "here");
        res.add("text", 1);
        //then
        Assertions.assertEquals(excepted, res);
    }

    @Test
    public void testAddElementWithException() {
        Container<Integer> container = new Container<>(); // size = 4, lastIndex = 3
        assertThrows(IndexOutOfBoundsException.class, () -> container.add(4, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> container.add(4, -1));
        container.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> container.add(1, 1));
    }

    @Test
    public void testAddFirst() {
        //given
        Container<Integer> container = new Container<>();
        Container<Integer> excepted = new Container<>(3, 2, 1);
        //when
        container.addFirst(1);
        container.addFirst(2);
        container.addFirst(3);
        //then
        assertEquals(excepted, container);
    }

    @Test
    public void testContainerTail() {
        //given
        Container<Integer> container = new Container<>();
        Container<Integer> excepted = new Container<>(1, 2, 3, 4, 5);
        //when
        container.addFirst(2);
        container.add(1, 0);
        container.add(4);
        container.add(3, 2);
        container.add(5);
        //then
        assertEquals(excepted, container);
    }

    @Test
    public void testGetSizeAndDelete() {
        Container<Integer> container = new Container<>();
        container.addAll(1, 2, 3);
        //container.delete();
        assertEquals(3, container.getSize());
        assertEquals(new Container<Integer>(1, 2, 3), container);
        container.delete(1);
        assertEquals(2, container.getSize());
        assertEquals(new Container<Integer>(2, 3), container);
        container.deleteAt(1);
        assertEquals(1, container.getSize());
        assertEquals(new Container<Integer>(2), container);
        container.delete(2);
        assertEquals(0, container.getSize());
        assertEquals(new Container<Integer>(), container);
        assertThrows(IndexOutOfBoundsException.class, () -> container.deleteAt(0));
        assertNull(container.delete(3131));
    }

    @Test
    public void testReplaceElement() {
        //given
        Container<Character> container = new Container<>('1', '0', '0', '1', '0', '0', '0', '0', '1');
        Container<Character> excepted = new Container<>('0', '0', '0', '0', '0', '0', '0', '0', '0');
        //when
        container.replaceAt('0', 0);
        container.replaceAt('0', 3);
        container.replaceAt('0', container.getSize() - 1);
        //then
        assertEquals(excepted, container);
    }

    @Test
    public void testGetElement(){
        //given
        String string = "added str";
        Container container = new Container(string, "str", "kek");
        //when
        //then
        assertEquals(string, container.get(0));
    }
}