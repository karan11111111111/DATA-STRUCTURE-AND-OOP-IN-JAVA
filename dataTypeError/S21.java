package dataTypeError;

public class S21 {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = new String("Hello");
        if (str1 == str2) {
            System.out.println("Equal"); // Error: Use .equals() for String comparison
        }
    }
}
