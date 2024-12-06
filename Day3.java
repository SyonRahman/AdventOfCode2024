import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day3.txt");

        ArrayList<String> allMatches = new ArrayList<String>();
        for (int i = 0; i < fileData.size(); i++) {
            String searchString = fileData.get(i);
            String regex = "mul\\([1-9][0-9]{0,2},[1-9][0-9]{0,2}\\)";
            Matcher m = Pattern.compile(regex).matcher(searchString);
            while (m.find()) {
                allMatches.add(m.group());
            }
        }
        System.out.println(allMatches);
        System.out.println(allMatches.size());

        int totalresult = 0;

        for (int i = 0; i < allMatches.size(); i++) {
            int parenthesis1 = allMatches.get(i).indexOf("(");
            int parenthesis2 = allMatches.get(i).indexOf(")");
            int comma = allMatches.get(i).indexOf(",");
            int num1 = Integer.parseInt(allMatches.get(i).substring(parenthesis1 + 1, comma));
            int num2 = Integer.parseInt(allMatches.get(i).substring(comma + 1, parenthesis2));
            totalresult += (num1 * num2);

        }

        System.out.println(totalresult);

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
