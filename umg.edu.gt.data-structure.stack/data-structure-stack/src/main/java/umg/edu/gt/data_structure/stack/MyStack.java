package umg.edu.gt.data_structure.stack;

public class MyStack {

    private Node top;
    private int count;

    public MyStack() {
        this.top = null;
        this.count = 0;
    }

    public void push(char value) {
        Node n = new Node(value);
        n.setNext(top);
        top = n;
        count++;
    }

    public char pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        char value = top.getData();
        top = top.getNext();
        count--;
        return value;
    }

    public char peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    
    public int getCount() {
        return count;
    }

    
    public int length() {
        return count;
    }

    
    public Node getNodeInit() {
        if (isEmpty()) return null;

        Node current = top;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    
    public Node getTop() {
        return top;
    }
}