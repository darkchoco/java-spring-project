import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ObjectMapperToMapDemo {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void readJsonWithObjectMapper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<?, ?> employeeMap = objectMapper.readValue(new File("employee.json"), Map.class);
        for (Map.Entry<?, ?> entry : employeeMap.entrySet()) {
            logger.info("\n------------------------------\n" + entry.getKey() + " = " + entry.getValue() + "\n");
        }
    }
}
