import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class JsonNodeDemoTest {

    @Test
    public void readJsonWithJsonNode() throws IOException {
        JsonNodeDemo jsonNodeDemo = new JsonNodeDemo();
        JsonNode rootNode = jsonNodeDemo.readJsonWithJsonNode();
        assertThat(rootNode).isNotNull();
        String name = jsonNodeDemo.readNameNode();
        assertThat(name).isEqualTo("Henry Smith");
        Map<String, String> addressMap = jsonNodeDemo.readPersonalInformation();
        assertThat(addressMap.size()).isEqualTo(2);
        Iterator<JsonNode> elements = jsonNodeDemo.readPhoneNumbers();
        assertThat(elements).isNotNull();
    }
}
