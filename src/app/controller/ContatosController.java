package app.controller;

import java.util.ArrayList;
// Criar lista 
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ContatosController {

    @GetMapping("contatos")
    public String contatos(Model model) {

        // Criar lista
        List<String> listaContatos = new ArrayList<>();
        listaContatos.add("Comercial: (16)3252-1111");
        listaContatos.add("Suporte: (16)3252-2222");
        listaContatos.add("Financeiro: (16)3252-3333");
        model.addAttribute("listaContatos", listaContatos);
        
        return "contatos";

    }
}
