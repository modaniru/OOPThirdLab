package org.example.model;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class Container<T> implements Iterable<T> {

    /**
     * Узел, который используется в контейнере
     */
    private class Node {
        /**
         * Значение узла
         */
        private T value;
        /**
         * Ссылка на следующий элемент
         */
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
    private class ContainerIterator implements Iterator<T>{
        private Node current;
        ContainerIterator(Node head){
            current = head;
        }
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }

    private final Node head;
    private Node tail;
    private Node tempNode;
    private int size;

    /**
     * no-args
     */
    public Container() {
        System.out.println("public Container()");
        head = new Node();
        tempNode = head.next;
        tail = head;
    }

    /**
     * Конструктор с изначальной инициализацией содержимого контейнера
     * Асимптотика:
     * Время: O(1)
     * Память: O(1)
     *
     * @param values
     */
    public Container(T... values) {
        System.out.println("public Container(T... values)");
        head = new Node();
        tempNode = head.next;
        tail = head;
        for (T value : values) {
            add(value);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ContainerIterator(head.next);
    }

    /**
     * Добавляет элемент в конец списка
     *
     * @param element Асимптотика:
     *                Время: O(1)
     *                Память: O(1)
     */
    public void add(T element) {
        System.out.println("public void add(T element)");
        tail.next = new Node(element);
        tail = tail.next;
        size++;
    }

    /**
     * Вставка элемента в середину списка по псевдо-индексу
     * Асимптотика:
     * Время: O(n)
     * Память: O(1)
     *
     * @param element
     * @param index
     */
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

    /**
     * Добавление в начало списка элемента
     * Асимптотика:
     * Время: O(1)
     * Память: O(1)
     *
     * @param element
     */
    public void addFirst(T element) {
        System.out.println("public void addFirst(T element)");
        Node node = new Node(element);
        node.next = head.next;
        head.next = node;
        if (size == 0) {
            tail = node;
        }
        size++;
    }

    /**
     * Добавляет несколько значений в список
     * Асимптотика:
     * Время: O(n)
     * Память: O(1)
     *
     * @param values
     */
    public void addAll(T... values) {
        System.out.println("public void addAll(T... values)");
        for (T value : values) {
            add(value);
        }
    }

    /**
     * Заменяет значение поля value Node под псевдо-индесом
     * Асимптотика:
     * Время: O(n)
     * Память: O(1)
     *
     * @param element
     * @param index
     */
    public void replaceAt(T element, int index) {
        System.out.println("public void replaceAt(T element, int index)");
        Node node = findNode(index);
        node.value = element;
    }

    /**
     * Приватный метод, возвращающий Node под заданным псевдо-индексом
     * Асимптотика:
     * Время: O(n)
     * Память: O(1)
     *
     * @param index
     * @return Node
     */
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

    /**
     * Возвращает текущий размер списка
     *
     * @return size
     */
    public Integer getSize() {
        System.out.println("public Integer getSize()");
        return size;
    }

    /**
     * Возвращает объект, под псеводо-индексом index
     * Асимптотика:
     * Время: O(n)
     * Память: O(1)
     *
     * @param index
     * @return Объект класса T
     */
    public T get(int index) {
        System.out.println("public T get(int index)");
        return findNode(index).value;
    }

    /**
     * Удаляет узел под заданным индексом, возвращая значение поля value этого узла
     * Асимптотика:
     * Время: O(n)
     * Память: O(1)
     *
     * @param index
     * @return Объект класса T
     */
    public T deleteAt(Integer index) {
        System.out.println("public T deleteAt(Integer index)");
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

    /**
     * Очищает контейнер путем установки head.next = null
     * Асимптотика:
     * Время: O(1)
     * Память: O(1)
     *
     * @return void
     */
    public void clear() {
        System.out.println("public void clear()");
        head.next = null;
        tempNode = head.next;
        size = 0;
        tail = head;
    }

    //for tests
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
