package zetzet.work_space.lab4;

// Базовый интерфейс для строковых объектов
public interface StringObject {
    String getId();
    void setId(String id);
    String getValue();
    void setValue(String value);
    String showBin();
    String showOct();
    String showHex();
}