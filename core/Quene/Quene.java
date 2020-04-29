package Quene;

import java.util.Iterator;

/**
 * @Auther LJM
 * @Date 2020/4/29-10:41
 * Description 链表-队列
 */
public class Quene<T> implements Iterable{
    public Node first;
    public Node last;
    private int count;
    private class Node<T>{
        T item;
        Node next;
    }

    public void enquene(T item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldlast.next = last;;
        count++;
    }

    public int size(){
        return count;
    }

    public T dequene(){
        if (isEmpty()) return null;
        else {
            T item = (T)first.item;
            first = first.next;
            count --;
            return item;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Node<T> next() {
            Node<T> node= current;
            current = current.next;
            return node;
        }
    }
}
