import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String input = handleFileReader();

        for (int i = 0; i < input.length()-4; i+=4) {
            String current = input.substring(i,i+1);
            String firstNext = input.substring(i+1,i+2);
            String secondNext = input.substring(i+2,i+3);
            String thirdNext = input.substring(i+3,i+4);
            if (!current.equals(firstNext) && !current.equals(secondNext) && !current.equals(thirdNext) &&
            !firstNext.equals(secondNext) && !firstNext.equals(thirdNext) && !secondNext.equals(thirdNext)) {
                System.out.println(i);
                break;
            }
        }

    }

    public static String handleFileReader() {
        File dataFile = new File("./input.txt");
        String input = "";
        Scanner dataInput;
        try {
            dataInput = new Scanner(dataFile);
            while (dataInput.hasNextLine()) {
                input = dataInput.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file.");
        }
        return input;
    }
}
