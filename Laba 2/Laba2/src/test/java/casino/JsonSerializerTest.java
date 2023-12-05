package casino;

import org.casino.Player;
import org.casino.serializer.JsonSerializer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class JsonSerializerTest {
    private JsonSerializer<Player> serializer;
    private Player testPlayer;

    @BeforeClass
    public void setUp() {
        serializer = new JsonSerializer<>();
        testPlayer = new Player.Builder("TestPlayer")
                .balance(100.0)
                .vip(true)
                .build();
    }

    @Test
    public void testSerializeAndDeserialize() {
        String fileName = "testPlayer.json";

        try {
            // ��������� ������ � �������� ���� � ����
            serializer.serialize(testPlayer, fileName);

            // ����������� ������ � �����
            Player deserializedPlayer = serializer.deserialize(fileName);

            // ����������, �� ��'��� deserializedPlayer ������� ��������� ������
            assertEquals(testPlayer, deserializedPlayer);
        } catch (IOException | ClassNotFoundException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testWriteAndReadFromFile() {
        String fileName = "testPlayer.json";

        try {
            // �������� ������ � ����
            serializer.writeToFile(testPlayer, fileName);

            // ������� ������ � �����
            Player readPlayer = serializer.readFromFile(fileName);

            // ����������, �� ��'��� readPlayer ������� ��������� ������
            assertEquals(testPlayer, readPlayer);
        } catch (IOException | ClassNotFoundException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
