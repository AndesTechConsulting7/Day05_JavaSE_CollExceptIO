package org.andestech.learning.sber2020;

import static org.andestech.learning.sber2020.utils.ABSUtils.*;

import java.util.*;

public class CollectionTest {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();

        set1.add(123);set1.add(77);
        set1.add(-22);set1.add(5);
        set1.add(123);set1.add(19);
        printColl(set1);
        // Задача об удалении дубликатов
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(
                new String[]{
                        "AA", "BB", "AA", "CC", "B","NN", "IO", "CC", "CC"
                }
        ));
        printColl(list);

        List<String> listDeduble = new ArrayList<>();
        listDeduble.addAll(new HashSet<>(list));

        printColl(listDeduble);

    }
}
