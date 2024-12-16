import com.sun.jdi.connect.Connector;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {

    private static ArrayList<ArrayList<Integer>> incorrectSafes = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> newCorrectSafes = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day2.txt");

        boolean safe = true;
        int numberofsafes = 0;
        int one_error_safes = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String[] splitnums = fileData.get(i).split(" ");
            ArrayList<Integer> safenums = new ArrayList<>();
            for (int v = 0; v < splitnums.length; v++) {
                safenums.add(Integer.parseInt(splitnums[v]));
            }
            if (safeOrNot(splitnums, safenums)) {
                numberofsafes++;
            }
        }
        System.out.println(numberofsafes);
        System.out.println(incorrectSafes.size());
        System.out.println(incorrectSafes);
        System.out.println(one_error_safes + numberofsafes);

    }



    public static boolean safeOrNot(String[] nums, ArrayList<Integer> safenums) {
        boolean increasing = false;
        if (Integer.parseInt(nums[1]) - Integer.parseInt(nums[0]) > 0) {
            increasing = true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (increasing) {
                if (!(Integer.parseInt(nums[i + 1]) - Integer.parseInt(nums[i]) >= 1 && Integer.parseInt(nums[i + 1]) - Integer.parseInt(nums[i]) <= 3)) {
                    incorrectSafes.add(safenums);
                    return false;
                }
            } else {
                if (!(Integer.parseInt(nums[i + 1]) - Integer.parseInt(nums[i]) >= -3 && Integer.parseInt(nums[i + 1]) - Integer.parseInt(nums[i]) <= -1)) {
                    incorrectSafes.add(safenums);
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean fixSafe() {
        for (int i = 0; i < incorrectSafes.size(); i++) {
            ArrayList<Integer> checkArray = incorrectSafes.get(i);
            if (checkArray.get(1) - checkArray.get(0) > 0) {
                
            }
            ArrayList<Integer> removedElementArray = new ArrayList<>();
            for (int v = 0; v < checkArray.size(); v++) {
                if () {

                }
            }
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
