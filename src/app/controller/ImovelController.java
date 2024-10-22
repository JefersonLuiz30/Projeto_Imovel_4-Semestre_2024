package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import app.model.Imovel;
import app.service.ImovelService;

@Controller
public class ImovelController {
    private ImovelService imovelService = new ImovelService();

    @GetMapping("/cadastrarimovel")
    public String cadastrar(){
        return "cadastrarimovel";

    }

    @PostMapping("/cadastrarimovel")
    public String cadastrarImovel(@ModelAttribute("imovel")Imovel imovel, Model model){
        model.addAttribute("texto", imovelService.salvar(imovel));
        return "mensagem";

    }
}
