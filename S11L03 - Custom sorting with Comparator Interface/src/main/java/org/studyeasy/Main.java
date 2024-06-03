package org.studyeasy;
import java.util.Set;
import java.util.TreeSet;

class Data<K extends Integer,V extends String>{
    private K key;
    private V value;

    public Data(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Data{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Set<Data<Integer, String >> set = new TreeSet<>();
        set.add(new Data<>(1,"Chaand"));
        set.add(new Data<>(2,"Ashlin"));
        set.add(new Data<>(3,"Mike"));
        set.add(new Data<>(4,"John"));
        set.add(new Data<>(5,"John"));
        set.add(new Data<>(1,"Chaand"));

        for (Data data: set) {
            System.out.println(data);
        }


    }
}


