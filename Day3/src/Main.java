import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> rucksacks = handleFileReading();

        int sum = 0;

        for(int i = 0; i < rucksacks.size()-2; i+=3) {
            sum += handleFindPrioritySum(rucksacks.get(i), rucksacks.get(i+1), rucksacks.get(i+2));
        }
        System.out.println(sum);

    }

    public static int handleFindPrioritySum(String rucksack1, String rucksack2, String rucksack3) {

        Map<String, Integer> priorities = new HashMap<>();
        {
            priorities.put("a", 1);  priorities.put("b", 2);  priorities.put("c", 3);  priorities.put("d", 4);  priorities.put("e", 5);  priorities.put("f", 6);  priorities.put("g", 7);  priorities.put("h", 8);
            priorities.put("i", 9);  priorities.put("j", 10);  priorities.put("k", 11);  priorities.put("l", 12);  priorities.put("m", 13);  priorities.put("n", 14);  priorities.put("o", 15);  priorities.put("p", 16);
            priorities.put("q", 17);  priorities.put("r", 18);  priorities.put("s", 19);  priorities.put("t", 20);  priorities.put("u", 21);  priorities.put("v", 22);  priorities.put("w", 23);  priorities.put("x", 24);
            priorities.put("y", 25);  priorities.put("z", 26);  priorities.put("A", 27);  priorities.put("B", 28);  priorities.put("C", 29);  priorities.put("D", 30);  priorities.put("E", 31);  priorities.put("F", 32);
            priorities.put("G", 33);  priorities.put("H", 34);  priorities.put("I", 35);  priorities.put("J", 36);  priorities.put("K", 37);  priorities.put("L", 38);  priorities.put("M", 39);  priorities.put("N", 40);
            priorities.put("O", 41);  priorities.put("P", 42);  priorities.put("Q", 43);  priorities.put("R", 44);  priorities.put("S", 45);  priorities.put("T", 46);  priorities.put("U", 47);  priorities.put("V", 48);
            priorities.put("W", 49);  priorities.put("X", 50);  priorities.put("Y", 51);  priorities.put("Z", 52);
        }

        for (int i = 0; i < rucksack1.length(); i++) {
            String letter = rucksack1.substring(i, i+1);
            if (rucksack2.contains(letter) && rucksack3.contains(letter)) {
                return priorities.get(letter);
            }
        }
        return 0;
    }

    public static ArrayList<String> handleFileReading() {
        ArrayList<String> rucksacks = new ArrayList<>();

        File dataFile = new File("./day3.txt");
        Scanner dataInput = null;

        try {
            dataInput = new Scanner(dataFile);
            while (dataInput.hasNextLine()) {
                rucksacks.add(dataInput.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error reading file.");
        }
        return rucksacks;
    }
}