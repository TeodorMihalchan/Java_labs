package org.casino.serializer;

import org.casino.Player;

import java.io.*;

public class PlayerTxtSerializer implements EntitySerializer<Player> {

    public void writeToFile(Player player, String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(player);
        }
    }


    public Player readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Player) inputStream.readObject();
        }
    }

    @Override
    public void serialize(Player player, String fileName) throws IOException {
        writeToFile(player, fileName);
    }

    @Override
    public Player deserialize(String fileName) throws IOException, ClassNotFoundException {
        return readFromFile(fileName);
    }
}
