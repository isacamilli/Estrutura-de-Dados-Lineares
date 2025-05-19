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
        if (size() >= capacidade-1){
            if(FC <= 0) capacidade *= 2;
            else capacidade += FC;

            Object[] b = new Object[capacidade];
            int i = inicio;

            for (int f = 0;f < size();f++){
                b[f] = a[i];
                i = (i+1) % capacidade; 
            }
            inicio = 0;
            fim = size();
            a = b;
        }
    }
    
    public int size(){
        int tamanho = (fim - inicio + capacidade)%capacidade;
        return tamanho;
    }
}
