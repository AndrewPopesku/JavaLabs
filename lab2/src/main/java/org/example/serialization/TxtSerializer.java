package org.example.serialization;

import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtSerializer<T> implements Serializer<T> {

    private final DateTimeFormatter dateFormatter;

    public TxtSerializer() {
        dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    @Override
    public String serialize(T entity) {
        return entity.toString();
    }

    @Override
    public T deserialize(String data, Class<T> valueType) {
        Pattern pattern = Pattern.compile("\\{name='(.*?)', venue='(.*?)', date='(.*?)'\\}");
        Matcher matcher = pattern.matcher(data);

        if (matcher.matches()) {
            String name = matcher.group(1);
            String venue = matcher.group(2);
            String date = matcher.group(3);

            try {
                Constructor<T> constructor = null;
                constructor = valueType.getDeclaredConstructor(String.class, String.class, LocalDate.class);
                return constructor.newInstance(name, venue, LocalDate.parse(date));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    @Override
    public void writeToFile(T entity, File file) {
        String txt = serialize(entity);

        try {
            Files.write(file.toPath(), txt.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T readFromFile(File file, Class<T> valueType) {
        String txt = null;
        try {
            txt = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return deserialize(txt, valueType);
    }
}
