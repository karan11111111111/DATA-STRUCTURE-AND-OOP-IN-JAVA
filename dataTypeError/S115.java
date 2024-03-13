package dataTypeError;

public class S115 {
    public static void main(String[] args) {
        int value = 42;
        String message = "The value is: " + value ; // Error: Incompatible types
        System.out.println(message);
    }
}
