package app.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Conexao instancia;
    private Connection connection;
    private String drive = "com.mysql.jdbc.Driver";
    private String url = "jdbc.mysql://localhost/dbds2imovel";
    private String usuario = "root";
    private String senha = "";

    public Connection getConexao() {
        try {
            Class.forName(drive);
            this.connection = DriverManager.getConnection(url, usuario, senha);
            return this.connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized Conexao getInstancia() {
        if (instancia == null) {
            instancia = new Conexao();
        }
        return instancia;
    }
}
