package Vetor;

public interface Vetor {
    public Object elemAtRank(int p);
    public Object replaceAtRank(int p, Object o);
    public void insertAtRank(int p, Object o);
    public Object removeAtRank(int p);
    public int size();
    public boolean isEmpty();
}               