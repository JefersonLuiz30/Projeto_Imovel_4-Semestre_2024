package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletRequest;

import app.model.Imovel;
import app.service.ImoveisService;
// import javax.management.modelmbean.ModelMBean;

@Controller
public class ImovelController {
    private ImoveisService imovelService = new ImoveisService();

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
        String numero = req.getParameter("numero");
        model.addAttribute("listaImoveis", imovelService.procurar(rua, numero));
        return "listarimoveis";
    }

    @GetMapping("/alterarimovel")
    public String alterar(HttpServletRequest req, Model model) {
        int codigo = Integer.parseInt(req.getParameter("codigo"));
        model.addAttribute("imovel", imovelService.getPorCodigo(codigo));
        return "alterarimovel";
    }

    @PostMapping("/alterarimovel")
    public String alterarImovel(@ModelAttribute("imovel") Imovel imovel, Model model) {
        model.addAttribute("texto", imovelService.salvar(imovel));
        return "mensagem";
    }

    @GetMapping("/excluirimovel")
    public String excluir(HttpServletRequest req, Model model) {
        int codigo = Integer.parseInt(req.getParameter("codigo"));
        model.addAttribute("texto", imovelService.excluir(codigo));
        return "mensagem";
    }

}
