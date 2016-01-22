package DataStrcuture;

import java.util.Iterator;

/**
 * Created by Wang on 2016/1/22.
 */
public class Queue<Item> implements Iterable {
    private Node first;
    private Node last;
    private int N;
    private class Node{
        Node next;
        Item item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.next = null;
        last.item = item;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        N++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        return item;
    }

    @Override
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    public class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
