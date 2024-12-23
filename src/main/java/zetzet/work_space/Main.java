package zetzet.work_space;

import zetzet.work_space.lab1.Vector3D;
import zetzet.work_space.lab2.Stack;
import zetzet.work_space.lab3.WORKER;
import zetzet.work_space.lab4.DecString;
import zetzet.work_space.lab4.Factory;
import zetzet.work_space.lab4.StringObject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Factory factory = new Factory();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Работа с векторами");
            System.out.println("2. Работа со стеком");
            System.out.println("3. Работа с работниками");
            System.out.println("4. Работа с фабрикой объектов");
            System.out.println("0. Выход");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера
            switch (choice) {
                case 1:
                    // Вызов меню работы с векторами
                    vectorMenu(scanner);
                    break;
                case 2:
                    // Вызов меню работы со стеком
                    stackMenu(scanner);
                    break;
                case 3:
                    // Вызов меню работы с работниками
                    workerMenu(scanner);
                    break;
                case 4:
                    // Вызов меню работы с фабрикой объектов
                    factoryMenu(scanner, factory);
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private static void factoryMenu(Scanner scanner, Factory factory) {
        while (true) {
            System.out.println("\nМеню работы с фабрикой объектов:");
            System.out.println("1. Создать объект");
            System.out.println("2. Удалить объект");
            System.out.println("3. Показать объект");
            System.out.println("4. Показать бинарное, восьмеричное и шестнадцатеричное представление");
            System.out.println("5. Показать все объекты");
            System.out.println("0. Назад");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера
            switch (choice) {
                case 1:
                    System.out.print("Введите тип объекта (SymbString/DecString): ");
                    String type = scanner.nextLine();
                    System.out.print("Введите идентификатор: ");
                    String id = scanner.nextLine();
                    System.out.print("Введите значение: ");
                    String value = scanner.nextLine();
                    try {
                        factory.createObject(type, id, value);
                        System.out.println("Объект создан.");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Введите идентификатор объекта для удаления: ");
                    String deleteId = scanner.nextLine();
                    try {
                        factory.deleteObject(deleteId);
                        System.out.println("Объект удален.");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Введите идентификатор объекта: ");
                    String getId = scanner.nextLine();
                    StringObject obj = factory.getObject(getId);
                    if (obj != null) {
                        System.out.println("Объект: " + obj.getId() + ", Значение: " + obj.getValue());
                    } else {
                        System.out.println("Объект не найден.");
                    }
                    break;
                case 4:
                    System.out.print("Введите идентификатор объекта: ");
                    String decId = scanner.nextLine();
                    StringObject decObj = factory.getObject(decId);
                    if (decObj instanceof DecString decString) {
                        System.out.println(decString.showBin());
                        System.out.println(decString.showOct());
                        System.out.println(decString.showHex());
                    } else {
                        System.out.println("Операция не поддерживается для данного объекта.");
                    }
                    break;
                case 5:
                    System.out.println("Все объекты:");
                    factory.getAllObjects().forEach((id1, object) ->
                            System.out.println("Идентификатор: " + id1 + ", Значение: " + object.getValue()));
                    break;
                case 0:
                    return; // Назад в главное меню
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    private static void vectorMenu(Scanner scanner) {
        Vector3D vector1 = new Vector3D(1, 2, 3, 4, 5, 6); // Начальная точка (1, 2, 3), конечная точка (4, 5, 6)
        Vector3D vector2 = new Vector3D(7, 8, 9, 10, 11, 12); // Начальная точка (7, 8, 9), конечная точка (10, 11, 12)

        boolean vectorRunning = true;
        while (vectorRunning) {
            System.out.println("\nМеню работы с векторами:");
            System.out.println("1. Ввести векторы векторы");
            System.out.println("2. Вывести векторы");
            System.out.println("3. Найти длину векторов");
            System.out.println("4. Сложить векторы");
            System.out.println("5. Вычесть векторы");
            System.out.println("6. Найти скалярное произведение");
            System.out.println("7. Найти косинус угла между векторами");
            System.out.println("0. Назад");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Ввод первого вектора:");
                    System.out.print("Введите x1: ");
                    double x1_1 = scanner.nextDouble();
                    System.out.print("Введите y1: ");
                    double y1_1 = scanner.nextDouble();
                    System.out.print("Введите z1: ");
                    double z1_1 = scanner.nextDouble();

                    System.out.print("Введите x2: ");
                    double x1_2 = scanner.nextDouble();
                    System.out.print("Введите y2: ");
                    double y1_2 = scanner.nextDouble();
                    System.out.print("Введите z2: ");
                    double z1_2 = scanner.nextDouble();

                    System.out.println("Ввод второго вектора:");
                    System.out.print("Введите x1: ");
                    double x2_1 = scanner.nextDouble();
                    System.out.print("Введите y1: ");
                    double y2_1 = scanner.nextDouble();
                    System.out.print("Введите z1: ");
                    double z2_1 = scanner.nextDouble();

                    System.out.print("Введите x2: ");
                    double x2_2 = scanner.nextDouble();
                    System.out.print("Введите y2: ");
                    double y2_2 = scanner.nextDouble();
                    System.out.print("Введите z2: ");
                    double z2_2 = scanner.nextDouble();

                    vector1 = new Vector3D(x1_1, y1_1, z1_1, x1_2, y1_2, z1_2);
                    vector2 = new Vector3D(x2_1, y2_1, z2_1, x2_2, y2_2, z2_2);
                    break;
                case 2:
                    System.out.println("Первый вектор: " + vector1);
                    System.out.println("Второй вектор: " + vector2);
                    break;
                case 3:
                    System.out.println("Длина первого вектора: " + vector1.length());
                    System.out.println("Длина второго вектора: " + vector2.length());
                    break;
                case 4:
                    System.out.println("Сумма векторов: " + vector1.add(vector2));
                    break;
                case 5:
                    System.out.println("Разность векторов: " + vector1.subtract(vector2));
                    break;
                case 6:
                    System.out.println("Скалярное произведение: " + vector1.dotProduct(vector2));
                    break;
                case 7:
                    System.out.println("Косинус угла между векторами: " + vector1.cosine(vector2));
                    break;
                case 0:
                    vectorRunning = false;
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private static void stackMenu(Scanner scanner) {
        Stack<Integer> stack = new Stack<>(); // Инициализация стека внутри метода

        boolean stackRunning = true;
        while (stackRunning) {
            System.out.println("\nМеню работы со стеком:");
            System.out.println("1. Добавить элемент в стек");
            System.out.println("2. Удалить элемент из стека");
            System.out.println("3. Посмотреть верхний элемент стека");
            System.out.println("4. Проверить, пуст ли стек");
            System.out.println("5. Посмотреть размер стека");
            System.out.println("6. Очистить стек");
            System.out.println("0. Назад");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Введите элемент для добавления: ");
                    int element = scanner.nextInt();
                    try {
                        stack.push(element);
                        System.out.println("Элемент добавлен.");
                    } catch (StackOverflowError e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        int removedElement = stack.pop();
                        System.out.println("Удалённый элемент: " + removedElement);
                    } catch (EmptyStackException e) {
                        System.out.println("Ошибка: Стек пуст.");
                    }
                    break;
                case 3:
                    try {
                        int topElement = stack.peek();
                        System.out.println("Верхний элемент стека: " + topElement);
                    } catch (EmptyStackException e) {
                        System.out.println("Ошибка: Стек пуст.");
                    }
                    break;
                case 4:
                    System.out.println("Стек пуст: " + stack.isEmpty());
                    break;
                case 5:
                    System.out.println("Размер стека: " + stack.size());
                    break;
                case 6:
                    stack.clear();
                    System.out.println("Стек очищен.");
                    break;
                case 0:
                    stackRunning = false;
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private static void workerMenu(Scanner scanner) {
        List<WORKER> workers = new ArrayList<>(); // Инициализация списка работников внутри метода

        boolean workerRunning = true;
        while (workerRunning) {
            System.out.println("\nМеню работы с работниками:");
            System.out.println("1. Показать всех работников");
            System.out.println("2. Добавить нового работника");
            System.out.println("3. Найти работника по имени");
            System.out.println("4. Показать работников, отсортированных по имени");
            System.out.println("5. Рассчитать стаж каждого работника");
            System.out.println("0. Назад");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    workers.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Введите имя: ");
                    scanner.nextLine(); // consume newline
                    String name = scanner.nextLine();
                    System.out.print("Введите должность: ");
                    String position = scanner.nextLine();
                    System.out.print("Введите год поступления: ");
                    int year = scanner.nextInt();
                    workers.add(new WORKER(name, position, year));
                    System.out.println("Работник добавлен.");
                    break;
                case 3:
                    System.out.print("Введите имя для поиска: ");
                    scanner.nextLine(); // consume newline
                    String searchName = scanner.nextLine();
                    workers.stream()
                            .filter(worker -> worker.getFullName().equalsIgnoreCase(searchName))
                            .forEach(System.out::println);
                    break;
                case 4:
                    List<WORKER> sortedWorkers = new ArrayList<>(workers);
                    Collections.sort(sortedWorkers);
                    sortedWorkers.forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Введите текущий год: ");
                    int currentYear = scanner.nextInt();
                    workers.forEach(worker -> {
                        System.out.println(worker.getFullName() + ": Стаж работы " + (currentYear - worker.getYearOfJoining()) + " лет.");
                    });
                    break;
                case 0:
                    workerRunning = false;
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }
}
