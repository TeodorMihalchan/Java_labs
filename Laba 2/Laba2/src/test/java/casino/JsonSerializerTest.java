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
            // —ер≥ал≥зуЇмо гравц€ ≥ записуЇмо його у файл
            serializer.serialize(testPlayer, fileName);

            // ƒесер≥ал≥зуЇмо гравц€ з файлу
            Player deserializedPlayer = serializer.deserialize(fileName);

            // ѕерев≥р€Їмо, чи об'Їкт deserializedPlayer дор≥внюЇ тестовому гравцю
            assertEquals(testPlayer, deserializedPlayer);
        } catch (IOException | ClassNotFoundException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testWriteAndReadFromFile() {
        String fileName = "testPlayer.json";

        try {
            // «аписуЇмо гравц€ у файл
            serializer.writeToFile(testPlayer, fileName);

            // «читуЇмо гравц€ з файлу
            Player readPlayer = serializer.readFromFile(fileName);

            // ѕерев≥р€Їмо, чи об'Їкт readPlayer дор≥внюЇ тестовому гравцю
            assertEquals(testPlayer, readPlayer);
        } catch (IOException | ClassNotFoundException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
