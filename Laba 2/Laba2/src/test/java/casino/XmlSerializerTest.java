package casino;

import org.casino.Player;
import org.casino.serializer.XmlSerializer;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class XmlSerializerTest {
    private XmlSerializer serializer;
    private final String testFileName = "test_player.xml";

    @BeforeClass
    public void setUp() {
        serializer = new XmlSerializer();
    }

    @Test
    public void testSerializationOfDifferentPlayers() throws IOException {
        Player player = new Player.Builder("Bob").balance(500.0).vip(false).build();
        serializer.writeToFile(player, testFileName);
        Assert.assertTrue(new File(testFileName).exists(), "File should be created for different player.");
    }

    @Test(expectedExceptions = IOException.class)
    public void testDeserializationOfNonExistentFile() throws IOException, ClassNotFoundException {
        serializer.readFromFile("non_existent_file.xml");
    }

    @Test
    public void testDeserializationOfMalformedXML() {
        // You need to manually create a malformed XML file for this test
        Assert.expectThrows(IOException.class, () -> {
            serializer.readFromFile("malformed_test_player.xml");
        });
    }

    @Test
    public void testNegativeBalanceSerialization() throws IOException {
        Player player = new Player.Builder("Charlie").balance(-100.0).vip(true).build();
        serializer.writeToFile(player, testFileName);
        Assert.assertTrue(new File(testFileName).exists(), "File should be created even with negative balance.");
    }

    @AfterMethod
    public void cleanUp() {
        new File(testFileName).delete();
    }
}
