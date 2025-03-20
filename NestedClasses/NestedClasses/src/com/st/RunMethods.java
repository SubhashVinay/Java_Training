package com.st;

import com.st.domian1.Employee1;
import com.st.domian1.Employee1Comparator;
import com.st.domian1.StoreEmployee1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {
    public static void main(String[] args) {

        List<StoreEmployee1> storeEmployeesList=new ArrayList<>(List.of(new StoreEmployee1(10015,"Suresh",2019,"Target"),
                new StoreEmployee1(10515,"Ramesh",2021,"Walmart"),
                new StoreEmployee1(10105,"Joe",2020,"Macys"),
                new StoreEmployee1(10215,"Marty",2018,"Walmart"),
                new StoreEmployee1(10322,"Bud",2016,"Target")));

        var c0=new Employee1Comparator<StoreEmployee1>();
        var c1=new Employee1.Employee1Comparator<StoreEmployee1>();
        var c2=new StoreEmployee1().new StoreComparater<StoreEmployee1>();

        class NameSort<T> implements Comparator<StoreEmployee1>{

            @Override
            public int compare(StoreEmployee1 o1, StoreEmployee1 o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }
        var c3=new NameSort<StoreEmployee1>();
        var c4=new Comparator<StoreEmployee1>(){

            @Override
            public int compare(StoreEmployee1 o1, StoreEmployee1 o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        sortIt(storeEmployeesList,c0);
        sortIt(storeEmployeesList,c1);
        sortIt(storeEmployeesList,c2);
        sortIt(storeEmployeesList,c3);
        sortIt(storeEmployeesList,c4);
        sortIt(storeEmployeesList, (o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    public static<T> void sortIt(List<T> list, Comparator<? super T> comparator){
        System.out.println("Sorting With Comparator: "+comparator.toString());
        list.sort(comparator);
        for (var employee:list
             ) {
            System.out.println(employee);
        }
    }
}
