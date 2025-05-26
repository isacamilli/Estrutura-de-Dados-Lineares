package Sequencia;
import Lista.No;

public class Sequencia {
    private int tamanho;
    private No inicio;
    private No fim;

    public Sequencia(){
        this.tamanho = 0;
        inicio = new No(null);
        fim = new No(null);

        inicio.setDepois(fim);
        fim.setAntes(inicio);
    }

    public int size(){
        return tamanho;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    
}
