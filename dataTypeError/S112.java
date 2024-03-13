package dataTypeError;

public record S112() {
    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE;
        int overflow = maxValue + 1; // Error: Integer overflow
      
    }
}
