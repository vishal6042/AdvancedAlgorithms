package com.practice.interviewbit.binarysearch;

/**
 * https://www.interviewbit.com/problems/allocate-books/
 * <p>
 * Given an array of integers A of size N and an integer B.
 * <p>
 * College library has N bags,the ith book has A[i] number of pages.
 * <p>
 * You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.
 * <p>
 * A book will be allocated to exactly one student.
 * Each student has to be allocated at least one book.
 * Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
 * Calculate and return that minimum possible number.
 * <p>
 * NOTE: Return -1 if a valid assignment is not possible.
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * Output Format
 * <p>
 * Return that minimum possible number
 * Constraints
 * <p>
 * 1 <= N <= 10^5
 * 1 <= A[i] <= 10^5
 * For Example
 * <p>
 * Input 1:
 * A = [12, 34, 67, 90]
 * B = 2
 * Output 1:
 * 113
 * Explanation 1:
 * There are 2 number of students. Books can be distributed in following fashion :
 * 1) [12] and [34, 67, 90]
 * Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
 * 2) [12, 34] and [67, 90]
 * Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
 * 3) [12, 34, 67] and [90]
 * Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
 * <p>
 * Of the 3 cases, Option 3 has the minimum pages = 113.
 * <p>
 * Input 2:
 * A = [5, 17, 100, 11]
 * B = 4
 * Output 2:
 * 100
 */
public class AllocateBooks {

    public static void main(String[] args) {
        AllocateBooks allocateBooks = new AllocateBooks();
        int ans = allocateBooks.books(new int[]{5, 17, 100, 11}, 3);
        System.out.println(ans);
        ans = allocateBooks.books(new int[]{31, 14, 19, 75}, 12);
        System.out.println(ans);
    }

    public int books(int[] arr, int noStudents) {
        if (noStudents > arr.length) {
            return -1;
        }
        long low = 0;
        long high = 0;
        for (int i = 0; i < arr.length; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        long ans = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossible(arr, mid, noStudents)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    private boolean isPossible(int[] arr, long mid, int noStudents) {
        int student = 1;
        int noOfPages = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid) {
                return false;
            }

            if (noOfPages + arr[i] > mid) {
                ++student;
                noOfPages = arr[i];
                if (student > noStudents) {
                    return false;
                }
            } else {
                noOfPages += arr[i];
            }
        }
        return true;
    }
}
