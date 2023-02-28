package org.example.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Consumer;

public class Container<T> {


    private class Node {
        private T value;
        private Node next;

        Node(T value) {
            System.out.println("Node(T value)");
            this.value = value;
        }

        Node() {
            System.out.println("Node()");
        }
        //for tests

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (!Objects.equals(value, node.value)) return false;
            return Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            int result = value != null ? value.hashCode() : 0;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public Container() {
        System.out.println("Container()");
        head = new Node();
        tail = head;
    }

    Container(T... values) {
        head = new Node();
        tail = head;
        for (T value : values) {
            add(value);
        }
    }

    //Вставка в конец списка
    public void add(T element) {
        System.out.println("public void add(T element)");
        tail.next = new Node(element);
        tail = tail.next;
        size++;
    }

    public void forEach(Consumer<T> runnable){
        Node node = head.next;
        while (node!=null){
            runnable.accept(node.value);
            node = node.next;
        }
    }

    //Вставка в середину списка
    public void add(T element, int index) {
        System.out.println("public void add(T element, int index)");
        if (index == 0 && size > 0) {
            size++;
            Node node = new Node(element);
            node.next = head.next;
            head.next = node;
            return;
        }
        Node preNode = findNode(index - 1);
        if (preNode.next == null) {
            throw new IndexOutOfBoundsException("out of capacity");//todo
        }
        size++;
        Node node = new Node(element);
        node.next = preNode.next;
        preNode.next = node;
    }

    //Вставка в начало списка
    public void addFirst(T element) {
        System.out.println("public void addFirst(T element)");
        Node node = new Node(element);
        node.next = head.next;
        head.next = node;
        //Если список пустой, и первой вызвалась функция добавления элемента в начало очереди, нужно проинициализировать
        //tail
        if (size == 0) {
            tail = node;
        }
        size++;
    }

    public void addAll(T... values) {
        for (T value : values) {
            add(value);
        }
    }

    public void replaceAt(T element, int index) {
        System.out.println("public void replaceAt(T element, int index)");
        Node node = findNode(index);
        node.value = element;
    }

    private Node findNode(int index) {
        System.out.println("private Node findNode(int index)");
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("out of capacity");//todo
        }
        Node temp = head.next;
        while (index != 0) {
            temp = temp.next;
            index--;
        }
        return temp;
    }

    public Integer getSize() {
        System.out.println("public Integer getSize()");
        return size;
    }

    public T get(int i) {
        return findNode(i).value;
    }

    public T deleteAt(Integer index) {
        if (index == 0 && size > 0) {
            Node node = head.next;
            head.next = head.next.next;
            size--;
            return node.value;
        }
        Node node = findNode(index - 1);
        Node res = node.next;
        size--;
        node.next = node.next.next;
        return res.value;
    }

    public void clear(){
        head.next = null;
        size = 0;
        tail = head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Container<?> container = (Container<?>) o;

        if (size != container.size) return false;
        return head != null ? head.equals(container.head) : container.head == null;
    }

    @Override
    public int hashCode() {
        int result = head != null ? head.hashCode() : 0;
        result = 31 * result + size;
        return result;
    }
}
