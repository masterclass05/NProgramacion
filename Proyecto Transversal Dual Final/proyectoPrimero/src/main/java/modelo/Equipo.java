package modelo;

public class Equipo {
    private int id;
    private String nombre;
    private int idFase;
    private boolean clasificado;

    public Equipo() {}

    public Equipo(int id, String nombre, int idFase, boolean clasificado) {
        this.id = id;
        this.nombre = nombre;
        this.idFase = idFase;
        this.clasificado = clasificado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getIdFase() { return idFase; }
    public void setIdFase(int idFase) { this.idFase = idFase; }

    public boolean isClasificado() { return clasificado; }
    public void setClasificado(boolean clasificado) { this.clasificado = clasificado; }
}
