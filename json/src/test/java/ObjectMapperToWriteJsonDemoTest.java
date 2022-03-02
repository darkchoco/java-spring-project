import domain.Address;
import domain.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ObjectMapperToWriteJsonDemoTest {

    Employee employee = new Employee();

    @BeforeEach
    public void setUpEmployee() {
        Address address = new Address();

        address.setStreet("Lake Park Road");
        address.setCity("Phoenix");
        address.setZipcode(85003);
        employee.setId(124);
        employee.setName("Alice Celci");
        employee.setAge(24);
        employee.setSalary(new BigDecimal(1800));
        employee.setDesignation("UI Designer");
        employee.setAddress(address);
        employee.setPhoneNumbers(new long[]{246802});
        Map<String, String> infoMap = new HashMap<>();
        infoMap.put("gender", "Female");
        infoMap.put("maritialstatus", "Unmarried");
        employee.setPersonalInformation(infoMap);
    }

    @Test
    void writeEmployeeToJson() {
        ObjectMapperToWriteJsonDemo objectMapperToWriteJsonDemo = new ObjectMapperToWriteJsonDemo();
        objectMapperToWriteJsonDemo.writeEmployeeToJson(employee);
    }
}
