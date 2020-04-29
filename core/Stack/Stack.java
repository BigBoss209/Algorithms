package Stack;

import java.util.Iterator;

/**
 * @Auther LJM
 * @Date 2020/4/29-12:07
 * Description
 */
public class Stack<T> implements Iterable<T>{
    private Node first;
    private int count;

    private class Node{
        T item;
        Node next;
    }

    public void push(T item){
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = null;
        if(!isEmpty()){
            first.next = old;
        }
        count++;
    }

    public T pop(){
        if(isEmpty()) return null;
        else {
            T item = first.item;
            first = first.next;
            count--;
            return item;
        }

    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
//        return count == 0;
        return first == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>();
    }

    private class ListIterator<T> implements Iterator{
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
