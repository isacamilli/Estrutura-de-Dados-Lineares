package Arvores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Arvore {

    private No root;
    private int quantidade;

    public Arvore(Object o){
        this.root = new No(null, o);
        this.quantidade = 1;
    }

    public int size(){
        return this.quantidade;
    }

    public int height(){
        return altura(this.root);
    }

    public Iterator<Object> elements(){
        ArrayList<Object> lista = new ArrayList<>();
        preOrder(this.root, lista);
        return lista.iterator();
    }

    public Iterator<No> nos(){
        ArrayList<No> lista = new ArrayList<>();
        preOrderNos(this.root, lista);
        return lista.iterator();
    }

    public No root(){
        return this.root;
    }

    public No parent(No n){
        return n.parent();
    }

    public Iterator children(No n){
        return n.getChildren().iterator();
    }

    public boolean isInternal(No n){
        return n.childrenNumber() != 0;
    }

    public boolean isExternal(No n){
        return n.childrenNumber() == 0;
    }

    public boolean isRoot(No n){
        return n == this.root;
    }

    public int depth(No n){
        if (isRoot(n)) return 0;
        
        return 1+depth(n.parent());
    }

    public boolean isEmpty(){
        return false;
    }

    public void preOrder(No n, ArrayList<Object> lista){
        lista.add(n.element());
        for (No filho: n.getChildren()){
            preOrder(filho, lista);
        }
    }

    public void postOrder(No n, ArrayList<Object> lista){
        for (No filho: n.getChildren()){
            postOrder(filho, lista);
        }
        lista.add(n.element());
    }

    private void preOrderNos(No n, ArrayList<No> lista){
        lista.add(n);
        for (No filho: n.getChildren()){
            preOrderNos(filho, lista);
        }
    }

    private int altura(No n){
        if (isExternal(n)){
            return 0;
        }

        int h = 0;

        for(No filho: n.getChildren()){
            h = Math.max(h, altura(filho));
        }
        return 1 + h;
    }

    // Início classe No

    public class No{
        private Object chave;
        private No pai;
        private ArrayList<No> filhos = new ArrayList();

        public No(No pai, Object o){
            this.pai = pai;
            this.chave = o;
        }

        public Object element(){
            return this.chave;
        }

        public No parent(){
            return this.pai;
        }

        public ArrayList<No> getChildren(){
            return this.filhos;
        }

        public void addChild(No n){
            this.filhos.add(n);
        }

        public void removeChild(No n){
            this.filhos.remove(n);
        }

        public int childrenNumber(){
            return this.filhos.size();
        }

    }
}