package Fila;

public interface Fila {
	    public abstract void enqueue(Object o);
	    public abstract Object dequeue();
	    public Object first();
	    public abstract int size();
	    public abstract boolean isEmpty();
}
