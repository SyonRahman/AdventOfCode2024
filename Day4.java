import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day4.txt");
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];
        int numberofXmas = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
            }
        }

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length - 3; c++) {
                if ((grid[r][c] + grid[r][c+1] + grid[r][c+2] + grid[r][c+3]).equals("XMAS")) {
                    numberofXmas++;
                }
                if ((grid[r][c] + grid[r][c+1] + grid[r][c+2] + grid[r][c+3]).equals("SAMX")) {
                    numberofXmas++;
                }
            }
        }

        for (int r = 0; r < grid.length - 3; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if ((grid[r][c] + grid[r+1][c] + grid[r+2][c] + grid[r+3][c]).equals("XMAS")) {
                    numberofXmas++;
                }
                if ((grid[r][c] + grid[r+1][c] + grid[r+2][c] + grid[r+3][c]).equals("SAMX")) {
                    numberofXmas++;
                }
            }
        }

        for (int r = 0; r < grid.length - 3; r++) {
            for (int c = 0; c < grid[r].length - 3; c++) {
                if ((grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] + grid[r+3][c+3]).equals("XMAS")) {
                    numberofXmas++;
                }
                if ((grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] + grid[r+3][c+3]).equals("SAMX")) {
                    numberofXmas++;
                }
            }
        }

        for (int r = grid.length - 1; r > 3; r--) {
            for (int c = grid[r].length - 1; c > 3; c--) {
                if ((grid[r][c] + grid[r-1][c-1] + grid[r-2][c-2] + grid[r-3][c-3]).equals("XMAS")) {
                    numberofXmas++;
                }
                if ((grid[r][c] + grid[r-1][c-1] + grid[r-2][c-2] + grid[r-3][c-3]).equals("SAMX")) {
                    numberofXmas++;
                }
            }
        }

//        for (int r = grid.length - 1; r > 3; r--) {
//            for (int c = 0; c < grid[r].length - 3; c++) {
//                if ((grid[r][c] + grid[r-1][c+1] + grid[r-2][c+2] + grid[r-3][c+3]).equals("XMAS")) {
//                    numberofXmas++;
//                }
//                if ((grid[r][c] + grid[r-1][c+1] + grid[r-2][c+2] + grid[r-3][c+3]).equals("SAMX")) {
//                    numberofXmas++;
//                }
//            }
//        }

        for (int r = 0; r < grid.length - 3; r++) {
            for (int c = grid[r].length - 1; c > 3; c--) {
                if ((grid[r][c] + grid[r+1][c-1] + grid[r+2][c-2] + grid[r+3][c-3]).equals("XMAS")) {
                    numberofXmas++;
                }
                if ((grid[r][c] + grid[r+1][c-1] + grid[r+2][c-2] + grid[r+3][c-3]).equals("SAMX")) {
                    numberofXmas++;
                }
            }
        }



        System.out.println(numberofXmas);
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
