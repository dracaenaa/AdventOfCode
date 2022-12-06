import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> rucksacks = handleFileReading();
        for ( String sack : rucksacks) {
            System.out.println(sack);
        }
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