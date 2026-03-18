package algorithms;

import java.util.*;

public class Solution {

    public int solution(String[] A, String[] B, int[] C) {

        int n = A.length;
        int BASE_YEAR = 1900;

        // Convert "MM-YYYY" → month index
        java.util.function.Function<String, Integer> toIndex = s -> {
            int month = Integer.parseInt(s.substring(0, 2));
            int year  = Integer.parseInt(s.substring(3, 7));
            return (year - BASE_YEAR) * 12 + (month - 1);
        };

        int minIdx = Integer.MAX_VALUE, maxIdx = Integer.MIN_VALUE;
        int[] start = new int[n];
        int[] end   = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = toIndex.apply(A[i]);
            end[i]   = toIndex.apply(B[i]);
            minIdx = Math.min(minIdx, start[i]);
            maxIdx = Math.max(maxIdx, end[i]);
        }

        int size = maxIdx - minIdx + 2;
        long[] diff = new long[size];

        // Range add using difference array
        for (int i = 0; i < n; i++) {
            int s = start[i] - minIdx;
            int e = end[i]   - minIdx;
            diff[s] += C[i];
            diff[e + 1] -= C[i];
        }

        long runningExpense = 0;
        long prefixExpense  = 0;
        long maxIncome = 0;
        int months = 0;

        for (int i = 0; i < size - 1; i++) {
            runningExpense += diff[i];   // expense this month
            prefixExpense  += runningExpense;
            months++;

            long needed = (prefixExpense + months - 1) / months; // ceil
            maxIncome = Math.max(maxIncome, needed);
        }

        return (int) maxIncome;
    }

    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        Solution sol = new Solution();

        // ✅ Test Case 1
        String[] A1 = {"03-2021", "04-2021", "05-2021"};
        String[] B1 = {"03-2021", "05-2021", "05-2021"};
        int[] C1 = {20, 10, 15};
        System.out.println("Test 1 Expected: 20 | Got: " + sol.solution(A1, B1, C1));

        // ✅ Test Case 2
        String[] A2 = {"10-2020", "01-2020", "02-2020", "06-2021"};
        String[] B2 = {"07-2021", "03-2020", "10-2020", "07-2021"};
        int[] C2 = {1, 10, 2, 90};
        System.out.println("Test 2 Expected: 13 | Got: " + sol.solution(A2, B2, C2));

        // ✅ Test Case 3
        String[] A3 = {"01-1900", "12-2099", "11-2099", "01-1901"};
        String[] B3 = {"12-1901", "12-2099", "12-2100", "01-1902"};
        int[] C3 = {1, 1000, 998, 1};
        System.out.println("Test 3 Expected: 7 | Got: " + sol.solution(A3, B3, C3));
    }
}