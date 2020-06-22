package com.practice.interviewbit.math;

/**
 * https://www.interviewbit.com/problems/city-tour/
 * <p>
 * There are A cities numbered from 1 to A. You have already visited M cities, the indices of which are given in an array B of M integers.
 * <p>
 * If a city with index i is visited, you can visit either the city with index i-1 (i >= 2) or the city with index i+1 (i < A) if they are not already visited.
 * Eg: if N = 5 and array M consists of [3, 4], then in the first level of moves, you can either visit 2 or 5.
 * <p>
 * You keep visiting cities in this fashion until all the cities are not visited.
 * Find the number of ways in which you can visit all the cities modulo 10^9+7.
 * <p>
 * Input Format
 * <p>
 * The 1st argument given is an integer A, i.e total number of cities.
 * The 2nd argument given is an integer array B, where B[i] denotes ith city you already visited.
 * Output Format
 * <p>
 * Return an Integer X % (1e9 + 7), number of ways in which you can visit all the cities.
 * Constraints
 * <p>
 * 1 <= A <= 1000
 * 1 <= M <= A
 * 1 <= B[i] <= A
 * For Example
 * <p>
 * Input:
 * A = 5
 * B = [2, 5]
 * Output:
 * 6
 * <p>
 * Explanation:
 * All possible ways to visit remaining cities are :
 * 1. 1 -> 3 -> 4
 * 2. 1 -> 4 -> 3
 * 3. 3 -> 1 -> 4
 * 4. 3 -> 4 -> 1
 * 5. 4 -> 1 -> 3
 * 6. 4 -> 3 -> 1
 */
public class CityTour {

    public static void main(String[] args) {
        CityTour tour = new CityTour();
        int sol = tour.solve(5, new int[]{2, 5});
        System.out.println(sol);
    }

    int count = 0;

    public int solve(int A, int[] B) {
        if (A == 0) {
            return 0;
        }
        int[] visited = new int[A + 1];
        for (int i = 0; i < B.length; i++) {
            visited[B[i]] = 1;
        }
        doDFS(visited, B);
        return count;
    }

    private void doDFS(int[] visited, int[] B) {
        for (int i = 0; i < B.length; i++) {
            dfsRec(visited, B[i]);
        }
    }

    private void dfsRec(int[] visited, int i) {
        if (allVisited(visited)) {
            count++;
            return;
        }
        if (isSafe(i - 1, visited)) {
            visited[i - 1] = 1;
            dfsRec(visited, i - 1);
        }
        if (isSafe(i + 1, visited)) {
            visited[i + 1] = 1;
            dfsRec(visited, i + 1);
        }
    }

    private boolean allVisited(int[] visited) {
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSafe(int i, int[] visited) {
        return i > 0 && i < visited.length && visited[i] == 0;
    }
}
