import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int count = 0;
        ArrayList<String[][]> pairs = handleFileReading();

        for (int i = 0; i < pairs.size(); i++) {
            System.out.println(pairs.get(i)[0][0] + "-" + pairs.get(i)[0][1] + "," + pairs.get(i)[1][0] + "-" + pairs.get(i)[1][1]);
        }
        System.out.println();

        for (String[][] pair : pairs) {
            if (handleCheckAreas(pair)) {
                count++;
            }
        }
        System.out.println(count);
    }


    public static boolean handleCheckAreas(String[][] pair) {
        int area1Start = Integer.parseInt(pair[0][0]);
        int area1End = Integer.parseInt(pair[0][1]);
        int area2Start = Integer.parseInt(pair[1][0]);
        int area2End = Integer.parseInt(pair[1][1]);

        return ((area1Start <= area2Start && area1End >= area2End) || (area2Start <= area1Start && area2End >= area1End));
    }

    public static ArrayList<String[][]> handleFileReading() {
        ArrayList<String> pairs = new ArrayList<>();
        File datafile = new File("./data.txt");
        Scanner dataInput;
        try {
            dataInput = new Scanner(datafile);
            while (dataInput.hasNextLine()) {
                pairs.add(dataInput.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.print("Error reading file.");
        }
        ArrayList<String[][]> pairsSplit = new ArrayList<>();
        for(String pair : pairs) {
            String[] splitPair = pair.split(",");
            String[][] splitPair2 = new String[][] {splitPair[0].split("-"), splitPair[1].split("-")};
            pairsSplit.add(splitPair2);
        }
        return pairsSplit;
    }
}
