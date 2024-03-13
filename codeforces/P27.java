import java.util.Scanner;

class A5 {

    // Method overloading for rectangle
     int calculateArea(int length, int width) {
        int c = length * width;
        return c;
    }

    // Method overloading for square
     int calculateArea(int side) {
        int c= side * side;
        return c;
    }

    // Method overloading for circle
     double calculateArea(double radius) {
        return 3.14 * radius * radius;
    }

    // Method overloading for cone
     double calculateArea(float radius, float height) {
        return 3.14 * radius * (radius + Math.sqrt(radius * radius + height * height));
    }

   
     // Method overloading for triangle
      double calculateArea(double base, double height) {
        return 0.5 * base * height;
    }
}

 class P27{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A5 ob = new A5();

       double a = ob.calculateArea(5.0, 8.0);
       System.out.println(a);

    }
}
