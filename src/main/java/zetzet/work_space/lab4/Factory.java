package zetzet.work_space.lab4;

import java.util.HashMap;
import java.util.Map;

// Класс Factory для создания и удаления объектов
public class Factory {
    private Map<String, StringObject> objects = new HashMap<>();

    public StringObject createObject(String type, String id, String value) {
        if (objects.containsKey(id)) {
            throw new IllegalArgumentException("Объект с идентификатором " + id + " уже существует.");
        }

        StringObject obj;
        if (type.equals("SymbString")) {
            obj = new SymbString(id, value);
        } else if (type.equals("DecString")) {
            obj = new DecString(id, Integer.parseInt(value));
        } else {
            throw new IllegalArgumentException("Неизвестный тип объекта: " + type);
        }

        objects.put(id, obj);
        return obj;
    }

    public void deleteObject(String id) {
        if (!objects.containsKey(id)) {
            throw new IllegalArgumentException("Объект с идентификатором " + id + " не найден.");
        }
        objects.remove(id);
    }

    public StringObject getObject(String id) {
        return objects.get(id);
    }

    public Map<String, StringObject> getAllObjects() {
        return objects;
    }
}
