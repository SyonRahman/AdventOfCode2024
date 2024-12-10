import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day5.txt");
        ArrayList<String> rules = new ArrayList<String>();
        ArrayList<String> pageNumbers = new ArrayList<String>();
        ArrayList<Integer> rule1 = new ArrayList<Integer>();
        ArrayList<Integer> rule2 = new ArrayList<Integer>();
        int middlesum = 0;
        for (int i = 0; i < 1176; i++) {
            rules.add(fileData.get(i));
        }
        for (int i = 1176; i < fileData.size(); i++) {
            pageNumbers.add(fileData.get(i));
        }
        for (int i = 0; i < rules.size(); i++) {
            rule1.add(Integer.parseInt(rules.get(i).substring(0, 2)));
            rule2.add(Integer.parseInt(rules.get(i).substring(3, 5)));
        }
        System.out.println(fileData);
        System.out.println(rules);
        System.out.println(rule1);
        System.out.println(rule2);
        System.out.println(pageNumbers);

        for (int i = 0; i < pageNumbers.size(); i++) {
            int[] nums = new int[pageNumbers.get(i).split(",").length];
            for (int v = 0; v < pageNumbers.get(i).split(",").length; v++) {
                nums[v] = Integer.parseInt(pageNumbers.get(i).split(",")[v]);
            }
            if (pageRules(nums)) {
                middlesum += nums[nums.length / 2];
            }
        }

        System.out.println(middlesum);

    }

    public static boolean pageRules(int[] nums) {

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
