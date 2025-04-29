package Fila;

public interface Fila {
	    public abstract void enqueue(Object o);
	    public abstract Object dequeue() throws FilaVaziaException;
	    public Object first() throws FilaVaziaException;
	    public abstract int size();
	    public abstract boolean isEmpty();
}

