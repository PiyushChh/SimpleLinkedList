import java.lang.annotation.Annotation;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

class SimpleLinkedList<T> {
    private static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data=data;
        }
    }

    private Node<T> head;
    private int size;

    SimpleLinkedList() {
        head=null;
        size=0;
    }

    SimpleLinkedList(T[] values) {
        for(T value:values) {
            push(value);
        }
    }

    void push(T value) {
       Node<T> newNode=new Node<>(value);
       size++;
       newNode.next=head;
       head=newNode;
    }

    T pop() {
        if(head==null){
            throw new NoSuchElementException();
        }
        T data= head.data;
        head=head.next;
        size--;
        return data;
    }

    void reverse() {
        Node<T> prev=null;
        Node<T> curr=head;
        Node<T> next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    T[] asArray(Class<T> clazz) {
        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, size);
        int i = 0;
        for (Node<T> node = head; node != null; node = node.next) {
            array[i++] = node.data;
        }
        return array;
       }

    int size() {
        return size;
    }
}
