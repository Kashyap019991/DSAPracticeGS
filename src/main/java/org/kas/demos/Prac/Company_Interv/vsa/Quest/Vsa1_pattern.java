package org.kas.demos.Prac.Company_Interv.vsa.Quest;

public class Vsa1_pattern {

    static String[] solution(int n) {
        String[] result = new String[n];

        // Build first & last row
        StringBuilder border = new StringBuilder();
        for (int i = 0; i < n; i++) {
            border.append('*');
        }
        result[0] = border.toString();
        result[n - 1] = border.toString();

        // Build middle rows
        for (int i = 1; i < n - 1; i++) {
            StringBuilder row = new StringBuilder();
            row.append('*');

            for (int j = 0; j < n - 2; j++) {
                row.append(' ');
            }

            row.append('*');
            result[i] = row.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 8;
        String[] result = solution(n);
        for (String line : result) {
            System.out.println(line);
        }
    }

}
