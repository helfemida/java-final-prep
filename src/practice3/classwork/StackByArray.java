package practice3.classwork;

public class StackByArray <E> {
    public static final int INITIAl_CAPACITY = 3;

    private static int size = 0;

    private E[] data = (E[]) new Object[INITIAl_CAPACITY]; // [[], [], []]
    //[[1], 2], [3], []]; ArrayIndexOutOfBoundsException
    //[1, 2, 3]
    //[1, 2, 3, []];
    //data = [[1], [2], [3]]

    public StackByArray() {}

    public void push(E e) {
        if (size != 0 && data[size - 1] != null){
            ensureCapacity();
        }
        data[size] = e;
        size++;
    }


    public E peek() {
        return data[size - 1];
    }

    public E pop() {
        E e = data[size - 1];
        data[size - 1] = null;
        size--;
        return e;
    }

    public void ensureCapacity() {
        E[] temp = (E[]) new Object[data.length + 1];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public String toString() {
        String res = "[";

        for(int i = 0; i < size; i++){
            if(i == size - 1){
                res += data[i];
                break;
            }
            res += data[i] + ", ";
        }

        return res + "]";
    }
}

class TestStackByArray {
    public static void main(String[] args) {
        StackByArray<Integer> stack = new StackByArray<>();
        stack.push(89);
        stack.push(1243);
        stack.push(22);
        stack.push(57);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}