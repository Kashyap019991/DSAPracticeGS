package org.kas.demos.Prac.CoderpatQuest.DAY2_17_09;

/* Problem Name is &&& Dist. Between Strings &&& PLEASE DO NOT REMOVE THIS LINE. */
public class ShortestDistanceNew {
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
        
        double minDistance = Double.MAX_VALUE; 
        double word1Loc = -1.0;
        double word2Loc = -1.0;
        
        int index = 0;

        // Clean input words once outside the loop for efficiency
        // This is crucial: the test expects us to treat "layout." as the word "layout"
        String cleanWord1Search = word1.replaceAll("[.,]", "").toLowerCase();
        String cleanWord2Search = word2.replaceAll("[.,]", "").toLowerCase();


        for (String word : words) {
            // Clean the current token from the document for comparison
            String cleanTokenInDoc = word.replaceAll("[.,]", "").toLowerCase();

            if (cleanTokenInDoc.equals(cleanWord1Search)) {
                // Calculate midpoint using the *original* word length found in the document
                word1Loc = index + (word.length() / 2.0); 
            } else if (cleanTokenInDoc.equals(cleanWord2Search)) {
                // Calculate midpoint using the *original* word length found in the document
                word2Loc = index + (word.length() / 2.0);
            } 
            
            if (word1Loc >= 0 && word2Loc >= 0) {
                double current = Math.abs(word2Loc - word1Loc);
                minDistance = Math.min(minDistance, current);
            }
            
            index += word.length() + 1; 
        }

        if (word1Loc == -1.0 || word2Loc == -1.0) {
            return -1.0;
        }
        
        return minDistance; 
    }

    /**
     * Returns true if the tests pass. Otherwise, false.
     */
    public static boolean doTestsPass() {
        System.out.println("Running tests...");
        final double DELTA = 0.000001; 
        
        boolean test1 = Math.abs(shortestDistance(DOCUMENT, "and", "graphic") - 6d) < DELTA;
        boolean test2 = Math.abs(shortestDistance(DOCUMENT, "transfer", "it") - 14d) < DELTA;
        boolean test3 = Math.abs(shortestDistance(DOCUMENT, "layout.", "It") - 6d) < DELTA;
        boolean test4 = Math.abs(shortestDistance(DOCUMENT, "Design", "filler") - 25d) < DELTA;
        boolean test5 = Math.abs(shortestDistance(DOCUMENT, "It", "transfer") - 14d) < DELTA;
        boolean test6 = Math.abs(shortestDistance(DOCUMENT, "of", "lorem") - 4.5) < DELTA;
        boolean test7 = Math.abs(shortestDistance(DOCUMENT, "thiswordisnotthere", "lorem") - (-1d)) < DELTA;
        
        System.out.println("Test 1 (and/graphic): " + test1);
        System.out.println("Test 2 (transfer/it): " + test2);
        System.out.println("Test 3 (layout./It): " + test3); // Should pass
        System.out.println("Test 4 (Design/filler): " + test4);
        System.out.println("Test 5 (It/transfer): " + test5);
        System.out.println("Test 6 (of/lorem): " + test6);
        System.out.println("Test 7 (missing word): " + test7);

        return test1 && test2 && test3 && test4 && test5 && test6 && test7;
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }

    private static final String DOCUMENT = """
In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements of a document or visual presentation. Replacing meaningful content that could be distracting with placeholder text may allow viewers to focus on graphic aspects such as font, typography, and page layout. It also reduces the need for the designer to come up with meaningful text, as they can instead use hastily generated lorem ipsum text. The lorem ipsum text is typically a scrambled section of De finibus bonorum et malorum, a 1st-century BC Latin text by Cicero, with words altered, added, and removed to make it nonsensical, improper Latin. A variation of the ordinary lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which employed it in graphics and word processing templates for its desktop publishing program, PageMaker, for the Apple Macintosh. A common form of lorem ipsum reads: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.""".replace('\n', ' ');
}
