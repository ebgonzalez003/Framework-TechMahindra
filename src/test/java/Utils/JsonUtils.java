package Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.io.IOException;

public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    // Method to read a JSON file and convert it to a Java object (POJO)
    public static <T> T readJsonFile(String filePath, Class<T> clazz) throws IOException {
        return objectMapper.readValue(new File(filePath), clazz);
    }

    // Method to read a JSON file as a JsonNode (tree structure)
    public static JsonNode readJsonAsTree(String filePath) throws IOException {
        return objectMapper.readTree(new File(filePath));
    }

    // Method to convert a JSON string to a Java object (POJO)
    public static <T> T readJsonFromString(String jsonString, Class<T> clazz) throws JsonProcessingException {
        return objectMapper.readValue(jsonString, clazz);
    }

    // Method to write a Java object to a JSON file
    public static void writeObjectToJsonFile(String filePath, Object object) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), object);
    }

    // Method to convert a Java object to a JSON string
    public static String writeObjectToString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    // Method to get a specific value from JSON using JsonNode
    public static String getJsonValue(JsonNode jsonNode, String key) {
        return jsonNode.get(key).asText();
    }
}
