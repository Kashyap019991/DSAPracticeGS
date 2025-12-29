package org.kas.demos.Prac.CoderpatQuest.DAY2_17_09;

/* Problem Name is &&& Dist. Between Strings &&& PLEASE DO NOT REMOVE THIS LINE. */


public class ShortestDistanceNew0 {

    /*
     * == Instructions ==
     *
     * Debug why the included test cases aren't succeeding and account for them in the code
     *
     * A description of the expected behaviour is given below
     */

    /**
     * Given two words returns the shortest distance between their two midpoints in number of characters
     * Words can appear multiple times in any order and should be case insensitive.
     * <p>
     * E.g. for the document="This is a sample document we just made up"
     * shortestDistance( document, "we", "just" ) == 4
     * shortestDistance( document, "is", "a" ) == 2.5
     * shortestDistance( document, "is", "not" ) == -1
     */
    public static double shortestDistance(String document, String word1, String word2) {
        String[] words = document.split(" ");
        System.out.println("processing for word1:" + word1 + " and word2:" + word2);
        int index = 0;
        int shortest = document.length();
        int word1Loc = -1;
        int word2Loc = -1;

        for (String word : words) {
            if (word.equalsIgnoreCase(word1) || word.equalsIgnoreCase(word1 + ".") || word.equalsIgnoreCase(word1 + ",")) {
                word1Loc = index + (word.length() / 2);
            } else if (word.equalsIgnoreCase(word2) || word.equalsIgnoreCase(word2 + ".") || word.equalsIgnoreCase(word2 + ",")) {
                word2Loc = index + (word.length() / 2);
            }

            if (word1Loc > 0 && word2Loc > 0) {
                int current = Math.abs(word2Loc - word1Loc);
                shortest = Math.min(shortest, current);
            }

            index += word.length() + 1;
        }
        System.out.println("Word1 loc" + word1Loc + " and word2loc:" + word2Loc);
        if (word1Loc == -1 || word2Loc == -1) {
            return -1;
        }
        System.out.println("shortest for word1:" + word1 + " and word2:" + word2 + " is " + shortest);
        return Double.valueOf(shortest);
    }

    /**
     * Returns true if the tests pass. Otherwise, false.
     */
    public static boolean doTestsPass() {
        // todo: implement more tests if you'd like
//        System.out.println("value:"+Math.abs(shortestDistance(DOCUMENT, "of", "lorem") - 4.5));
        System.out.println(0.5 < 0.000001);
        return
                shortestDistance(DOCUMENT, "and", "graphic") == 6d
                        &&
                        shortestDistance(DOCUMENT, "transfer", "it") == 14d
                        &&
                        shortestDistance(DOCUMENT, "layout.", "It") == 6d
                        &&
                        shortestDistance(DOCUMENT, "Design", "filler") == 25d
                        &&
                        shortestDistance(DOCUMENT, "It", "transfer") == 14d
                        &&
                        Math.abs(shortestDistance(DOCUMENT, "of", "lorem") - 4.5) < 0.000001
                        &&
                        shortestDistance(DOCUMENT, "thiswordisnotthere", "lorem") == -1d;
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        // Run the tests
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }

    private static final String DOCUMENT = """
            In publishing and graphic design, lorem ipsum is a
            filler text commonly used to demonstrate the graphic elements of a
            document or visual presentation. Replacing meaningful content that
            could be distracting with placeholder text may allow viewers to focus
            on graphic aspects such as font, typography, and page layout. It also
            reduces the need for the designer to come up with meaningful text, as
            they can instead use hastily generated lorem ipsum text. The lorem
            ipsum text is typically a scrambled section of De finibus bonorum et
            malorum, a 1st-century BC Latin text by Cicero, with words altered,
            added, and removed to make it nonsensical, improper Latin. A variation
            of the ordinary lorem ipsum text has been used in typesetting since
            the 1960s or earlier, when it was popularized by advertisements for
            Letraset transfer sheets. It was introduced to the Information Age in
            the mid-1980s by Aldus Corporation, which employed it in graphics and
            word processing templates for its desktop publishing program,
            PageMaker, for the Apple Macintosh. A common form of lorem ipsum
            reads: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
            minim veniam, quis nostrud exercitation ullamco laboris nisi ut
            aliquip ex ea commodo consequat. Duis aute irure dolor in
            reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
            pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
            culpa qui officia deserunt mollit anim id est laborum.""".replace('\n', ' ');
}
