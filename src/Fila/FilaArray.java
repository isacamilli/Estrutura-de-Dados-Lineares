package Fila;

public class FilaArray implements Fila {
    private int capacidade;
    private Object[] a;
    private int comeco;
    private int fim;
    private int FC;

    public FilaArray(int volume,int cresc) {
        capacidade = volume;
        comeco = 0;
        fim = 0;
        FC = cresc;
        a = new Object[capacidade];
    }

    public void enqueue(Object o){
        if (size() >= capacidade - 1) {
            if (FC <= 0) {
                capacidade *= 2;
            }
            else {
                capacidade += FC;
            }

            Object[] b = new Object[capacidade];
            int i = comeco; 
    
            for (int f = 0;f < size();f++){
                b[f] = a[i];
                i = (i+1) % a.length;
            }
            a = b;
            fim = size();
            comeco = 0;
        }

        a[fim] = o;
        fim = (fim + 1) % capacidade;
    }

    public Object dequeue() throws FilaVaziaException{
        if(isEmpty()) throw new FilaVaziaException("A fila está vazia");
        Object o = a[comeco];
        comeco = (comeco + 1) % capacidade;

        return o;
    }

    public Object first() throws FilaVaziaException{
        if (isEmpty()) throw new FilaVaziaException("A fila está vazia");

        return a[comeco];
    }

    public boolean isEmpty(){
        return comeco == fim;
    }

    public int size(){
        return (capacidade -comeco + fim) % capacidade;
    }
}
