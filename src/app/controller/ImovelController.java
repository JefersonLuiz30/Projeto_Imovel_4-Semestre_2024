package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletRequest;

import app.model.Imovel;
import app.service.ImovelService;
import javax.management.modelmbean.ModelMBean;

@Controller
public class ImovelController {
    private ImovelService imovelService = new ImovelService();

    @GetMapping("/cadastrarimovel")
    public String cadastrar() {
        return "cadastrarimovel";

    }

    @PostMapping("/cadastrarimovel")
    public String cadastrarImovel(@ModelAttribute("imovel") Imovel imovel, Model model) {
        model.addAttribute("texto", imovelService.salvar(imovel));
        return "mensagem";

    }

    @GetMapping("/listarimoveis")
    public String listar(Model model) {
        model.addAttribute("listaImoveis", imovelService.listar());
        return "listarimoveis";
    }

    @GetMapping("/procurarimoveisrua")
    public String procurar(HttpServletRequest req, Model model) {
        String rua = req.getParameter("descricao");
        model.addAttribute("listaImoveis", imovelService.procurar(rua));
        return "listarimoveis";
    }

<<<<<<< HEAD
    @GetMapping("/alterarimovel")
    public String alterar(HttpServletRequest req, Model model) {
        int codigo = Integer.parseInt(req.getParameter("codigo"));
        model.addAttribute("imovel", imovelService.getPorCodigo(codigo));
        return "alterarimovel";
    }
=======
    @GetMapping("/procurarimoveisnumero")
    public String procurarNum(HttpServletRequest req, Model model) {
        String numero = req.getParameter("descricao");
        model.addAttribute("listaImoveis", imovelService.procurarNum(numero));
        return "listarimoveis";
    }

>>>>>>> df73ff32d7dd716ca7167be92663febc51939c49
}
