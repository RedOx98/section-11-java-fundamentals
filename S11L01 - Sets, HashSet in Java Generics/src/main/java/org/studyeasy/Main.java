package org.studyeasy;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Chaand");
        set.add("John");
        set.add("Aafiya");
        set.add("Mike");
        set.add("Mia");
        set.add("Chaand");

        //System.out.println(set);

        for (String name:set ) {
            System.out.println(name);

        }
        System.out.println(set.contains("chaand"));

    }
}


