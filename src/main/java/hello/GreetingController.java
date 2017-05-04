package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, @RequestParam(value="email", required=false, defaultValue="example@example.com") String email,  Model model) {
        System.out.println("!!!\n!!!\nname is: " +name);
        System.out.println("!!!\n!!!\nemail is: " +email);
        model.addAttribute("name", name);
        model.addAttribute("emaill", email);
        return "greeting";
    }

    @ResponseBody
    @RequestMapping("/greet")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

}