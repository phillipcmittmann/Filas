public class Main {
    public static void main(String[] args) {
        int tamanho = 5;
        double tempo = 0;
        double[] estados = new double[tamanho + 1];

        Rng r = new Rng(12,23,456465,65);

        Fila fila = new Fila();

        Escalonador escalonador = new Escalonador(tamanho);

        escalonador.agendaChegada(2);

        for (int i=1; i<100000; i++) {
            escalonador.sort();

            if (fila.getSize() < tamanho) {
                tempo = escalonador.nextTempo();
                estados[fila.getSize()] = tempo - escalonador.nextTempo();
                fila.chegada();
                escalonador.pop();

                if (fila.getSize() <= 1) {
                    escalonador.agendaSaida(tempo + r.next());
                }

                escalonador.agendaChegada(tempo + r.next());
            }
        }
    }
}