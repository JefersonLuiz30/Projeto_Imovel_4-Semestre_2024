package app.dao;

import app.model.Imovel;
import app.singleton.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// import javax.swing.JOptionPane;

public class ImovelDao {
    private Connection connection;

    public ImovelDao() {
        this.connection = Conexao.getInstancia().getConexao();
    }

    // SALVAR OS DADOS NO BANCO
    public String salvar(Imovel imovel) {
        String sql = "";
        if (imovel.getCodigo() > 0) {
            sql = "UPDATE imovel SET rua=?, numero=?, tamanho=?," + "valor=? WHERE codigo=?";

        } else {
            sql = "INSERT INTO imovel (rua, numero, tamanho, valor) " +
                    "VALUES (?, ?, ?, ?)";
        }

        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, imovel.getRua());
            ps.setString(2, imovel.getNumero());
            ps.setDouble(3, imovel.getTamanho());
            ps.setDouble(4, imovel.getValor());
            if (imovel.getCodigo() > 0)
                ps.setInt(5, imovel.getCodigo());

            ps.execute();
            ps.close();

            return "Imóvel Salvo";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Houve um erros";
        }
    }

    // LISTAR OS DADOS DO BANCO
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
                imovel.setValor(rs.getDouble("Valor"));
                listaImoveis.add(imovel);
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaImoveis;
    }

    // PROCURAR OS DADOS NO BANCO PELO NOME DA RUA E NUMERO DA RUA
    public List<Imovel> procurar(String rua, String numero) {
        List<Imovel> listaImoveis = new ArrayList<>();
        String sql = "SELECT * FROM imovel WHERE rua LIKE ? OR numero LIKE ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + rua + "%"); // Por nome da rua
            ps.setString(2, "%" + numero + "%");// Por numero da rua
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setCodigo(rs.getInt("codigo"));
                imovel.setRua(rs.getString("rua"));
                imovel.setNumero(rs.getString("numero"));
                imovel.setTamanho(rs.getDouble("Tamanho"));
                imovel.setValor(rs.getDouble("Valor"));
                listaImoveis.add(imovel);
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaImoveis;
    }

    // TRAZER OS DADOS PARA SER ALTERADO
    public Imovel getPorCodigo(int codigo) {
        Imovel imovel = new Imovel();
        String sql = "SELECT * FROM imovel WHERE codigo = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                imovel.setCodigo(rs.getInt("codigo"));
                imovel.setRua(rs.getString("rua"));
                imovel.setNumero(rs.getString("numero"));
                imovel.setTamanho(rs.getDouble("tamanho"));
                imovel.setValor(rs.getDouble("valor"));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imovel;
    }

    public String excluir(int codigo) {
        String sql = "DELETE FROM imovel WHERE codigo = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            return "Imovel excluido";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Houve um erro! Tente novamete";
        }
    }

    // public String excluir(int codigo) {
    // // Exibe uma caixa de diálogo para confirmar a exclusão
    // int confirmacao = JOptionPane.showConfirmDialog(
    // null,
    // "Tem certeza que deseja excluir o imóvel com código " + codigo + "?",
    // "Confirmação de Exclusão",
    // JOptionPane.YES_NO_OPTION
    // );

    // // Verifica a resposta do usuário
    // if (confirmacao == JOptionPane.YES_OPTION) {
    // String sql = "DELETE FROM imovel WHERE codigo = ?";
    // try {
    // PreparedStatement ps = connection.prepareStatement(sql);
    // ps.setInt(1, codigo);
    // ps.execute();
    // return "Imóvel excluído com sucesso.";
    // } catch (SQLException e) {
    // e.printStackTrace();
    // return "Houve um erro ao excluir! Tente novamente.";
    // }
    // } else {
    // return "Operação de exclusão cancelada.";
    // }
    // }
}