package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ServicosController {

    @GetMapping("/servicos")
    public String servicos() {
        return "servicos";
    }
}
