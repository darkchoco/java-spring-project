package darkchoco.javaspring.controller;

import darkchoco.javaspring.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/basic")
public class BasicController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/todo")
    public Todo basic() {
        return new Todo(counter.incrementAndGet(), "Book the flight");
    }

    @PostMapping(value = "/todo-post")
    public Todo basicPost(@RequestParam(value = "todoTitle") String todoTitle) {
        return new Todo(counter.incrementAndGet(), todoTitle);
    }

    @PostMapping(value = "/todo-entity")
    public ResponseEntity<Todo> basicPostResponseEntity(
            @RequestParam(value = "todoTitle") String todoTitle) {
        return new ResponseEntity<>(
                new Todo(counter.incrementAndGet(), todoTitle), HttpStatus.CREATED);
    }

    @GetMapping(value = "/todos/{todoId}")
    public Todo getPath(@PathVariable int todoId) {
        Map<Integer, Todo> todoMap =
                Map.of(1, new Todo(1L, "Book the flight"),
                       2, new Todo(2L, "Book the hotel"),
                       3, new Todo(3L, "Check the itinerary"));

        return todoMap.get(todoId);
    }
}
