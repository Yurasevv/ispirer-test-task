package com.ispirer.utils;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class ListUsr<T> implements Iterable {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    private boolean capacityChanged = false;

    public ListUsr() {
        this.elements = new Object[0];
    }

    public ListUsr(Object[] elements, int size, boolean capacityChanged) {
        this.elements = elements;
        this.size = size;
        this.capacityChanged = capacityChanged;
    }

    public ListUsr(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[capacity];
        } else if (capacity == 0) {
            this.elements = new Object[0];
        } else {
            throw new IllegalArgumentException("Illegal capacity: "+
                    capacity);
        }
    }
    private Object[] grow(int minCapacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > 0 || elements.length != 0) {
            int newCapacity = elements.length + 10;
            this.capacityChanged = true;
            return elements = Arrays.copyOf(elements, newCapacity);
        } else {

            return elements = new Object[DEFAULT_CAPACITY];
        }
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    public Object get(int index) {
        Objects.checkIndex(index, size);
        return elements[index];
    }

    public Object set(int index, Object element) {
        Objects.checkIndex(index, size);
        elements[index] = element;
        return index;
    }

    private void add(Object o, Object[] elements, int s) {
        if (s == elements.length)
            elements = grow();
        elements[s] = o;
        size = s + 1;
    }

    public boolean add(Object o) {
        add(o, elements, size);
        return true;
    }

    public static int getDefaultCapacity() {
        return DEFAULT_CAPACITY;
    }

    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean capacityChanged() {
        return capacityChanged;
    }

    public void setCapacityChanged(boolean capacityChanged) {
        this.capacityChanged = capacityChanged;
    }


    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && elements[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) elements[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

}
