import java.util.*;

public class MyArray implements List {

    static Object[] mainArr = new Object[9];
    int size = 0;

    /**
     * @return Значение длины массива
     * */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @return true, если массив пустой, иначе false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @param o element whose presence in this list is to be tested
     * @return true, если элемент о находится в массиве, иначе false
     */
    @Override
    public boolean contains(Object o) {
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
        return Arrays.copyOf(mainArr, size);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    /**
     *
     * @param o element whose presence in this collection is to be ensured
     * @return true, если элемент успешно добавился в массив, иначе false
     */

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

    /**
     *
     * @param o element to be removed from this list, if present
     * @return true, если элемент успешно удален из массива, иначе false
     */
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

    /**
     * Очищает весь массив
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            mainArr[i] = null;
        }
        size = 0;
    }

    /**
     *
     * @param index index of the element to return
     * @return возвращает элемент массива под данным индексом
     */
    @Override
    public Object get(int index) {
        return mainArr[index];
    }

    /**
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return вставляет значение element в массив под данным индексом
     */
    @Override
    public Object set(int index, Object element) {
        if (element.equals(null)) {
            return mainArr[index] = mainArr[index];
        }
        return mainArr[index] = element;
    }

    /**
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, Object element) {
        for (int i = size() - 1; i >= index; i--) {
            mainArr[i + 1] = mainArr[i];
        }
        mainArr[index] = element;
        size += 1;
    }

    /**
     *
     * @param index the index of the element to be removed
     * @return обновленный массив
     */
    @Override
    public Object remove(int index) {
        mainArr[index] = null;
        size--;
        for (int i = index; i < size - 1; i++) {
            mainArr[i] = mainArr[i + 1];
        }
        return mainArr;
    }

    /**
     *
     * @param o element to search for
     * @return индекс элемента o при первом вхождении
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (mainArr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param o element to search for
     * @return индекс элемента о при последнем вхождении
     */
    @Override
    public int lastIndexOf(Object o) {
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
