package org.example.serialization;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;

public class XmlSerializer<T> implements Serializer<T> {

    private XmlMapper xmlMapper;

    public XmlSerializer() {
        xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        xmlMapper.setDateFormat(dateFormat);
    }

    @Override
    public String serialize(T entity) {
        try {
            return xmlMapper.writeValueAsString(entity);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public T deserialize(String data, Class<T> valueType) {
        try {
            return xmlMapper.readValue(data, valueType);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void writeToFile(T entity, File file) {
        try {
            // Convert the object to XML string
            String xmlString = serialize(entity);

            if (file.exists()) {
                Files.write(file.toPath(), xmlString.getBytes(), StandardOpenOption.WRITE);
            } else {
                Files.write(file.toPath(), xmlString.getBytes(), StandardOpenOption.CREATE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public T readFromFile(File file, Class<T> valueType) {
        try {
            String xmlString = new String(Files.readAllBytes(file.toPath()));

            return deserialize(xmlString, valueType);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
