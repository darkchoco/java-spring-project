package darkchoco.javaspring.controller;

import darkchoco.javaspring.model.Todo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/basic")
public class BasicController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/todo")
    public Todo basic() {
        return new Todo(counter.incrementAndGet(), "Book the flight");
    }
}
