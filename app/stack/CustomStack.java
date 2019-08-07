package stack;

import java.util.EmptyStackException;

public class CustomStack<T extends Comparable<T>> {
    private int length;
    private static class StackNode<T>{
        private T data;
        private StackNode<T> next;
        private StackNode<T> previousMin;

        public StackNode(T data) {
            this.data = data;
        }
    }
    private StackNode<T> top;
    private StackNode<T> minimum;

    public T min(){
        T item = minimum.data;
        return item;
    }

    public T pop(){
        if(top == null) throw new EmptyStackException();
        T item = top.data;
        if(top.previousMin != null){
            minimum = top.previousMin;
        }
        top = top.next;
        this.length--;
        return item;
    }

    public void push(T item){
        StackNode<T> t = new StackNode<T>(item);
        if(this.isEmpty()){
            minimum = t;
        }
        if(item.compareTo(minimum.data) < 0){
            t.previousMin = minimum;
            minimum = t;
        }
        t.next = top;
        top= t;
        this.length++;
    }

    public int length(){
        return this.length;
    }

    public T peek(){
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }
    public static void main(String argv[]) {
    
        CustomStack<Integer> customStack = new CustomStack<>();
        customStack.push(7);
        customStack.push(3);
        customStack.push(-61);
        customStack.push(2);
        customStack.push(5);
        System.out.println(customStack.pop());
        System.out.println(customStack.length);
    }
}