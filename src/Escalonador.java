import java.util.ArrayList;
import java.util.Arrays;

public class Escalonador {
    private Evento[] eventos;
    private double[] tempo;
    private int nextIndex;

    public Escalonador(int tamanho) {
        eventos = new Evento[tamanho];
        tempo = new double[tamanho];
        nextIndex = 0;
    }

    public void agendaChegada(double tempo) {
        this.eventos[nextIndex] = Evento.CHEGADA;
        this.tempo[nextIndex] = tempo;
        nextIndex++;
    }

    public void agendaSaida(double tempo) {
        this.eventos[nextIndex] = Evento.SAIDA;
        this.tempo[nextIndex] = tempo;
        nextIndex--;
    }

    public Evento nextEvento() {
        return this.eventos[0];
    }

    public double nextTempo() {
        return this.tempo[0];
    }

    public void pop() {
        this.eventos = Arrays.copyOfRange(this.eventos, 1, this.eventos.length);
        this.tempo = Arrays.copyOfRange(this.tempo, 1, this.tempo.length);
        nextIndex--;
    }

    public void sort() {
        for (int i = 0; i <= this.eventos.length - 1; i++) {
            for (int j = i + 1; j < this.eventos.length - 1; j++) {
                if (this.tempo[i] > this.tempo[j]) {
                    double tempTempo = this.tempo[i];
                    this.tempo[i] = this.tempo[j];
                    this.tempo[j] = tempTempo;

                    Evento tempEvento = this.eventos[i];
                    this.eventos[i] = this.eventos[j];
                    this.eventos[j] = tempEvento;
                }
            }
        }
    }
}
