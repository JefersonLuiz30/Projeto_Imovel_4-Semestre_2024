package app.controller;

// Para conseguir entender
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpresaController {

    @GetMapping("/empresa")
    // para ele devolver o nome do arquivo que ele vai carregar
    public String empresa() {

        // retorna o nome da view
        return "empresa";
    }

}
