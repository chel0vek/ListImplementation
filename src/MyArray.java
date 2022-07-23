import java.util.*;

public class MyArray implements List {

    static Object[] mainArr = new Object[9];
    int size = 0;

    /**
     * Метод, возвращающий длину массива
     * @return Значение длины массива
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Метод, проверяющий пустой массив или нет
     * @return true, если массив пустой, иначе false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Метод, проверяющий есть ли указанный элемент в массиве
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

    /**
     * Метод, перебирающий все элементы массива
     * @return new iterator
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            int index = 0;

            /**
             * Метод, проверяющий есть ли следующий элемент
             * @return true, если есть следующий элемент, иначе false
             */
            @Override
            public boolean hasNext() {
                return index < size;
            }

            /**
             * Метод, возвращающий следующий элемент
             * @return элемент из данного массива
             */
            @Override
            public Object next() {
                return mainArr[index++] ;
            }
        };
    }

    /**
     * Метод, возвращающий копию массива
     * @return copy of Main Array
     */
    public Object[] toArray() {
        return Arrays.copyOf(mainArr,size);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return Arrays.copyOf(a,a. length);
    }
    /**
     * Метод, добавляющий элемент в массив
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
     * Метод, удаляющий указанный элемент при первом вхождении
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
     * Метод, очищающий весь массив
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            mainArr[i] = null;
        }
        size = 0;
    }

    /**
     * Метод, возращающий элемент из массива по данному индексу.
     * @param index index of the element to return
     * @return возвращает элемент массива под данным индексом
     */
    @Override
    public Object get(int index) {
        return mainArr[index];
    }

    /**
     * Метод, заменяющий элемент, находяйщися под данным индексом, на указанный элемент.
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
     * Метод, вставляющий указанный элемент в массив в указанный индекс.
     * Данный метод передвигает элемент находящийся под данным индексом и все последующие вправо.
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
     * Метод, удаляющий элемент из данного массива, который находится под данным индексом.
     * Данный метод перемещает все элементы находящиеся справо от удаленного элемента влево.
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
     * Метод, возвращающий индекс элемента при первом вхождении
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
     * Метод, возвращающий индекс элемента при последнем вхождении
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

    /**
     * Метод, возвращающий элементы данного массива в промежутке от первого параметра до второго
     * Не включительно.
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @return элементы из массива в промежутке от fromIndex до toIndex
     */
    @Override
    public List subList(int fromIndex, int toIndex) {
        var result = Arrays.copyOfRange(mainArr,fromIndex,toIndex);
        return List.of(result);
    }
}
