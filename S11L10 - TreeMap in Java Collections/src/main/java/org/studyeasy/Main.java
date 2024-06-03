package org.studyeasy;

import java.util.Map;
import java.util.TreeMap;

class Code implements Comparable<Code>{
    private String sectionNo;
    private String lectureNo;

    public Code(String sectionNo, String lectureNo) {
        this.sectionNo = sectionNo;
        this.lectureNo = lectureNo;
    }

    public String getSectionNo() {
        return sectionNo;
    }

    public String getLectureNo() {
        return lectureNo;
    }

    @Override
    public String toString() {
        return "Code{" +
                "sectionNo='" + sectionNo + '\'' +
                ", lectureNo='" + lectureNo + '\'' +
                '}';
    }

    @Override
    public int compareTo(Code o) {
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Map<Code ,String> map = new TreeMap<>();
        map.put(new Code("S11", "10"), "Chaand");
        map.put(new Code("S11", "10"), "Rahul");
        map.put(new Code("S11", "10"), "Alex");
        map.put(new Code("S11", "10"), "John");
        map.put(new Code("S11", "10"), "Aafiya");
        map.put(new Code("S11", "10"), "Chaand");

        System.out.println(map);




    }
}


