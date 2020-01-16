package com.kvikesh800gmail.relativlayoutjava;

import java.util.ArrayList;
import java.util.Collections;

public class LoadData {

    public static ArrayList<Integer> init(String type) {
        ArrayList<Integer> list = new ArrayList<>();
        int i;
        switch (type) {
            case "c1":
            case "c9":
                for (i = 1; i < 90; i++) {
                    list.add(i);
                }
                Collections.shuffle(list);
            break;
            case "c2":
            case "c3":
            case "c4":
                for (i = 1; i < 25; i++) {
                    list.add(i);
                }
                Collections.shuffle(list);
            break;
            case "c5":
                for (i = 1; i < 30; i++) {
                    list.add(i);
                }
                Collections.shuffle(list);
            break;
            case "c6":
                for (i = 1; i < 27; i++) {
                    list.add(i);
                }
                Collections.shuffle(list);
            break;
            case "c7":
                for (i = 1; i < 21; i++) {
                    list.add(i);
                }
                Collections.shuffle(list);
            break;
            case "c8":
                for (i = 1; i < 26; i++) {
                    list.add(i);
                }
                Collections.shuffle(list);
            break;
            case "c10":
                for (i = 1; i < 40; i++) {
                    list.add(i);
                }
                Collections.shuffle(list);
        }
        return list;
    }
}
