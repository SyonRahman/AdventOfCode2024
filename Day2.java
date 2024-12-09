import com.sun.jdi.connect.Connector;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {


    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day2.txt");

        boolean safe = true;
        int numberofsafes = 0;
        int one_error_safes = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String[] splitnums = fileData.get(i).split(" ");
            if (safeOrNot(splitnums)) {
                numberofsafes++;
            }
        }
        for (int i = 0; i < fileData.size(); i++) {
            String[] splitnums = fileData.get(i).split(" ");
            if (safeOrNotbyOne(splitnums)) {
                one_error_safes++;
            }
        }
        System.out.println(numberofsafes);
        System.out.println(one_error_safes);

    }

    public static boolean safeOrNotbyOne(String[] nums) {
        boolean increasing = false;
        int numberoferrors = 0;
        ArrayList<String> numbers = new ArrayList<String>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }
        if (Integer.parseInt(nums[1]) - Integer.parseInt(nums[0]) > 0) {
            increasing = true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (increasing) {
                if (!(Integer.parseInt(nums[i + 1]) - Integer.parseInt(nums[i]) >= 1 && Integer.parseInt(nums[i + 1]) - Integer.parseInt(nums[i]) <= 3)) {
                    return false;
                }
            } else {
                if (!(Integer.parseInt(nums[i + 1]) - Integer.parseInt(nums[i]) >= -3 && Integer.parseInt(nums[i + 1]) - Integer.parseInt(nums[i]) <= -1)) {
                    return false;
                }
            }
        }

    }

    public static boolean safeOrNot(String[] nums) {
        boolean increasing = false;
        if (Integer.parseInt(nums[1]) - Integer.parseInt(nums[0]) > 0) {
            increasing = true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (increasing) {
                if (!(Integer.parseInt(nums[i + 1]) - Integer.parseInt(nums[i]) >= 1 && Integer.parseInt(nums[i + 1]) - Integer.parseInt(nums[i]) <= 3)) {
                    return false;
                }
            } else {
                if (!(Integer.parseInt(nums[i + 1]) - Integer.parseInt(nums[i]) >= -3 && Integer.parseInt(nums[i + 1]) - Integer.parseInt(nums[i]) <= -1)) {
                    return false;
                }
            }
        }
        return true;
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
