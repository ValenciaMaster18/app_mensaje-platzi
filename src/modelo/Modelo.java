package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Modelo {

    //Atributos
    private final String BD;
    private final String USER;
    private final String PASSWORD;
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection conexionMysql;

    //Metodo constructor
    public Modelo(String BD, String USER, String PASSWORD) {
        this.BD = BD;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    //Metetodos de conexion y cerrar conexion de la clase
    public Connection conexionBD() {
        if (conexionMysql == null) {
            try {
                Class.forName(DRIVER);
                conexionMysql = (Connection) DriverManager.getConnection(URL + BD, USER, PASSWORD);
                JOptionPane.showMessageDialog(null, "Conexion exitosa");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Conexion cancelada " + e);
            }
        }
        return conexionMysql;
    }

    public void CerrarBD() throws SQLException {
        if (conexionMysql != null) {
            conexionMysql.close();
            JOptionPane.showMessageDialog(null, "Conexion Cerraada");
        }
    }

    //Get
    public String getBD() {
        return BD;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public Connection getConexionMysql() {
        return conexionMysql;
    }

}
