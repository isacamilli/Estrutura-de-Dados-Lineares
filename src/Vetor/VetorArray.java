package Vetor;

public class VetorArray implements Vetor{
    private Object[] a;
    private int n;
    private int capacidade;
    private int FC;

    public VetorArray(int cap, int cresc){
        capacidade = cap;
        a = new Object[capacidade];
        n = 0;
        FC = cresc;
    }

    public Object elemAtRank(int p){
        return a[p];
    }

    public Object replaceAtRank(int p, Object o){
        Object ref = a[p];
        a[p] = o;
        return ref;
    }

    public void insertAtRank(int p, Object o){
        if (n >= capacidade){
            if (FC <= 0) capacidade *= 2;
            else capacidade += FC;
            Object[] b = new Object[capacidade];

            for (int i=0;i < n; i++){
                b[i] = a[i];
            }

            a = b;
        }
        for (int i = n-1;i > p; i--){
            a[i+1] = a[i];
        }
        a[p] = o;
        n++;
    }

    public Object removeAtRank(int p){
        Object ref = a[p];
        for (int i = p;i<n-1; i++){
            a[i] = a[i+1];
        }
        a[n-1]= null;
        n--;
        return ref;
    }

    public boolean isEmpty(){
        return n==0;
    }

    public int size(){
        return n;
    }
}
