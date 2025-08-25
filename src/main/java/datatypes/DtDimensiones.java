package datatypes;

public class DtDimensiones{
    private int alto;
    private int largo;
    private int ancho;

    public DtDimensiones() {
        this.alto = 0;
        this.largo = 0;
        this.ancho = 0;
    }

    public DtDimensiones(int alto, int largo, int ancho) {
        this.alto = alto;
        this.largo = largo;
        this.ancho = ancho;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getLargo() {
        return largo;
    }

    public int getAncho() {
        return ancho;
    }
}