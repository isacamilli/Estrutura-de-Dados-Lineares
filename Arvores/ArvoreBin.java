package Arvores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class ArvoreBin {

    private No root;
    private int quantidade;

    public ArvoreBin(Object o){
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
        return n.getLeft() != null || n.getRight() != null;
    }

    public boolean isExternal(No n){
        return n.getLeft() == null && n.getRight() == null;
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

    public void inOrder(No n, ArrayList<Object> lista){
        if (isInternal(n)) inOrder(n.getLeft(), lista);
        lista.add(n.getElement());
        if (isInternal(n)) inOrder(n.getRight(), lista);
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
        private No pai, left, right;

        public No(No pai, Object o){
            this.pai = pai;
            this.chave = o;
            this.left = null;
            this.right = null;
        }

        public Object getElement(){
            return this.chave;
        }

        public void setElement(Object o){
            this.chave = o;
        }

        public No parent(){
            return this.pai;
        }

        public void setParent(No n){
            this.pai = n;
        }

        public No getLeft(){
            return this.left;
        }

        public No getRight(){
            return this.right;
        }

        public void setLeft(No n){
            this.left = n;
        }

        public void setRight(No n){
            this.right = n;
        }

    }
}
