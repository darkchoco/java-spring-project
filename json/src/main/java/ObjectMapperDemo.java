import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ObjectMapperDemo {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Employee readJsonWithObjectMapper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(new File("employee.json"), Employee.class);
        logger.info(employee.toString());
        return employee;
    }
}
