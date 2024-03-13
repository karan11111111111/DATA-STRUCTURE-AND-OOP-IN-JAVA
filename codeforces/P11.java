import java.util.Arrays;
import java.util.Scanner;



public class P11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            int id = i + 1;
            int totalScore = scanner.nextInt() + scanner.nextInt() + scanner.nextInt() + scanner.nextInt();
            students[i] = new Student(id, totalScore);
        }

        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            if (students[i].id == 1) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}

class Student implements Comparable<Student> {
    int id;
    int totalScore;

    public Student(int id, int totalScore) {
        this.id = id;
        this.totalScore = totalScore;
    }

    // Implement the Comparable interface without @Override
    public int compareTo(Student other) {
        if (this.totalScore == other.totalScore) {
            return Integer.compare(this.id, other.id);
        }
        return Integer.compare(other.totalScore, this.totalScore);
    }
}
