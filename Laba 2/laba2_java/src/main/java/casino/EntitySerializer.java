package casino;

import java.io.IOException;

public interface EntitySerializer<T> {
    String serialize(T entity) throws IOException;
    T deserialize(String serializedData, Class<T> clazz) throws IOException;
    void writeToFile(T entity, String filename) throws IOException;
    T readFromFile(String filename, Class<T> clazz) throws IOException;
}
