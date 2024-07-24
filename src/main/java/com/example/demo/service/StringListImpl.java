package com.example.demo.service;

import com.example.demo.exceptions.InvalidIndexException;
import com.example.demo.exceptions.NullItemException;
import com.example.demo.exceptions.SizeIsFullException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] itemList;
    private int size;

    public StringListImpl() {
        this.itemList = new String[10];
        this.size = 0;
    }

    public StringListImpl(int initSize) {
        this.itemList = new String[initSize];
        this.size = 0;
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        itemList[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateIndex(index);
        validateItem(item);

        if (index == size) {
            itemList[size++] = item;
            return item;
        }

        System.arraycopy(itemList, index, itemList, index + 1, size - index);
        itemList[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        itemList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = itemList[index];
        if (index != size) {
            System.arraycopy(itemList, index + 1, itemList, index, size - index);

        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (itemList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size-1; i >= 0; i--) {
            if (itemList[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return itemList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(),otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(itemList,size);
    }

    public void validateItem(String item) {
        if (item == null) {
            throw new NullItemException("Нулевое значение");
        }
    }

    public void validateSize() {
        if (size == itemList.length) {
            throw new SizeIsFullException("Массив заполнен");
        }
        int newCapacity = itemList.length * 2;
        itemList = Arrays.copyOf(itemList, newCapacity);
    }

    public void validateIndex(int index) {
        if (index < 0 || index >= itemList.length ) {
            throw new InvalidIndexException("Неверный индекс");
        }
    }
}
