package zetzet.work_space.lab3;

import java.util.Objects;

public class WORKER implements Comparable<WORKER> {
    private String fullName; // Фамилия и инициалы работника
    private String position; // Название занимаемой должности
    private int yearOfJoining; // Год поступления на работу

    // Конструктор
    public WORKER(String fullName, String position, int yearOfJoining) {
        this.fullName = fullName;
        this.position = position;
        this.yearOfJoining = yearOfJoining;
    }

    // Геттеры и сеттеры
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    // Метод для расчета стажа работы
    public int getWorkExperience(int currentYear) {
        return currentYear - yearOfJoining;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return "WORKER{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                '}';
    }

    // Сравнение по имени для сортировки по алфавиту
    @Override
    public int compareTo(WORKER other) {
        return this.fullName.compareToIgnoreCase(other.fullName);
    }

    // Переопределение equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WORKER worker = (WORKER) o;
        return yearOfJoining == worker.yearOfJoining &&
                Objects.equals(fullName, worker.fullName) &&
                Objects.equals(position, worker.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, position, yearOfJoining);
    }
}
