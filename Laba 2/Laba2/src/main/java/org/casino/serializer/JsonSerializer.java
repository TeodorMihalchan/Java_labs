package org.casino.serializer;

import org.casino.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonSerializer<T> implements EntitySerializer<T> {
    private final Gson gson;

    public JsonSerializer() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void serialize(T entity, String fileName) throws IOException {
        try (Writer writer = new FileWriter(fileName, StandardCharsets.UTF_8)) {
            gson.toJson(entity, writer);
        }
    }

    @Override
    public T deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (Reader reader = new FileReader(fileName, StandardCharsets.UTF_8)) {
            return (T) gson.fromJson(reader, Player.class); // Здесь указываем класс, который мы ожидаем десериализовать
        }
    }

    @Override
    public void writeToFile(Player player, String fileName) throws IOException {
        serialize((T) player, fileName);
    }

    @Override
    public Player readFromFile(String fileName) throws IOException, ClassNotFoundException {
        return (Player) deserialize(fileName);
    }
}
