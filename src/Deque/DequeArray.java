package Deque;

public class DequeArray implements Deque{
    private int capacidade;
    private Object[] a;
    private int inicio;
    private int fim;
    private int FC;

    public DequeArray(int volume, int crescimento){
        capacidade = volume;
        inicio = 0;
        fim = 0;
        a = new Object[capacidade];
        FC = crescimento;
    }

    public void inserirInicio(Object o){
        if (size() >= capacidade - 1){
            if(FC <= 0) capacidade *= 2;
            else capacidade += FC;

            Object[] b = new Object[capacidade];
            int i = inicio;

            for (int f = 0;f < size();f++){
                b[f] = a[i];
                i = (i+1) % a.length; 
            }
            inicio = 0;
            fim = size();
            a = b;
        }
        inicio = (inicio - 1 + capacidade) % capacidade;
        a[inicio] = o;
    }

    public Object removerInicio(){
        Object ref = a[inicio];
        inicio = (inicio + 1) % capacidade;
        return ref;
    }

    public void inserirFim(Object o){
        if (size() >= capacidade - 1){
            if (FC <= 0) capacidade *= 2;
            else capacidade += FC;

            Object[] b = new Object[capacidade];
            int i = inicio;

            for (int f = 0; f < size(); f++){
                b[f] = a[i];
                i = (i + 1) % a.length;
            }
            inicio = 0;
            fim = size();
            a = b;
        }
        a[fim] = o;
        fim = (fim + 1) % capacidade;
    }

    public Object removerFim(){
        Object ref = a[fim];
        fim = (fim - 1 + capacidade) % capacidade;
        return ref;
    }
    
    public int size(){
        int tamanho = (capacidade - inicio + fim)%capacidade;
        return tamanho;
    }

    public Object first(){
        return inicio;
    }

    public Object last(){
        return a[fim-1];
    }

    public boolean isEmpty(){
        return inicio == fim;
    }
}
