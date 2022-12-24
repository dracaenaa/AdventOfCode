import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        ArrayList<String> input = handleFileReading();
        Map<String, Directory> directories = new HashMap<>();

        for (int i = 0; i < input.size(); i++) {
            String curLine = input.get(i);
            if (curLine.contains("dir")) {
                if (!directories.containsKey(curLine.substring(4))) {
                    Directory newDir = handleCreateDirectory(curLine.substring(4));
                    directories.put(newDir.getName(), newDir);
                }
            } else if (curLine.contains("cd") && !curLine.contains("..") && !curLine.contains("ls") && !curLine.contains("/")) {
                String curDirName = curLine.substring(5);
                Directory curDir = directories.get(curDirName);
                while (i < input.size()-1) {
                    i++;
                    curLine = input.get(i);
                    if (curLine.contains("dir")) {
                        String subDirName = curDirName + "/" + curLine.substring(4);
                        if(!directories.containsKey(subDirName)) {
                            Directory newDir = handleCreateDirectory(subDirName);
                            directories.put(newDir.getName(), newDir);
                        }
                        curDir.addSubdirectory(subDirName, directories.get(subDirName));
                    }
                    else if (!curLine.contains("dir") && !curLine.contains("$")) {
                        curDir.setSize(Integer.parseInt(curLine.split(" ")[0]));
                    }
                    else if(curLine.contains("$ cd ..")) {
                        i--;
                        break;
                    }
                }
            }
        }

        Integer sum = 0;
        for (Directory directory : directories.values()) {
            handleCalculateSubDirSize(directory);

            Integer dirSize = directory.getSize();
            if (dirSize <= 100000) {
                sum += dirSize;
            }
        }
        System.out.println("Total size of directories less than 100000 size: " + sum);
    }

    public static Directory handleCalculateSubDirSize(Directory currentDir) {
        Map<String, Directory> subDirs = currentDir.getSubdirectories();
        for (Directory subDir : subDirs.values()) {
            currentDir.setSize(handleCalculateSubDirSize(subDir).getSize());
        }

        return currentDir;
    }

    public static Directory handleCreateDirectory(String name) {
        Directory directory = new Directory();
        directory.setName(name);
        return directory;
    }

    public static ArrayList<String> handleFileReading() {
        ArrayList<String> input = new ArrayList<>();

        File file = new File("./input.txt");
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                input.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file.");
        }
        return input;
    }

}
