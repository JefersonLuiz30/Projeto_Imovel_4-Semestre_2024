package app.dao;

import app.model.Imovel;
import app.singleton.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImovelDao {
    private Connection connection;

    public ImovelDao() {
        this.connection = Conexao.getInstancia().getConexao();
    }

    public String salvar(Imovel imovel) {
        String sql = "INSERT INTO imovel (rua, numero, tamanho, valor) " +
                "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
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

    public List<Imovel> listar() {
        List<Imovel> listaImoveis = new ArrayList<>();
        String sql = "SELECT * FROM imovel";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setCodigo(rs.getInt("codigo"));
                imovel.setRua(rs.getString("rua"));
                imovel.setNumero(rs.getString("numero"));
                imovel.setTamanho(rs.getDouble("Tamanho"));
                listaImoveis.add(imovel);
            }
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaImoveis;
    }

    public List<Imovel> procurar(String rua) {
        List<Imovel> listaImoveis = new ArrayList<>();
        String sql = "SELECT * FROM imovel WHERE rua LIKE ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + rua + "%"); //Rua prudente de moraes
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setCodigo(rs.getInt("codigo"));
                imovel.setRua(rs.getString("rua"));
                imovel.setNumero(rs.getString("numero"));
                imovel.setTamanho(rs.getDouble("Tamanho"));
                listaImoveis.add(imovel);
            }
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaImoveis;
    }
}