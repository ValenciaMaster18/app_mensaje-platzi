package dataBases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            } catch (Exception e) {
                System.out.println("Conexion cancelada " + e);
            }
        }
        return conexionMysql;
    }

    public void CerrarBD() throws SQLException {
        if (conexionMysql != null) {
            conexionMysql.close();
            System.out.println("Conexion cerrada");
        }
    }
    //Limpiar base de datos
    private void vaciarBD(){
        String sql = "TRUNCATE mensajes";
        try {
            PreparedStatement ps = conexionMysql.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
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
