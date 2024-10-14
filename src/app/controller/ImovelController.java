package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import app.service.ImovelService;

@Controller
public class ImovelController {
    private ImovelService imovelService=new ImovelService();

    @GetMapping("/cadastrarimovel")
    public String cadastrar(){
        return "cadastrarimovel";

    }
}
