package com.practice.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/hotel-bookings-possible/
 * <p>
 * A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .
 * <p>
 * Input:
 * <p>
 * <p>
 * First list for arrival time of booking.
 * Second list for departure time of booking.
 * Third is K which denotes count of rooms.
 * <p>
 * Output:
 * <p>
 * A boolean which tells whether its possible to make a booking.
 * Return 0/1 for C programs.
 * O -> No there are not enough rooms for N booking.
 * 1 -> Yes there are enough rooms for N booking.
 * Example :
 * <p>
 * Input :
 * Arrivals :   [1 3 5]
 * Departures : [2 6 8]
 * K : 1
 * <p>
 * Return : False / 0
 * <p>
 * At day = 5, there are 2 guests in the hotel. But I have only one room.
 */
public class HotelBooking {
    public static void main(String[] args) {
        System.out.println(new HotelBooking().hotel(new ArrayList<>(Arrays.asList(1, 3, 5)),
                new ArrayList<>(Arrays.asList(2, 6, 8)), 1));

    }

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);

        int i = 0;
        int j = 0;
        int c = 0;
        while (i < arrive.size() && j < depart.size()) {
            if (arrive.get(i) < depart.get(j)) {
                c++;
                i++;
            } else {
                c--;
                j++;
            }
            if (c > K) {
                return false;
            }
        }
        return true;
    }
}
