import java.util.Scanner;

public class Main {
    static MyArray myList = new MyArray();
    public static void main(String[] args) {
        menu();
    }
    static void menu() {
        try{
            System.out.println("Выберите действие");
            System.out.println("""
                    1. Добавить элемент
                    2. Узнать размер листа
                    3. Проверить пустой ли лист
                    4. Очистить весь лист
                    5. Положить элемент (set)
                    6. Метод contains
                    7. Удалить объект
                    8. Удалить по индексу
                    9. Метод получить по индексу
                    10. Узнать индекс элемента
                    11. Узнать индекс последнего элемента    
                    12. Добавить(вставить) элемент по индексу
                    13. toArray();
                    """);
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.println("Введите что вы хотите добавить");
                String el = input.next();
                var check = myList.add(el);
                if (check) {
                    System.out.println("Успешно добавлено");
                }
            }
            if (choice == 2) {
                var size = myList.size();
                System.out.println(size);
            }
            if (choice == 3) {
                var isEmpty =myList.isEmpty();
                if (isEmpty) {
                    System.out.println("Массив пустой");
                }
                else System.out.println("Не пустой");
            }
            if (choice == 4) {
                myList.clear();
                System.out.println("Успешно очищен");
            }
            if (choice == 5) {
                System.out.println("Введите индекс в который вы хотите положить элемент");
                int index = input.nextInt();
                System.out.println("Введите что вы хотите положить в массив");
                String elem = input.next();
                myList.set(index, elem);
            }
            if (choice == 6) {
                System.out.println("Введите элемент который хотите проверить");
                String elem = input.next();
                var contains = myList.contains(elem);
                if (contains) {
                    System.out.println("Данный элемент находится в массиве");
                }
                else {
                    System.out.println("Данный элемент не находится в массиве");
                }

            }
            if (choice == 7) {
                System.out.println("Введите элемент который хотите удалить");
                String elem = input.next();
                var remove = myList.remove(elem);
                if (remove) {
                    System.out.println("Элемент успешно удален");
                }
            }
            if (choice == 8) {
                System.out.println("Введите индекс");
                int index = input.nextInt();
                myList.remove(index);
            }
            if (choice == 9) {
                System.out.println("Введите индекс");
                int index = input.nextInt();
                var elem = myList.get(index);
                System.out.println(elem);
            }
            if (choice == 10) {
                System.out.println("Введите элемент индекс которого хотите узнать");
                String el = input.next();
                var elem = myList.indexOf(el);
                System.out.println("Индекс элемента " + el + " = " + elem);
            }
            if (choice == 11) {
                System.out.println("Введите элемент индекс которого хотите узнать (возвращает последний индекс)");
                String el = input.next();
                var elem = myList.lastIndexOf(el);
                System.out.println("Индекс элемента " + el + " = " + elem);
            }
            if (choice == 12) {
                System.out.println("Введите индекс в который вы хотите добавить элемент");
                int index = input.nextInt();
                System.out.println("Введите что вы хотите положить в данный индекс");
                String el = input.next();
                myList.add(index,el);
                System.out.println("Элемент " + el + " успешно добавлен " + "по индексу " + index);
            }
            if (choice == 13) {
                myList.toArray();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            menu();

        }
    }

}