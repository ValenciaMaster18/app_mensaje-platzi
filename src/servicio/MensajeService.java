package servicio;

import dao.MensajeDAO;
import java.sql.SQLException;
import java.util.Scanner;
import modelo.Mensaje;

public class MensajeService {

    public static void crearMensaje() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje: ");
        String msj = sc.next();
        System.out.println("Escribe tu nombre: ");
        String autor = sc.next();

        Mensaje mensaje = new Mensaje();
        mensaje.setMensaje(msj);
        mensaje.setAutor_mensaje(autor);

        MensajeDAO.crearMensajeBD(mensaje);
    }

    public static void listarMensaje() throws SQLException {
        System.out.println("\nInformacion de la Base de datos\n");
        MensajeDAO.leerMensajeBD();
    }

    public static void borrarMensaje() throws SQLException {
        System.out.println("\nInformacion de la Base de datos\n");
        listarMensaje();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe id: ");
        int id = sc.nextInt();

        MensajeDAO.borrarMensajeBD(id);
    }

    public static void editarMensaje() throws SQLException {
        System.out.println("\nInformacion de la Base de datos\n");
        listarMensaje();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu id a editar: ");
        int id = sc.nextInt();
        System.out.println("Escribe nuevo mensaje: ");
        String msj = sc.next();
        System.out.println("Escribe el nuevo nombre: ");
        String autor = sc.next();

        Mensaje mensaje = new Mensaje();
        mensaje.setId(id);
        mensaje.setMensaje(msj);
        mensaje.setAutor_mensaje(autor);

        MensajeDAO.actualizarMensajeBD(mensaje);
    }
}
