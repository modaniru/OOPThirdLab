package org.example.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    @Test
    public void testAddElement(){
        //given
        Container<String> res = new Container<>();
        Container<String> excepted = new Container<>("some", "text", "here");
        //where
        res.add("some");
        res.add("here");
        res.add("text", 1);
        //then
        Assertions.assertEquals(excepted, res);
    }
    @Test
    public void testAddElementWithException(){
        Container<Integer> container = new Container<>(); // size = 4, lastIndex = 3
        assertThrows(IndexOutOfBoundsException.class, () -> container.add(4, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> container.add(4, -1));
    }
    @Test
    public void testAddFirst(){
        //given
        Container<Integer> container = new Container<>();
        Container<Integer> excepted = new Container<>(3,2,1);
        //when
        container.addFirst(1);
        container.addFirst(2);
        container.addFirst(3);
        //then
        assertEquals(excepted, container);
    }

    @Test
    public void testContainerTail(){
        //given
        Container<Integer> container = new Container<>();
        Container<Integer> excepted = new Container<>(1,2,3,4,5);
        //when
        container.addFirst(2);
        container.addFirst(1);
        container.add(4);
        container.add(3, 2);
        container.add(5);
        //then
        assertEquals(excepted, container);
    }

    @Test
    public void testGetSize(){
        Container<Integer> container = new Container<>();
        container.add(1);
        container.add(1);
        container.add(1);
        //container.delete();
        assertEquals(3, container.getSize());
    }

    @Test
    public void testReplaceElement(){
        //given
        Container<Character> container = new Container<>('1','0','0','1','0','0','0','0','1');
        Container<Character> excepted = new Container<>('0','0','0','0','0','0','0','0','0');
        //when
        container.replaceAt('0', 0);
        container.replaceAt('0', 3);
        container.replaceAt('0', container.getSize() - 1);
        //then
        assertEquals(excepted, container);
    }
}