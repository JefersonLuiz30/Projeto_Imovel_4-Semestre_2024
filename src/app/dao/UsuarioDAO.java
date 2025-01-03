package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import app.model.Usuario;
import app.security.Hash;
import app.singleton.Conexao;

@Component
public class UsuarioDAO {
	private Connection connection; 
	
	public UsuarioDAO() {
		this.connection = Conexao.getInstancia().getConexao();
	}
	
	public String salvar(Usuario usuario) {
		String sql = " INSERT INTO usuario(nome, login, senha) "+
	                 " VALUES (?, ?, ?) ";
		try {
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			Hash hash = new Hash(); 
			ps.setString(3, hash.gerarHash(usuario.getSenha()));
			ps.execute();
			ps.close();
			return "Usuario gravado!";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Erro: "+ e.getMessage();
		}
	}
	
	public Usuario getUsuarioPorLoginSenha(String login, String senha) {
		String sql = " SELECT * FROM usuario "+
	                 " WHERE login = ? AND senha = ? ";
		try {
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.setString(1, login);
			Hash hash = new Hash();
			ps.setString(2, hash.gerarHash(senha));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setCodigo(rs.getInt("codigo"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				return usuario;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
