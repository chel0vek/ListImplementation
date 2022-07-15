import java.util.*;

public class MyArray implements List {

    static Object[] mainArr = new Object[9];
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o.equals(null) || o.equals("null")) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (mainArr[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(mainArr,size);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if (mainArr.length - size == 4) {
            Object[] newArr = new Object[mainArr.length * 2];
            for (int i = 0; i < size; i++) {
                newArr[i] = mainArr[i];
            }
            mainArr = newArr;
        }
        mainArr[size] = o;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int indexOfElement = indexOf(o);
        mainArr[indexOfElement] = null;
        size--;
        for (int i = indexOfElement; i < size; i++) {
            mainArr[i] = mainArr[i + 1];
        }
        indexOfElement--;

        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        for (int i = 0; i < size; i++) {
            mainArr[i] = null;
        }
    }

    @Override
    public Object get(int index) {
        return mainArr[index];
    }

    @Override
    public Object set(int index, Object element) {
        if (element.equals(null) || element.equals("null")) {
            return mainArr[index] = mainArr[index];
        }
        return mainArr[index] = element;
    }

    @Override
    public void add(int index, Object element) {
        if (element.equals("null") || element.equals(null)) {
            return;
        }
        for (int i = size() - 1; i >= index; i--) {
            mainArr[i + 1] = mainArr[i];
        }
        mainArr[index] = element;
        size += 1;
    }

    @Override
    public Object remove(int index) {
        mainArr[index] = null;
        size -= 1;
        for (int i = index; i < size - 1; i++) {
            mainArr[i] = mainArr[i + 1];
        }
        index--;
        return mainArr;
    }

    @Override
    public int indexOf(Object o) {
        if (o.equals(null) || o.equals("null")) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (mainArr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o.equals(null) || o.equals("null")) {
            return -1;
        }
        for (int i = size - 1; i >= 0; i--) {
            if (mainArr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }
}
