package Lista;

public class Lista {
    private int tamanho;
    private No inicio;
    private No fim;

    public Lista(){
        this.inicio = new No(null);
        this.fim = new No(null);
        this.tamanho = 0;
        inicio.setDepois(fim);
        fim.setAntes(inicio);
    }

    public int size(){
        return this.tamanho;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    public boolean isFirst(No n){
        if (isEmpty()) throw new ListaVaziaExcecao("Lista vazia");
        else return n.getAntes() == inicio;
    }

    public boolean isLast(No n){
        if (isEmpty()) throw new ListaVaziaExcecao("Lista vazia");
        else return n.getDepois() == fim;
    }

    public No first(){
        if (isEmpty()) throw new ListaVaziaExcecao("Lista vazia");
        else return inicio.getDepois();
    }

    public No last(){
        if (isEmpty()) throw new ListaVaziaExcecao("Lista vazia");
        else return fim.getAntes();
    }

    public No before(No p){
        if (isEmpty()) throw new ListaVaziaExcecao("Lista vazia");
        else return p.getAntes();
    }

    public No after(No p){
        if (isEmpty()) throw new ListaVaziaExcecao("Lista vazia");
        else return p.getDepois();
    }

    public Object replaceElement(No n, Object o){
        Object antigo = n.getElemento();
        n.setElemento(o);
        return antigo;
    }

    public void swapElement(No n, No n2){
        Object ref = n.getElemento();
        n.setElemento(n2);
        n2.setElemento(ref);
    }

    public void insertBefore(No n, Object o){
        No novoNo = new No(o);

        novoNo.setAntes(n.getAntes());
        novoNo.setDepois(n);

        n.getAntes().setDepois(novoNo);
        n.setAntes(novoNo);

        tamanho++;
    }

    public void insertAfter(No n, Object o){
        No novoNo = new No(o);

        novoNo.setAntes(n);
        novoNo.setDepois(n.getDepois());

        n.getDepois().setAntes(novoNo);
        n.setDepois(novoNo);

        tamanho++;
    }

    public void insertFirst(Object o){
        No novoNo = new No(o);

        novoNo.setAntes(inicio);
        novoNo.setDepois(inicio.getDepois());

        inicio.getDepois().setAntes(novoNo);
        inicio.setDepois(novoNo);

        tamanho++;
    }

    public void insertLast(Object o){
        No novoNo = new No(o);

        novoNo.setDepois(fim);
        novoNo.setAntes(fim.getAntes());

        fim.getAntes().setDepois(novoNo);
        fim.setAntes(novoNo);
    }

    public Object remove(No p){
        Object t = p.getElemento();

        p.getAntes().setDepois(p.getDepois());
        p.getDepois().setAntes(p.getAntes());

        p.setAntes(null);
        p.setDepois(null);
        
        return t;
    }
}
