package com.pereverzew.collectiontree;

public class Node <T extends Comparable>{
    private T element;
    private Node leftNode;
    private Node rightNode;

    public Node(T element) {
        this.element = element;
        this.leftNode =null;
        this.rightNode =null;
    }

    public Node() {
        this.leftNode =null;
        this.rightNode =null;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public T getElement() {
        return element;
    }
}
