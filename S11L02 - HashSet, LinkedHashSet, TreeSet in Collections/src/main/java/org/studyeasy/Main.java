package org.studyeasy;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        for (int i = 30; i >=0 ; i--) {
            set.add("A"+i);
        }
        for (String x:set ) {
            System.out.println(x);
        }


    }
}


