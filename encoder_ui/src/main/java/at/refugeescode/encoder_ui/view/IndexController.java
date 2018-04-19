package at.refugeescode.encoder_ui.view;

import at.refugeescode.encoder_ui.controller.Encoder;
import at.refugeescode.encoder_ui.model.Message;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/")
public class IndexController {

    private Encoder encoder;

    public IndexController(Encoder encoder) {
        this.encoder = encoder;
    }

    @ModelAttribute("message")
    Message message() {
        return new Message();
    }

    @ModelAttribute("plain")
    String plain() {
        return encoder.getUserMessage();
    }

    @ModelAttribute("encoded")
    String encoded() {
        return encoder.getEncodedMessage();
    }

    @GetMapping
    String page() {
        return "index";
    }

    @PostMapping
    String post(Message message) {
        encoder.encode(message);
        return ("redirect:/");
    }
}
