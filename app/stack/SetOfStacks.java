package stack;

import java.util.ArrayList;

class SetOfStacks<T extends Comparable<T>>{

    private ArrayList<CustomStack<T>> customStacks;
    private CustomStack<T> nextFreeStack;
    private int capacity = 2;

    public SetOfStacks(){
        this.customStacks = new ArrayList<>();
        this.customStacks.add(new CustomStack<T>());
        this.nextFreeStack = this.customStacks.get(0);
    }

    public void push(T item){
        this.nextFreeStack.push(item);
        if(this.nextFreeStack.length() == this.capacity){
            this.customStacks.add(new CustomStack<T>());
            System.out.println(this.customStacks.size());
            this.nextFreeStack =  this.customStacks.get(this.customStacks.size()-1);
        }
    }
    public static void main(String argv[]) {
       
        SetOfStacks<Integer> setOfStacks = new SetOfStacks<>();

        setOfStacks.push(5);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(2);
    }
}