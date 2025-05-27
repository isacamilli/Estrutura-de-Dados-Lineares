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

        insertBefore(ref, o);

        tamanho++;
    }

    public No first(){
        return inicio.getDepois();
    }

    public No last(){
        return fim.getAntes();
    }

    public No before(No n){
        return n.getAntes();
    }

    public No after(No n){
        return n.getDepois();
    }

    public Object replaceElements(No n, Object o){
        Object x = n.getElemento();
        n.setElemento(o);

        return x;
    }

    public void swapElements(No n, No n2){
        Object x = n.getElemento();
        n.setElemento(n2.getElemento());

        n2.setElemento(x);
    }

    public void insertBefore(No n, Object o){
        No novoNo = new No(o);

        novoNo.setDepois(n);
        novoNo.setAntes(n.getAntes());

        n.getAntes().setDepois(novoNo);
        n.setAntes(novoNo);
    }

    public void insertAfter(No n, Object o){
        No novoNo = new No(o);

        novoNo.setAntes(n);
        novoNo.setDepois(n.getDepois());
        n.getDepois().setAntes(novoNo);
        n.setDepois(novoNo);
    }
}
