package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import app.model.Usuario;
import app.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UsuarioController {
	
	private UsuarioService usuarioService = new UsuarioService(); 	

	@GetMapping("/cadastrarusuario")
	public String cadastroUsuario(Model model) {
		return "cadastrousuario";
	}
	
	@PostMapping("/cadastrarusuario")
	public String cadastrarUsuario(HttpServletRequest req, Model model) {
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);	
		model.addAttribute("texto", usuarioService.salvar(usuario));
		return "mensagem";
	}
	
	@GetMapping("/loginusuario")
	public String loginUsuario(Model model) {
		return "login";
	}
	
	@PostMapping("/loginusuario")
	public String efetuarLoginUsuario(HttpServletRequest req, Model model) {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario usuario = usuarioService.getUsuarioPorLoginSenha(login, senha);
		if (usuario != null) {
			req.getSession().setAttribute("usuario", usuario);
			model.addAttribute("texto", "Login efetuado!");
		} else {
			model.addAttribute("texto", "Login e/ou senha incorretos!");
		}
		return "mensagem";
	}
	
	@GetMapping("/logoutusuario")
	public String efetuarLogoutUsuario(HttpServletRequest req, Model model) {
		req.getSession().invalidate();
		model.addAttribute("texto", "Logout efetuado!");
		return "mensagem";
	}
}
