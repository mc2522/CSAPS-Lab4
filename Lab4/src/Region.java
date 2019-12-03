/**
 * Mike Cao
 * 10/10/18
 * Region.java Lab 4
 */

import java.util.ArrayList;

public abstract class Region {
    /**
     * Abstract class that provides methods and constructor for subclasses.
     */
    private int number;
    protected int target;
    protected ArrayList<Integer> values = new ArrayList<>();

    public Region(int number, int target) { //constructor for region
        this.number = number;
        this.target = target;
    }

    public void addValue(int val) { //add a value to values
        values.add(val);
    }

    public abstract boolean verify();

    @Override
    public String toString() {
        String numbers = "";
        for(int x: values) {
            numbers += x + ", ";
        }
        String s = "Region: " + number + ", values: " + numbers + " op: ";
        return s;
    }
}