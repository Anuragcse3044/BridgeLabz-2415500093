import java.util.Stack;

public class sort {
    
    // Sort a stack in ascending order
    public static <T extends Comparable<T>> void sortStack(Stack<T> stack) {
        Stack<T> tempStack = new Stack<>();
        
        while (!stack.isEmpty()) {
            // Pop from original stack
            T temp = stack.pop();
            
            // Pop from temp stack and push to original stack
            // until we find position for temp
            while (!tempStack.isEmpty() && tempStack.peek().compareTo(temp) > 0) {
                stack.push(tempStack.pop());
            }
            
            // Push temp to temp stack
            tempStack.push(temp);
        }
        
        // Copy sorted elements back to original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
    
    // Helper method to print stack
    public static void printStack(Stack<Integer> stack) {
        System.out.print("Stack (top to bottom): ");
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            Integer val = stack.pop();
            System.out.print(val + " ");
            temp.push(val);
        }
        // Restore the stack
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        System.out.println();
    }
    
    // Sort array and push elements to stack
    public static void sortArrayUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        // Push all elements to stack
        for (int num : arr) {
            stack.push(num);
        }
        
        System.out.println("Original Stack:");
        printStack(stack);
        
        // Sort the stack
        sortStack(stack);
        
        System.out.println("Sorted Stack:");
        printStack(stack);
    }
    
    public static void main(String[] args) {
        // Test Case 1: Integer array
        int[] arr1 = {5, 3, 8, 1, 9, 2};
        System.out.println("=== Test Case 1: Sorting array [5, 3, 8, 1, 9, 2] ===");
        sortArrayUsingStack(arr1);
        
        System.out.println("\n=== Test Case 2: Sorting array [64, 34, 25, 12, 22, 11, 90] ===");
        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        sortArrayUsingStack(arr2);
    }
}
