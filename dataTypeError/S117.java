package dataTypeError;

public class S117 {
    public static void main(String[] args) {
        boolean condition = false;
        if (condition) {
            System.out.println("Condition is true");
        } else {
            System.out.println("Condition is false");
        }
        // Error: Unreachable code
    }
}
