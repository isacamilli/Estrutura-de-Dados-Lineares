public class PilhaArray implements Pilha{
    private int capacidade;
    private Object[] a;
    private int t;
    private int FC;
    public PilhaArray(int capacidade, int crescimento){
        this.capacidade = capacidade;
        t = -1;
        FC = crescimento;
        if (crescimento <= 0){FC = 0;}
        a = new Object[capacidade];
    }

    public void push(Object o){
        if (t >= capacidade - 1){
            if (FC == 0) {
                capacidade*=2; 
            }
            else{
                capacidade += FC;
            }

            Object b[] = new Object[capacidade];
            for (int f=0;f<a.length;f++){
                b[f] = a[f];
            }
            a = b;
        }
        a[++t] = o;
    }

    public Object pop() throws PilhaVaziaExcecao {
        if (isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        Object r = a[t--];
        return r;
    }

    public object top() throws PilhaVaziaExcecao{
        if (isEmpty()){
            
        }
    }
}
