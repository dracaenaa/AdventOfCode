import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        ArrayList<Integer[]> instructions = handleFileReading();
        for (Integer[] line : instructions) {
            System.out.println(line[0] + " from " + line[1] + " to " + line[2]);
        }

        ArrayList<ArrayList<String>> cratesAll = handlePopList();
        for (ArrayList<String> crateList : cratesAll) {
            for (String crate : crateList) {
                System.out.print(crate);
            }
            System.out.println();
        }

        String topCrates = handleFindTopCrates(instructions, cratesAll);
        System.out.println(topCrates);
    }

    public static String handleFindTopCrates(ArrayList<Integer[]> instructions, ArrayList<ArrayList<String>> cratesAll) {

        for(Integer[] instruction : instructions) {
            ArrayList<String> fromCrateList = cratesAll.get(instruction[1]-1);
            ArrayList<String> toCrateList = cratesAll.get(instruction[2]-1);
            for(int i = instruction[0]; i > 0; i--) {
                toCrateList.add(fromCrateList.remove(fromCrateList.size()-i));
            }
        }



        String topCrates = "";
        for(ArrayList<String> crateList : cratesAll) {
            topCrates += crateList.get(crateList.size()-1);
        }

        return topCrates;
    }

    public static ArrayList<Integer[]> handleFileReading() {
        ArrayList<Integer[]> instructions = new ArrayList<>();
        File dataFile = new File("./puzzle_input.txt");
        Scanner dataInput;
        try {
            dataInput = new Scanner(dataFile);
            while(dataInput.hasNextLine()) {
                String current = dataInput.nextLine();
                String[] split = current.split(" ");
                Integer numToMove = Integer.parseInt(split[1]);
                Integer moveFrom = Integer.parseInt(split[3]);
                Integer moveTo = Integer.parseInt(split[5]);
                instructions.add(new Integer[]{numToMove,moveFrom,moveTo});
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file.");
        }
        return instructions;
    }

    public static ArrayList<ArrayList<String>> handlePopList() {
        ArrayList<ArrayList<String>> crates = new ArrayList<>();

        ArrayList<String> row1 = new ArrayList<>();
        row1.add("M");  row1.add("J");  row1.add("C");  row1.add("B");  row1.add("F");
        row1.add("R");  row1.add("L");  row1.add("H");
        crates.add(row1);
        ArrayList<String> row2 = new ArrayList<>();
        row2.add("Z");   row2.add("C");   row2.add("D");
        crates.add(row2);
        ArrayList<String> row3 = new ArrayList<>();
        row3.add("H");  row3.add("J");  row3.add("F");  row3.add("C");
        row3.add("N");   row3.add("G");  row3.add("W");
        crates.add(row3);
        ArrayList<String> row4 = new ArrayList<>();
        row4.add("P");  row4.add("J");  row4.add("D");  row4.add("M");
        row4.add("T");   row4.add("S");  row4.add("B");
        crates.add(row4);
        ArrayList<String> row5 = new ArrayList<>();
        row5.add("N");  row5.add("C");  row5.add("D");  row5.add("R");
        row5.add("J");
        crates.add(row5);
        ArrayList<String> row6 = new ArrayList<>();
        row6.add("W");  row6.add("L");  row6.add("D");  row6.add("Q");
        row6.add("P");   row6.add("J");  row6.add("G");  row6.add("Z");
        crates.add(row6);
        ArrayList<String> row7 = new ArrayList<>();
        row7.add("P");  row7.add("Z");  row7.add("T");  row7.add("F");
        row7.add("R");   row7.add("H");
        crates.add(row7);
        ArrayList<String> row8 = new ArrayList<>();
        row8.add("L");  row8.add("V");  row8.add("M");  row8.add("G");
        crates.add(row8);
        ArrayList<String> row9 = new ArrayList<>();
        row9.add("C");  row9.add("B");  row9.add("G");  row9.add("P");
        row9.add("F");   row9.add("Q");  row9.add("R");  row9.add("J");
        crates.add(row9);

        return crates;
    }
}

/*
[H]                 [Z]         [J]
[L]     [W] [B]     [G]         [R]
[R]     [G] [S]     [J] [H]     [Q]
[F]     [N] [T] [J] [P] [R]     [F]
[B]     [C] [M] [R] [Q] [F] [G] [P]
[C] [D] [F] [D] [D] [D] [T] [M] [G]
[J] [C] [J] [J] [C] [L] [Z] [V] [B]
[M] [Z] [H] [P] [N] [W] [P] [L] [C]
 1   2   3   4   5   6   7   8   9

 */