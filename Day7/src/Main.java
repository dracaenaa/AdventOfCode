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
        String curDirName = "";

        for (int i = 0; i < input.size(); i++) {
            String curLine = input.get(i);
            if (curLine.contains("dir")) {
                if (!directories.containsKey(curLine.substring(4))) {
                    Directory newDir = handleCreateDirectory("/" + curLine.substring(4));
                    directories.put(newDir.getName(), newDir);
                }
            }
            else if (curLine.contains("cd")) {
                if (!curLine.contains("..") && !curLine.contains("/")) {
                    curDirName = curDirName.concat("/" + curLine.substring(5));
                    Directory curDir = directories.get(curDirName);
                    if (curDir == null) {
                        curDir = handleCreateDirectory(curDirName);
                    }
                    while (i < input.size() - 1) {
                        i++;
                        curLine = input.get(i);
                        if (curLine.contains("dir")) {
                            String subDirName = curDirName + "/" + curLine.substring(4);
                            if (!directories.containsKey(subDirName)) {
                                Directory newDir = handleCreateDirectory(subDirName);
                                directories.put(newDir.getName(), newDir);
                            }
                            curDir.addSubdirectory(subDirName, directories.get(subDirName));
                        } else if (!curLine.contains("dir") && !curLine.contains("$")) {
                            curDir.setSize(Integer.parseInt(curLine.split(" ")[0]));
                        } else if (curLine.contains("$ cd")) {
                            i--;
                            break;
                        }
                    }
                }
                else if (curLine.contains("..") &&!curLine.contains("/")) {
                    String[] splitName = curDirName.split("/");
                    curDirName = "";
                    for (int j = 1; j < splitName.length; j++) {
                        if (j == splitName.length-1) break;
                        curDirName = curDirName.concat("/" + splitName[j]);
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
        if (currentDir.getSubdirectories().size() > 0 && !currentDir.isSizeCalculated()) {
            Map<String, Directory> subDirs = currentDir.getSubdirectories();
            for (Directory subDir : subDirs.values()) {
                currentDir.setSize(handleCalculateSubDirSize(subDir).getSize());
            }
            currentDir.setSizeCalculated(true);
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
