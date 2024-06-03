package org.studyeasy;


import java.util.*;

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
        String code1 = sectionNo.concat(lectureNo);
        String code2 = o.getSectionNo().concat(o.getLectureNo());
        return code1.compareTo(code2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Code code = (Code) o;
        return Objects.equals(sectionNo, code.sectionNo) && Objects.equals(lectureNo, code.lectureNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectionNo, lectureNo);
    }
}

public class Main {
    public static void main(String[] args) {

        Map<Code ,String> map = new TreeMap<>();
        map.put(new Code("S11", "11"), "Chaand");
        map.put(new Code("S11", "22"), "Rahul");
        map.put(new Code("S11", "00"), "Alex");
        map.put(new Code("S11", "05"), "John");
        map.put(new Code("S10", "10"), "Aafiya");
        map.put(new Code("S11", "10"), "Chaand");

        Code code = null;

        for (Code key: map.keySet()) {
            if(map.get(key).equals("Alex")){
                code = key;
                break;
            }
        }
        System.out.println(code);

    }
}


