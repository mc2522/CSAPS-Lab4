/**
 * Mike Cao
 * 10/10/18
 * KenKen.java Lab 4
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class KenKen {
    /**
     * This program reads a KenKen puzzle from an input file and indicates whether it is valid or not by verifying each of the regions.
     */

    private ArrayList<Region> regions;
    private ArrayList<Region> incorrect = new ArrayList<Region>();

    public KenKen(String filename)  throws FileNotFoundException {
        /**
         * Reads the file and creates a grid of rows and columns of size dim. Inputs the values on the file into the grid and verifies if it reaches the target value/
         */
        try {
            Scanner in = new Scanner(new File(filename));
            int dim = in.nextInt();
            int num_regions = in.nextInt();

            Grid grid = new Grid(dim); //grid of numbers that is to be tested
            Grid grid2 = new Grid(dim); //grid of regions that number from 0-6
            regions = new ArrayList(num_regions);

            for(int y = 0; y < dim; y++) { //sets the values of grid
                for(int x = 0; x < dim; x++) {
                    int val = in.nextInt();
                    grid.setVal(x, y, val);
                }
            }

            for(int i = 0; i < num_regions; i++) { //adds new regions depending on the operations
                int tempval = in.nextInt();
                switch (in.next()) {
                    case "+":
                        regions.add(new AddRegion(i, tempval));
                        break;
                    case "-":
                        regions.add(new SubtractRegion(i, tempval));
                        break;
                    case "*":
                        regions.add(new MultiplyRegion(i, tempval));
                        break;
                    case "/":
                        regions.add(new DivideRegion(i, tempval));
                        break;
                }
            }

            for(int y = 0; y < dim; y++) { //sets the value for the grid containing the regions
                for(int x = 0; x < dim; x++) {
                    int val = in.nextInt();
                    grid2.setVal(x, y, val);
                }
            }

            for(int y = 0; y < dim; y++) { //adds the values to the corresponding region
                for (int x = 0; x < dim; x++) {
                    int region_num = grid2.getVal(x, y);
                    int grid_num = grid.getVal(x, y);
                    regions.get(region_num).addValue(grid_num);
                }
            }

            for(Region x : regions) { //call toString
                System.out.println(x.toString());
            }

            if(incorrect.size() == 0) { //printing out whether or not the puzzle is correct
                System.out.println("*** Puzzle is correct!");
            } else {
                System.out.print("*** Puzzle is incorrect! Invalid Regions: ");
                for(int i = 0; i < incorrect.size(); i++) {
                    System.out.print(incorrect.get(i));
                }
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Usage: java KenKen " + filename);
        }
    }

    public void check() { //checks if the puzzle is correct
        for(Region i: regions) {
            if(i.verify() != true) {
                incorrect.add(i);
            }
        }
    }

    public ArrayList getIncorrectRegions() { //accesses the incorrect arraylist
        return incorrect;
    }

    public static void main(String[] args) throws Exception {
        KenKen ken = new KenKen(args[0]);
        ken.check();
    }
}
