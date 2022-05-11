class Main {
    public static void main(String[] args) {
        int nAleatorios = 1000;
        int capacidadeFila = 5;
        double tempoGlobal = 0.0;

        Rng r = new Rng(12, 23, 4534535, 65);

        //G/G/1/5, chegadas entre 2..4, atendimento entre 3..5
        //G/G/2/5, chegadas entre 2..4, atendimento entre 3..5

        // (int servidores, int capacidade, int minChegada, int maxChegada, int minServico, int maxServico)
        Fila f1 = new Fila(1, capacidadeFila, 2, 4, 3, 5);
        Fila f2 = new Fila(2, 5, 2, 4, 3, 5);

        Escalonador esc = new Escalonador();

        Evento ev = new Evento(0, 2.0);

        esc.agendaChegada(ev);

        while (true) {
            if (nAleatorios == 0) {
                break;
            } else {
                Evento proxEvento = esc.getFila().poll();

                if (proxEvento.getTipo() == 0) {
                    tempoGlobal = proxEvento.getTempo();
                    f1.setEstado(f1.getEstadoAtualFila(), f1.getEstados()[f1.getEstadoAtualFila()] + tempoGlobal);

                    if (f1.getEstadoAtualFila() < f1.getCapacidade()) {
                        f1.chegadaCliente();

                        if (f1.getEstadoAtualFila() <= 1) {
                            esc.agendaAtendimento(tempoGlobal + r.next());
                            nAleatorios--;
                        }
                    } else {
                        f1.addPerda();
                    }

                    esc.agendaChegada(tempoGlobal + r.next());
                    nAleatorios--;
                } else if (proxEvento.getTipo() == 1) {
                    tempoGlobal = proxEvento.getTempo();
                    f1.setEstado(f1.getEstadoAtualFila(), f1.getEstados()[f1.getEstadoAtualFila()] + tempoGlobal);

                    f1.saidaCliente();

                    f2.setEstado(f2.getEstadoAtualFila(), f2.getEstados()[f2.getEstadoAtualFila()] + tempoGlobal);

                    if (f2.getEstadoAtualFila() < f2.getCapacidade()) {
                        f2.chegadaCliente();
                    } else {
                        f2.addPerda();
                    }

                    if (f1.getEstadoAtualFila() >= 1) {
                        esc.agendaAtendimento(tempoGlobal + r.next());
                        nAleatorios--;
                    }
                }
            }
        }

        System.out.println(f1);
        System.out.println(f2);
    }
}