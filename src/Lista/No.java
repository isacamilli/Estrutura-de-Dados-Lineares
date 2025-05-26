package Lista;

public class No {
    private Object elemento;
    private No antes;
    private No depois;

    public No(Object o){
        this.elemento = o;
        this.antes = null;
        this.depois = null;
    }
    
    public Object getElemento(){
        return this.elemento;
    }

    public void setElemento(Object o){
        this.elemento = o;
    }

    public No getAntes(){
        return antes;
    }

    public void setAntes(No o){
        this.antes = o;
    }

    public No getDepois(){
        return depois;
    }

    public void setDepois(No o){
        this.depois = o;
    }
}