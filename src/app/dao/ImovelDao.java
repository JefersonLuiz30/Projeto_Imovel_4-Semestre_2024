package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.model.Imovel;
import app.singleton.Conexao;

public class ImovelDao {
    private Connection connection;

    public ImovelDao() {
        this.connection = Conexao.getInstancia().getConexao();
    }
    public String salvar(Imovel imovel) {
        String sql = "INSERT INTO imovel (rua, numero, tamanho, valor) "+
        "VALUES ('?, ?, ?, ?')";

        try {
            PreparedStatement ps= this.connection.prepareStatement(sql);
            ps.setString(1, imovel.getRua());
            ps.setString(2, imovel.getNumero());
            ps.setDouble(3, imovel.getTamanho());
            ps.setDouble(4, imovel.getValor());

            ps.execute();
            ps.close();

            return "Imóvel Salvo";


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "Houve um erros";
        }
    }
}