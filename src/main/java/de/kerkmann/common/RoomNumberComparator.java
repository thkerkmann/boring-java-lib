/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kerkmann.common;

import java.util.Comparator;

public class RoomNumberComparator implements Comparator<String> {

    @Override
    public int compare(String room1, String room2) {

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
