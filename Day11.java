import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day11 {

    private static ArrayList<String> newStones = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day11.txt");
        System.out.println(fileData);
        String[] stones = fileData.get(0).split(" ");
        for (String s : stones) {
            System.out.println(s);
            newStones.add(s);
        }

        for (int i = 0; i < 25; i++) {
            newArrangement();
        }

    }

    public static void newArrangement() {
        for (int i = 0; i < newStones.size(); i++) {

        }
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
