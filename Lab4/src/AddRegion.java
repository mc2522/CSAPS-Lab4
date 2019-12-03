/**
 * Mike Cao
 * 10/10/18
 * AddRegion.java Lab 4
 */

import java.util.ArrayList;

public class AddRegion extends Region {
    /**
     * Verifies that the numbers add up to the target value.
     * @param number: the number of the region
     * @param target: the target value
     */
    public AddRegion(int number, int target) {
        super(number, target); //super constructor
    }

    @Override
    public boolean verify() {
        int result = 0;
        ArrayList<Integer> values = super.values;

        for (int i : values) { //increment the result by i
            result += i;
        }

        if (result == target) {
            return true;
        } else {//if target is the result, return true or false
            return false;
        }
    }

    public String toString() {
        return super.toString() + "+, verify " + verify();
    }

}
