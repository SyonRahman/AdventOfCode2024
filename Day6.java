import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day6.txt");
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];
        String current = "^";
        int row = 0;
        int column = 0;
        int positions = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
            }
        }

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c].equals("^")) {
                    row = r;
                    column = c;
                }
            }
        }

        while (true) {
            if (current.equals("^")) {
                while (!(grid[row][column].equals("#"))) {
                    grid[row][column] = "X";
                    row--;
                }
                current = ">";
            }
            if (current.equals(">")) {
                while (!(grid[row][column].equals("#"))) {
                    grid[row][column] = "X";
                    column++;
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
