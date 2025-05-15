package modelo;

public class Orador {
    private int id;
    private String nombre;
    // Para el listado de mejores oradores
    private int puntuacionTotal;

    public Orador() {}

    public Orador(int id, String nombre, int puntuacionTotal) {
        this.id = id;
        this.nombre = nombre;
        this.puntuacionTotal = puntuacionTotal;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPuntuacionTotal() { return puntuacionTotal; }
    public void setPuntuacionTotal(int puntuacionTotal) { this.puntuacionTotal = puntuacionTotal; }
}