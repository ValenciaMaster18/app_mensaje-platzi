package modelo;

public class Mensaje {
    //Atributos
    private int id;
    private String mensaje;
    private String autor_mensaje;
    private String date;
    private String nombreCompleto;
    
    
    //Constructor 
    public Mensaje(){
        //Vacio
    }
    public Mensaje(String mensaje, String autor_mensaje, String date, String nombreCompleto) {
        this.mensaje = mensaje;
        this.autor_mensaje = autor_mensaje;
        this.date = date;
        this.nombreCompleto = nombreCompleto;
    }

    
    //Get y Set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor_mensaje() {
        return autor_mensaje;
    }

    public void setAutor_mensaje(String autor_mensaje) {
        this.autor_mensaje = autor_mensaje;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    
}
