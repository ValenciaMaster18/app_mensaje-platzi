package dao;

import dataBases.Modelo;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Mensaje;

public class MensajeDAO {

    public static void crearMensajeBD(Mensaje mensaje) throws SQLException {
        Modelo conexion = new Modelo("mensaje_app", "root", "");
        try ( Connection cnx = conexion.conexionBD()) {
            PreparedStatement ps = null;
            try {
                String sql = "INSERT INTO mensajes (mensaje,autor_mensaje) VALUES (?,?)";
                ps = cnx.prepareStatement(sql);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();

                conexion.CerrarBD();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void leerMensajeBD() throws SQLException {
        Modelo conexion = new Modelo("mensaje_app", "root", "");
        try ( Connection cnx = conexion.conexionBD()) {
            PreparedStatement ps = null;
            try {
                String sql = "SELECT * FROM mensajes";
                ps = cnx.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id_mensaje");
                    String mensaje = rs.getString("mensaje");
                    String autor = rs.getString("autor_mensaje");
                    String fecha = rs.getString("fecha_mensaje");

                    System.out.println(id + "  " + mensaje + "  " + "  " + autor + "  " + fecha);
                }

                conexion.CerrarBD();
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void borrarMensajeBD(int id_mensaje) {
        Modelo conexion = new Modelo("mensaje_app", "root", "");
        try ( Connection cnx = conexion.conexionBD()) {
            PreparedStatement ps = null;
            try {
                String sql = "DELETE FROM mensajes WHERE id_mensaje='" + id_mensaje + "'";
                ps = cnx.prepareStatement(sql);
                ps.executeUpdate();

                conexion.CerrarBD();
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void actualizarMensajeBD(Mensaje mensaje) throws SQLException {
        Modelo conexion = new Modelo("mensaje_app", "root", "");
        try ( Connection cnx = conexion.conexionBD()) {
            PreparedStatement ps = null;
            try {
                String sql = "UPDATE mensajes SET mensaje = ?,autor_mensaje = ? WHERE id_mensaje = ?";
                ps = cnx.prepareStatement(sql);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.setInt(3, mensaje.getId());
                ps.executeUpdate();

                conexion.CerrarBD();
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
