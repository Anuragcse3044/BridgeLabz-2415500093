import java.util.Stack;

public class reversestack {
    

    public static <T> void reverseStack(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }
        
        
        T top = stack.pop();

          
        // Recursively reverse the remaining stack
        reverseStack(stack);
        
        // Insert the popped element at the bottom
        insertAtBottom(stack, top);
    }
    
    // Helper method to insert an element at the bottom of the stack
    public static <T> void insertAtBottom(Stack<T> stack, T element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        
        // Pop the top element
        T top = stack.pop();
        
        // Recursively insert element at bottom
        insertAtBottom(stack, element);
        
        // Push the popped element back
        stack.push(top);
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        // Create a sample stack: 1, 2, 3, 4, 5 (5 is at top)
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

    