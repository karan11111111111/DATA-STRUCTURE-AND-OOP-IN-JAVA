package dataTypeError;

public class S118 {
    public static void main(String[] args) {
        int[] numbers = new int[3];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = "Three"; // Error: Incompatible types
    }
}
