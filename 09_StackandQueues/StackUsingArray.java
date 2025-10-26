class Stack{
    int size = 100000;
    int[] arr = new int[size];
    int top = -1;
    void push(int data){
        top++;
        arr[top] = data;
    }
    void pop(){
        top--;
    }
    int peek(){
        return arr[top];
    }
    int size(){
        return top + 1;
    }
}

public class StackUsingArray {
    public static void main(String[] args) {

        Stack s = new Stack();
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top of the stack before deleting any element " + s.peek());
        System.out.println("Size of the stack before deleting any element " + s.size());
        System.out.println("The element deleted is " + s.peek());
        s.pop();
        System.out.println("Size of the stack after deleting an element " + s.size());
        System.out.println("Top of the stack after deleting an element " + s.peek());
    }
}
