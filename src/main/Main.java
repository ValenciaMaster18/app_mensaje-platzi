package main;

import java.sql.SQLException;
import java.util.Scanner;
import servicio.MensajeService;

public class Main {

    static final String menu = "App mensajes "
            + "\n1. Crear mensjae "
            + "\n2. Leer mensaje "
            + "\n3. Actualizar mensaje "
            + "\n4. Eliminar mensaje"
            + "\n5. Salir";

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        do {
            do {
                System.out.println(menu);
                opc = sc.nextInt();
            } while (opc <= 0 || opc > 5);
            switch (opc) {
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensaje();
                    break;
                case 3:
                    MensajeService.editarMensaje();
                    break;
                case 4:
                    MensajeService.borrarMensaje();
                    break;
                case 5:
                    System.out.println("Gracias por utilizar el sistema");
                    break;
            }
        } while (opc != 5);
    }
}
