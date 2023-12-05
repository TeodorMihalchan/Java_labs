package casino;

import org.casino.Player;
import org.casino.serializer.PlayerTxtSerializer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.io.*;

public class PlayerTxtSerializerTest {
    private Player player;
    private PlayerTxtSerializer serializer;
    private String fileName = "player.txt";

    @BeforeClass
    public void setUp() {

        player = new Player.Builder("Alice")
                .balance(1000.0)
                .vip(true)
                .build();


        serializer = new PlayerTxtSerializer();
    }

    @Test
    public void testSerializeAndDeserialize() {
        try {

            serializer.serialize(player, fileName);


            Player deserializedPlayer = serializer.deserialize(fileName);


            assertEquals(player, deserializedPlayer);
        } catch (IOException | ClassNotFoundException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testWriteAndReadToFile() {
        try {

            serializer.writeToFile(player, fileName);


            Player readPlayer = serializer.readFromFile(fileName);


            assertEquals(player, readPlayer);
        } catch (IOException | ClassNotFoundException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(expectedExceptions = FileNotFoundException.class)
    public void testSerializeAndDeserializeNonExistentFile() throws IOException, ClassNotFoundException {

        serializer.deserialize("non_existent_file.txt");
    }
}
