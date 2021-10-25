/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kerkmann.common;

import java.util.Comparator;

public class RoomNumberComperator implements Comparator<String> {

    @Override
    public int compare(String room1, String room2) {
        while (room1.length() < room2.length()) {
            room1 = "0" + room1;
        }
        while (room2.length() < room1.length()) {
            room2 = "0" + room2;
        }

        Integer r1;
        try {
            r1 = Integer.valueOf(room1);
        } catch (NumberFormatException e) {
            r1 = 0;
        }

        Integer r2;
        try {
            r2 = Integer.valueOf(room2);
        } catch (NumberFormatException e) {
            r2 = 0;
        }

        return r1.compareTo(r2);
    }
}
