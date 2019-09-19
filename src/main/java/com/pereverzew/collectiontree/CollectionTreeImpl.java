package com.pereverzew.collectiontree;
import org.apache.log4j.Logger;

import java.util.Optional;

public class CollectionTreeImpl<T extends Comparable> implements CollectionTree<T> {
    private static final Logger log = Logger.getLogger(CollectionTreeImpl.class);
    private Node head;
    private int size;

    public CollectionTreeImpl() {
        head = null;
        size=0;
    }

    public void add(T element) {
        if (null==element){log.info("Invalid argument");return;}
        Node node= new Node(element);
        if (size==0){
            head=node;
        }else{
            addNew(head,node);
        }
        size++;
    }

    private void addNew(Node thisNode,Node newNode) {
        int result=thisNode.getElement().compareTo(newNode.getElement());
        if (result==0){
            thisNode.setElement(newNode.getElement());
            size--;
            return;
        }
        if(result>0) {
            if(thisNode.getLeftNode() ==null) {
                thisNode.setLeftNode(newNode);
            }else{
                addNew(thisNode.getLeftNode(),newNode);
            }
        }else{
            if(thisNode.getRightNode() ==null) {
                thisNode.setRightNode(newNode);
            }else{
                addNew(thisNode.getRightNode(),newNode);
            }
        }
    }

    public boolean delete(T element) {
        if (size==0){return false;}
        if (null==element){log.info("Invalid argument"); return false;}
        Node node=new Node(element);
        if(head.getElement().compareTo(node.getElement())==0 ){
            Node tmp= head.getLeftNode();
            head= head.getRightNode();
            addNew(head, tmp);
            size--;
            return true;
        }
        Boolean flag = deleteNode(head,node);
        if (flag){size--; return true;};
        return false;
    }

    private boolean deleteNode(Node node,Node deletingNode){
        int result=node.getElement().compareTo(deletingNode.getElement());
        if (result>0 && node.getLeftNode()!=null){
            if (node.getLeftNode().getElement().compareTo(deletingNode.getElement())==0){
                Node leftNode= node.getLeftNode().getLeftNode();
                Node rightNode=node.getLeftNode().getRightNode();
                node.setLeftNode(rightNode);
                addNew(node,leftNode);
                return true;
            }else{
                return deleteNode(node.getLeftNode(),deletingNode);
            }
        }else if (result<0 && node.getRightNode()!=null){
            if (node.getRightNode().getElement().compareTo(deletingNode.getElement())==0){
                Node leftNode=node.getRightNode().getLeftNode();
                Node rightNode= node.getRightNode().getRightNode();
                node.setRightNode(rightNode);
                addNew(node,leftNode);
                return true;
            }else{
                return deleteNode(node.getRightNode(),deletingNode);
            }
        }
        return false;
    }

    public Optional<T> get(T element) {
        if (head.getElement().equals(element)){return Optional.of((T) head.getElement());}
        return Optional.ofNullable(getElement(head,element));
    }

    private T getElement(Node node, T element){
        Node way;
        if (node.getElement().compareTo(element)>0) {
            way = node.getLeftNode();
        }else{
            way= node.getRightNode();
        }
        if (null==way){return null;}
        if (way.getElement().equals(element)){return (T) way.getElement();}
        return getElement(way,element);
    }

    public int size() {
        return this.size;
    }


}
