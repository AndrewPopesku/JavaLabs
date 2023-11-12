package org.example.serialization;

import java.io.*;
import java.lang.reflect.Constructor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtSerializer<T> implements Serializer<T> {

    private final DateTimeFormatter dateFormatter;

    public TxtSerializer() {
        dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Override
    public String serialize(T entity) {
        return entity.toString();
    }

    @Override
    public T deserialize(String data, Class<T> valueType) {
        Pattern pattern = Pattern.compile(valueType.getSimpleName() + "\\{name='(.*?)', venue='(.*?)', date='(.*?)'\\}");
        Matcher matcher = pattern.matcher(data);

        if (matcher.matches()) {
            String name = matcher.group(1);
            String venue = matcher.group(2);
            String date = matcher.group(3);

            try {
                Constructor<T> constructor = valueType.getDeclaredConstructor(String.class, String.class, LocalDate.class);
                return constructor.newInstance(name, venue, LocalDate.parse(date));
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public void writeToFile(T entity, File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(serialize(entity) + System.lineSeparator());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T readFromFile(File file, Class<T> valueType) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                T deserializedObject = deserialize(line, valueType);
                if (deserializedObject != null) {
                    return deserializedObject;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
