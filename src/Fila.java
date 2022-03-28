public class Fila {
    private int fila;

    public Fila () {
        this.fila = 0;
    }

    public int getSize() {
        return fila;
    }

    public void chegada() {
        this.fila++;
    }

    public void saida() {
        this.fila--;
    }
}
