package practice2.classwork;

import java.util.LinkedList;

public class GenericQueue <E> {
    private LinkedList<E> queue;

    public GenericQueue(){
        queue = new LinkedList<>();
    }

    public void enqueue(E e){
        queue.add(e);
    }

    public E dequeue(){
        E e = queue.get(0);
        queue.remove(0);
        return e;
    }

}

class TestQueue{
    public static void main(String[] args) {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.enqueue(10);
        queue.enqueue(101);
        queue.enqueue(120);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}