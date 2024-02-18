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
     * Advances to the next trimester.
     * - Checks if all students have acquired the minimum required credit hours.
     * - Moves current courses of students to taken courses list.
     * - Clears the list of current courses and resets current credit for all students.
     */
    public void nextTrimester() {
        // Implementation details commented out
        count += 1;
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
}

