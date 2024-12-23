package zetzet.work_space.lab2;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    private ArrayList<T> elements; // Серверный класс для хранения элементов
    private int maxSize; // Максимальный размер стека (опционально)

    // Конструктор без ограничения на размер
    public Stack() {
        this.elements = new ArrayList<>();
    }

    // Конструктор с ограничением на размер
    public Stack(int maxSize) {
        this.elements = new ArrayList<>();
        this.maxSize = maxSize;
    }

    // Добавление элемента в стек
    public void push(T element) throws StackOverflowError {
        if (maxSize > 0 && elements.size() >= maxSize) {
            throw new StackOverflowError("Стек переполнен!");
        }
        elements.add(element);
    }

    // Удаление элемента с вершины стека
    public T pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    // Получение элемента с вершины стека без удаления
    public T peek() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }

    // Проверка, пуст ли стек
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Текущее количество элементов в стеке
    public int size() {
        return elements.size();
    }

    // Очистка стека
    public void clear() {
        elements.clear();
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
