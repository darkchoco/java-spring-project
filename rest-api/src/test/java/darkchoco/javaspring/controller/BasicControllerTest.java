package darkchoco.javaspring.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class BasicControllerTest {

    @Autowired
    private WebTestClient client;

    @Test
    public void basic() {
        client.get().uri("/basic/todo")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                .expectBody(String.class)
                .consumeWith(exchangeResult -> assertThat(exchangeResult.getResponseBody())
                        .isNotNull()
                        .contains("Book the flight"));
    }

    @Test
    void basicPost() {
        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();

        bodyValues.add("todoTitle", "Book the hotel");

        client.post().uri("/basic/todo-post").body(BodyInserters.fromFormData(bodyValues))
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .consumeWith(stringEntityExchangeResult -> assertThat(stringEntityExchangeResult.getResponseBody())
                        .isNotNull()
                        .contains("Book the hotel"));
    }

    @Test
    void basicPostResponseEntity() {
        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();

        bodyValues.add("todoTitle", "Book the hotel");

        client.post().uri("/basic/todo-post").body(BodyInserters.fromFormData(bodyValues))
                .exchange()
                .expectStatus().isOk();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void getPath(int param) {
        client.get().uri("/basic/todos/" + param)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                .expectBody(String.class)
                .consumeWith(exchangeResult -> {
                    assertThat(exchangeResult.getResponseBody())
                            .isNotNull()
                            .containsAnyOf("flight", "hotel", "itinerary");
                    try {
                        JSONAssert.assertEquals("{id:" + param + "}", exchangeResult.getResponseBody(), false);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                });
    }
}
