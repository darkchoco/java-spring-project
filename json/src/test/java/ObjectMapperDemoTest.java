import domain.Employee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ObjectMapperDemoTest {

    @Test
    void readJsonWithObjectMapper() throws Exception {
        ObjectMapperDemo objectMapperDemo = new ObjectMapperDemo();
        Employee employee = objectMapperDemo.readJsonWithObjectMapper();
        assertThat(employee).isNotNull();
    }
}
