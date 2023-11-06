package org.example;

import org.example.serialization.JsonSerializer;

public class Main {
    public static void main(String[] args) {
        JsonSerializer<String> ser = new JsonSerializer<String>();
        ser.serialize("sadf");
    }
}