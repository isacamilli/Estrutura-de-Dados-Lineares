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

    public Object elemAtRank(int p)    {
        No n = atRank(p);
        return n.getElemento();
    }

    public No atRank(int r){
        No node;
        if (r <= size()/2){
            node = inicio.getDepois();
            for(int i = 0;i < r;i++){
                node = node.getDepois();
            }
        }
        else{
            node = fim.getAntes();
            for(int i=0;i<size()-r-1;i++){
                node = node.getAntes();
            }
        }
        return node;
    }

    public int rankOf(No n){
        No ref = inicio.getDepois();
        int p = 0;

        while (ref != n && n != fim) {
            ref = ref.getDepois();
            p++;
        }
        return p;
    }

    public Object replaceAtRank(int r, Object o){
        No novoNo = atRank(r);
        Object ref = novoNo.getElemento();
        novoNo.setElemento(o);

        return ref;
    }

    public void insertAtRank(int r, Object o){
        No ref = atRank(r);
        No novoNo = new No(o);

        novoNo.setAntes(ref.getAntes());
        novoNo.setDepois(ref);

        ref.getAntes().setDepois(novoNo);
        ref.setAntes(novoNo);

        tamanho++;
    }

    public No first(){
        return inicio.getDepois();
    }

    public No last(){
        return fim.getAntes();
    }
}
