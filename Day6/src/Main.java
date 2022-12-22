import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String input = handleFileReader();
        int length = input.length();

        for (int i = 0; i < input.length()-13; i++) {
            String setOfInput = input.substring(i,i+14);
            String one = setOfInput.substring(0,1);
            String two = setOfInput.substring(1,2);
            String three = setOfInput.substring(2,3);
            String four = setOfInput.substring(3,4);
            String five = setOfInput.substring(4,5);
            String six = setOfInput.substring(5,6);
            String seven = setOfInput.substring(6,7);
            String eight = setOfInput.substring(7,8);
            String nine = setOfInput.substring(8,9);
            String ten = setOfInput.substring(9,10);
            String eleven = setOfInput.substring(10,11);
            String twelve = setOfInput.substring(11,12);
            String thirteen = setOfInput.substring(12,13);
            String fourteen = setOfInput.substring(13);

            if ((setOfInput.split(one).length == 2) && (setOfInput.split(two).length == 2) && (setOfInput.split(three).length == 2) &&
                    (setOfInput.split(four).length == 2) && (setOfInput.split(five).length == 2) && (setOfInput.split(six).length == 2) &&
                    (setOfInput.split(seven).length == 2) && (setOfInput.split(eight).length == 2) && (setOfInput.split(nine).length == 2) &&
                    (setOfInput.split(ten).length == 2) && (setOfInput.split(eleven).length == 2) && (setOfInput.split(twelve).length == 2) &&
                    (setOfInput.split(thirteen).length == 2) && !setOfInput.substring(0,13).contains(fourteen)) {
                System.out.println(i+14);
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
