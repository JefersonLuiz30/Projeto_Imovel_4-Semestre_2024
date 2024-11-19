package app.service;

import org.springframework.stereotype.Service;

import app.dao.UsuarioDAO;
import app.model.Usuario;

@Service
public class UsuarioService {
	private UsuarioDAO usuarioDao = new UsuarioDAO(); 

	public String salvar(Usuario usuario) {
		return usuarioDao.salvar(usuario);
	}
	
	public Usuario getUsuarioPorLoginSenha(String login, String senha) {
		return usuarioDao.getUsuarioPorLoginSenha(login, senha);
	}
}
