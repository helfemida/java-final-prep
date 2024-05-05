package practice2.classwork;

import java.util.ArrayList;
import java.util.Stack;

/*
V, K, E, T
V - value
K - key
E - element
 */
public class GenericStack <E> {
    private ArrayList<E> stack;
    private int lastIndex;

    public GenericStack(){
        stack = new ArrayList<>();
        lastIndex = -1;
    }

    public void push(E element){
        stack.add(element);
        lastIndex++;
    }

    public E pop(){
        E e = stack.get(lastIndex);
        stack.remove(lastIndex);
        lastIndex--;
        return e;
    }
    public E peek(){
        return stack.get(lastIndex);
    }

    public boolean isEmpty(){
        return lastIndex == -1;
    }

    public int size(){
        return lastIndex + 1;
    }

    public String toString(){
        String s = "[";
        for(int i = lastIndex; i >= 0; i--){
            s += stack.get(i) + ", ";
        }
        s = s.trim().substring(0, s.length() - 2);
        s += "]";
        return s;
    }

}
class TestStack{

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();
        stack.push(100);
        stack.push(101);
        stack.push(120);
        System.out.println(stack);
        System.out.println("Popped element 1: " + stack.pop());
        stack.push(1);
        System.out.println("Popped element 2: " + stack.pop());
        System.out.println("Peek element: " + stack.peek());
        System.out.println(stack);
    }
}
