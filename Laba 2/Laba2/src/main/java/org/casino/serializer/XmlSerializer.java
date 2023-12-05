package org.casino.serializer;

import org.casino.Player;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class XmlSerializer implements EntitySerializer<Player> {

    private final XmlMapper xmlMapper;

    public XmlSerializer() {
        this.xmlMapper = new XmlMapper();
    }

    @Override
    public void serialize(Player entity, String fileName) throws IOException {
        xmlMapper.writeValue(new File(fileName), entity);
    }

    @Override
    public Player deserialize(String fileName) throws IOException, ClassNotFoundException {
        return xmlMapper.readValue(new File(fileName), Player.class);
    }

    @Override
    public void writeToFile(Player player, String fileName) throws IOException {
        serialize(player, fileName);
    }

    @Override
    public Player readFromFile(String fileName) throws IOException, ClassNotFoundException {
        return deserialize(fileName);
    }
}
