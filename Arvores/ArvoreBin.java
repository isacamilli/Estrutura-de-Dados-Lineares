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

    public No treeSearch(Object k, No v){
        if (isExternal(v)) return v;

        if (k < v.key) return treeSearch(k, v.getLeft());
        else if (k > v.key) return treeSearch(k, v.getRight());
        else if (k == v.key) return v;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node node, int key) {
        if (node == null)
            return new Node(key);
        if (key < node.key)
            node.left = insertRec(node.left, key);
        else if (key > node.key)
            node.right = insertRec(node.right, key);
        return node;
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node node, int key) {
        if (node == null)
            return null;

        if (key < node.key) {
            node.left = deleteRec(node.left, key);
        } else if (key > node.key) {
            node.right = deleteRec(node.right, key);
        } else {
            // Nó encontrado
            // Caso 1: sem filhos
            if (node.left == null && node.right == null)
                return null;

            // Caso 2: apenas um filho
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;

            // Caso 3: dois filhos
            // Substituir pelo menor valor da subárvore direita
            node.key = minValue(node.right);
            node.right = deleteRec(node.right, node.key);
        }

        return node;
    }

    private int minValue(Node node) {
        int min = node.key;
        while (node.left != null) {
            node = node.left;
            min = node.key;
        }
        return min;
    }

    public int altura() {
        return alturaRec(root);
    }

    // Método recursivo para calcular altura a partir de um nó
    private int alturaRec(Node node) {
        if (node == null) {
            return -1;  // árvore vazia tem altura -1
        }

        int alturaEsquerda = alturaRec(node.left);
        int alturaDireita = alturaRec(node.right);

        return 1 + Math.max(alturaEsquerda, alturaDireita);
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
