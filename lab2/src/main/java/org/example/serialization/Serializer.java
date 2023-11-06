package org.example.serialization;

import java.io.File;

public interface Serializer<T> {
    /**
     * Serialization to String
     */
    String serialize(T entity);

    /**
     * Deserialization from String
     */
    T deserialize(String data);

    /**
     * Write serialized data to file
     */
    void writeToFile(T entity, File file);

    /**
     * Read serialized data from file
     */
    T readFromFile(File file);
}
