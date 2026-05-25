package modelo;

public class Palestra extends Atividade {

    // Sem atributos específicos

    // Construtor

    public Palestra(
        String codigo,
        String titulo,
        int cargaHoraria,
        int capacidadeMaxima,
        Palestrante palestrante
    ) {
        super(codigo, titulo, cargaHoraria, capacidadeMaxima, palestrante);
    }

    // Métodos com override

    @Override
    public double calcularCusto() {
        return 0.0;
    }

    @Override
    public String obterTipoAtividade() {
        return "Palestra";
    }
}
