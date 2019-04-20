package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexao {

    public static Connection AbrirConexao() {
        Connection con = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/assistenciatecnica";
        String user = "root";
        String password = "";

        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO NA CONEXÃO COM O BANCO",
                    "ASSISTENCIA TECNICA", JOptionPane.ERROR_MESSAGE);
            e.getMessage();

        }
        return con;
    }

    public static void FecharConexao(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
