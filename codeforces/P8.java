
import java.util.*;

public class P8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> gemsInGauntlet = new HashSet<>(Arrays.asList("purple", "green", "blue", "orange", "red", "yellow"));

        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline after nextInt()

        Set<String> gemsSeen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String color = sc.nextLine();
            gemsSeen.add(color);
        }

        Set<String> absentGems = new HashSet<>(gemsInGauntlet);
        absentGems.removeAll(gemsSeen);

        System.out.println(absentGems.size());
        for (String color : absentGems) {
            System.out.println(getGemName(color));
        }

        sc.close();
    }

    private static String getGemName(String color) {
        switch (color) {
            case "purple":
                return "Power";
            case "green":
                return "Time";
            case "blue":
                return "Space";
            case "orange":
                return "Soul";
            case "red":
                return "Reality";
            case "yellow":
                return "Mind";
            default:
                return "";
        }
    }
}
