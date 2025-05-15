package modelo;

public class PuntuacionOrador {
    private int id;
    private int idOrador;
    private int puntuacion;
    private int idFase;
    private String detalle;

    public PuntuacionOrador() {}

    public PuntuacionOrador(int id, int idOrador, int puntuacion, int idFase, String detalle) {
        this.id = id;
        this.idOrador = idOrador;
        this.puntuacion = puntuacion;
        this.idFase = idFase;
        this.detalle = detalle;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdOrador() { return idOrador; }
    public void setIdOrador(int idOrador) { this.idOrador = idOrador; }

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }

    public int getIdFase() { return idFase; }
    public void setIdFase(int idFase) { this.idFase = idFase; }

    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }
}