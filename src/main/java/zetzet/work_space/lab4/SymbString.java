package zetzet.work_space.lab4;

// Класс SymbString (произвольная строка символов)
public class SymbString implements StringObject {
    private String id;
    private String value;

    public SymbString(String id, String value) {
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
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String showBin() {
        return "Операция ShowBin() не поддерживается для SymbString.";
    }

    @Override
    public String showOct() {
        return "Операция ShowOct() не поддерживается для SymbString.";
    }

    @Override
    public String showHex() {
        return "Операция ShowHex() не поддерживается для SymbString.";
    }
}