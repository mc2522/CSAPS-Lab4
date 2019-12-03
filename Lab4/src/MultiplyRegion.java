/**
 * Mike Cao
 * 10/10/18
 * MultiplyRegion.java Lab 4
 */

import java.util.ArrayList;

public class MultiplyRegion extends Region {
    /**
     * Verifies that the numbers multiply up to the target value.
     * @param number: number of the region
     * @param target: target value
     */
    public MultiplyRegion(int number, int target) {
        super(number, target); //super constructor
    }

    @Override
    public boolean verify() {
        int result = 0;
        ArrayList<Integer> values = super.values;

        for(int i: values) {
            result *= i; //multiplies result by i
        }

        if(result == target) { //if target is the result, return true or false
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return super.toString() + "*, verify " + verify();
    }
}
