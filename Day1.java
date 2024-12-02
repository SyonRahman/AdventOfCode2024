import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Day1 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day1.txt");

        ArrayList<Integer> firstList = new ArrayList<Integer>();
        ArrayList<Integer> secondList = new ArrayList<Integer>();
        int total = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String split = fileData.get(i).split("   ")[0];
            firstList.add(Integer.parseInt(split));
        }
        for (int i = 0; i < fileData.size(); i++) {
            String split = fileData.get(i).split("   ")[1];
            secondList.add(Integer.parseInt(split));
        }
        Collections.sort(firstList);
        Collections.sort(secondList);
        System.out.println(firstList);
        System.out.println(secondList);

        for (int i = 0; i < fileData.size(); i++) {
            if (firstList.get(i) > secondList.get(i)) {
                total += firstList.get(i) - secondList.get(i);
            } else {
                total += secondList.get(i) - firstList.get(i);
            }
        }
        System.out.println(total);
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