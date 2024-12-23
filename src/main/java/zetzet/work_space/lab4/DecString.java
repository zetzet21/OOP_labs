package zetzet.work_space.lab4;

// Класс DecString (десятичная строка)
public class DecString implements StringObject {
    private String id;
    private int value;

    public DecString(String id, int value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public void setValue(String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public String showBin() {
        return "Бинарное представление: " + Integer.toBinaryString(value);
    }

    @Override
    public String showOct() {
        return "Восьмеричное представление: " + Integer.toOctalString(value);
    }

    @Override
    public String showHex() {
        return "Шестнадцатеричное представление: " + Integer.toHexString(value).toUpperCase();
    }
}
