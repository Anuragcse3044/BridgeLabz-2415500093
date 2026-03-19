import java.util.Stack;

public class reversestack {
    

    public static <T> void reverseStack(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }
        
        
        T top = stack.pop();

        
        reverseStack(stack);
        
        insertAtBottom(stack, top);
    }
    
    public static <T> void insertAtBottom(Stack<T> stack, T element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        
        T top = stack.pop();
        
        insertAtBottom(stack, element);
        
        stack.push(top);
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        
        System.out.println("Original Stack (top to bottom): " + stack);
        
        reverseStack(stack);
        
        System.out.println("Reversed Stack (top to bottom): " + stack);
    }
}

    
