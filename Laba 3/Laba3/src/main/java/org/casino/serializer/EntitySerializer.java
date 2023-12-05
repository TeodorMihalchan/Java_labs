package org.casino.serializer;

import org.casino.Player;

import java.io.IOException;

public interface EntitySerializer<T> {
    void serialize(T entity, String fileName) throws IOException;
    T deserialize(String fileName) throws IOException, ClassNotFoundException;

    public void writeToFile(Player player, String fileName) throws IOException;

    public Player readFromFile(String fileName) throws IOException, ClassNotFoundException;


}
