package ru.sberbank.jd.lesson06;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * Simple array. Can store any objects.
 */
public class CustomArrayImpl<T> implements CustomArray<T> {

    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    Object[] elementData;
    private int size;

    /**
     * Constructor default array.
     */
    public CustomArrayImpl() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * Constructor with capacity.
     *
     * @param capacity the initial capacity of the list
     */
    public CustomArrayImpl(int capacity) {
        if (capacity > 0) {
            this.elementData = new Object[capacity];
        } else if (capacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    /**
     * Constructor with collection.
     *
     * @param c random collection.
     */
    public CustomArrayImpl(Collection<T> c) {
        if (c == null) {
            throw new IllegalArgumentException("Collection c cannot be null");
        }
        Object[] a = c.toArray();
        if ((size = a.length) != 0) {
            elementData = Arrays.copyOf(a, size, Object[].class);
        } else {
            elementData = EMPTY_ELEMENTDATA;
        }
    }

    /**
     * Return array's size.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add single item.
     *
     * @param item object item.
     * @return true if the element is added
     */
    public boolean add(T item) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = item;
        size++;
        return true;
    }

    /**
     * Increases the length of the array by 2 times.
     */
    private void grow() {
        Object[] temp = new Object[elementData.length * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = elementData[i];
        }
        this.elementData = temp;
    }

    /**
     * Add all items.
     *
     * @param items object array.
     * @return true if the items added
     * @throws IllegalArgumentException if parameter items is null
     */
    public boolean addAll(T[] items) {
        if (items == null) {
            throw new IllegalArgumentException("items is null");
        }
        Object[] temp = new Object[items.length + size];
        for (int i = 0; i < size; i++) {
            temp[i] = elementData[i];
        }
        for (int j = size; j < items.length + size; j++) {
            temp[j] = items[j - size];
        }
        this.elementData = temp;
        size = size + items.length;
        return true;
    }

    /**
     * Add all items.
     *
     * @param items collection items.
     * @return true if the items added
     * @throws IllegalArgumentException if parameter items is null
     */
    public boolean addAll(Collection<T> items) {
        if (items == null) {
            throw new IllegalArgumentException("items is null");
        }
        Object[] a = items.toArray();
        addAll((T[]) a);
        return true;
    }

    /**
     * Add items to current place in array.
     *
     * @param index - index
     * @param items - items for insert
     * @return true if items added
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     * @throws IllegalArgumentException       if parameter items is null
     */
    public boolean addAll(int index, T[] items) {
        if (items == null) {
            throw new IllegalArgumentException("items is null");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Object[] temp = new Object[items.length + size];
        for (int i = 0; i < index; i++) {
            temp[i] = elementData[i];
        }
        for (int j = index; j < items.length + index; j++) {
            temp[j] = items[j - index];
        }
        for (int y = items.length + index; y < items.length + size; y++) {
            temp[y] = elementData[y - items.length];
        }
        this.elementData = temp;
        size = size + items.length;
        return true;
    }

    /**
     * Get item by index.
     *
     * @param index - index
     * @return item
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return (T) elementData[index];
    }

    /**
     * Set item by index.
     *
     * @param index - index of array.
     * @param item  object item.
     * @return old value.
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds.
     */
    public T set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        T oldValue = (T) elementData[index];
        elementData[index] = item;
        return oldValue;
    }

    /**
     * Remove item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Object[] temp = new Object[elementData.length];
        for (int i = 0; i < index; i++) {
            temp[i] = elementData[i];
        }
        for (int j = index; j < size - 1; j++) {
            temp[j] = elementData[j + 1];
        }
        elementData = temp;
        size = size - 1;
    }

    /**
     * Remove item by value. Remove first item occurrence.
     *
     * @param item - item
     * @return true if item was removed
     */
    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elementData[i], item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if item exists.
     *
     * @param item - item
     * @return true or false
     */
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    /**
     * Index of item.
     *
     * @param item - item
     * @return index of element or -1 of list doesn't contain element
     */

    public int indexOf(T item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elementData[i], item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Grow current capacity to store new elements if needed.
     *
     * @param newElementsCount - new elements count
     */
    public void ensureCapacity(int newElementsCount) {
        if (newElementsCount > elementData.length) {
            Object[] temp = new Object[newElementsCount];
            for (int i = 0; i < size; i++) {
                temp[i] = elementData[i];
            }
            this.elementData = temp;
        }
    }

    /**
     * Get current capacity.
     */
    public int getCapacity() {
        return elementData.length;
    }

    /**
     * Reverse list.
     */
    public void reverse() {
        Object[] temp = new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = elementData[size - 1 - i];
        }
        elementData = temp;
    }

    /**
     * Get copy of current array.
     */
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = elementData[i];
        }
        return result;
    }

    /**
     * Get content in format '[ element1 element2 ... elenentN ] or [ ] if empty.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        if (elementData.length == 0) {
            return "[ ]";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(elementData[i]);
                if (i < size - 1) {
                    sb.append(" ");
                }
            }
            sb.append("]");

            return sb.toString();
        }
    }
}