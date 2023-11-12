package org.example.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class JsonSerializer<T> implements Serializer<T> {

    private ObjectMapper objectMapper;

    public JsonSerializer() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String serialize(T entity) {
        try {
            return objectMapper.writeValueAsString(entity);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public T deserialize(String data, Class<T> valueType) {
        try {
            return objectMapper.readValue(data, valueType);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void writeToFile(T entity, File file) {
        try {
            String jsonString = serialize(entity);

            if (file.exists()) {
                Files.write(file.toPath(), jsonString.getBytes(), StandardOpenOption.WRITE);
            } else {
                Files.write(file.toPath(), jsonString.getBytes(), StandardOpenOption.CREATE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public T readFromFile(File file, Class<T> valueType) {
        try {
            String jsonString = new String(Files.readAllBytes(file.toPath()));

            return deserialize(jsonString, valueType);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}