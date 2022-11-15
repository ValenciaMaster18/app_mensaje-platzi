package main;

import java.sql.Connection;
import java.sql.SQLException;
import modelo.Modelo;

public class Main {

    public static void main(String[] args) throws SQLException {
        Modelo conexion = new Modelo("mensaje_app", "root", "");
        try(Connection cnx = conexion.conexionBD()){
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
