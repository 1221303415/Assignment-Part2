/**
 * The Trimester class represents a trimester in the academic calendar.
 */
public class Trimester {
    private int count = 0; // The count of trimesters
    private int minCredit = 3; // The minimum credit hours required in a trimester
    private int maxCredit = 12; // The maximum credit hours allowed in a trimester

    /**
     * Retrieves the count of trimesters.
     * @return The count of trimesters.
     */
    public int getCount() {
        return count;
    }

    /**
     * Retrieves the minimum credit hours required in a trimester.
     * @return The minimum credit hours required.
     */
    public int getMinCredit() {
        return minCredit;
    }

    /**
     * Retrieves the maximum credit hours allowed in a trimester.
     * @return The maximum credit hours allowed.
     */
    public int getMaxCredit() {
        return maxCredit;
    }

    public void addCount() {
        count += 1;
    }
}

