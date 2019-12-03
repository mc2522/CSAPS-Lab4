/**
 * Mike Cao
 * 10/10/18
 * SubtractRegion.java Lab 4
 */

import java.util.ArrayList;

public class SubtractRegion extends Region {
    /**
     * Verifies that the numbers subtract down to the target value starting from the largest number.
     * @param number: number of region
     * @param target: target value
     */
    public SubtractRegion(int number, int target) {
        super(number, target);
    }

    @Override
    public boolean verify() {
        int result = 0;
        int largest = 0;
        int value = 0;
        ArrayList<Integer> values = super.values;

        for(int i: values) { //find the largest number in values
            if(value < i) {
                value = i;
                largest = i;
            }
        }

        for(int i: values) { //decrement value by i
            if (i != largest) {
                value -= i;
            }
        }

        if(value == target) { //if target is the result, return true or false
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return super.toString() + "-, verify " + verify();
    }
}
