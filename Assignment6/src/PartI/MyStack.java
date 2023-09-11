package PartI;
import java.util.ArrayList;

public class MyStack<E> {

    private ArrayList<E> stack = new ArrayList<>();

    public boolean empty() {
        return stack.isEmpty();
    }

    public E peek() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    public E pop() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public E push(E item) {
        stack.add(item);
        return item;
    }

    public int search(Object o) {
        int index = stack.lastIndexOf(o);
        if (index == -1) {
            return -1;
        } else {
            return stack.size() - index; //the first index in my implementation is 1, not 0
        }
    }
    
    public static void main(String[] args) {
    	MyStack<Integer> mystack = new MyStack<Integer>();
    	mystack.push(3);
    	mystack.push(1);
    	mystack.push(7);
    	mystack.push(2);
    	mystack.push(4);
    	
    	mystack.pop();
    	System.out.println(mystack.peek());
    	System.out.println(mystack.search(1));
    }

}
