package Bag;

import java.util.Iterator;


/**
 * @Auther 刘金明
 * @Date 2020/4/28-17:21
 * Description 背包
 */
public class Bag<T> implements Iterable<T>{
    private Node first;
    private class Node{
        T item;
        Node next;
    }

    public void add(T item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public boolean isEmpty(){
        return first == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>();
    }

    private class ListIterator<T> implements Iterator<T>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = (T)current.item;
            current = current.next;
            return item;
        }
    }

}
