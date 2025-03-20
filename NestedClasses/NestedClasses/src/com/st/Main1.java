package com.st;

import com.st.domain.StoreEmployee;
import com.st.domian1.Employee1;
import com.st.domian1.Employee1Comparator;
import com.st.domian1.StoreEmployee1;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {
        List<Employee1> employeesList=new ArrayList<>();
        employeesList.add(new Employee1(10001,"Subhash",2008));
        employeesList.add(new Employee1(10050,"Abhiram",2012));
        employeesList.add(new Employee1(11089,"Guriya",2004));
        employeesList.add(new Employee1(12353,"Aadhya",2020));
        employeesList.add(new Employee1(17890,"Indu",2001));

//        var comparator=new Employee1Comparator<>();
//        employeesList.sort(comparator);

        employeesList.sort(new Employee1.Employee1Comparator<>("yearStarted"));
        employeesList.forEach(e -> System.out.println(e));


        System.out.println("Store Members!");

        List<StoreEmployee1> storeEmployeesList=new ArrayList<>(List.of(new StoreEmployee1(10015,"Suresh",2019,"Target"),
                new StoreEmployee1(10515,"Ramesh",2021,"Walmart"),
                new StoreEmployee1(10105,"Joe",2020,"Macys"),
                new StoreEmployee1(10215,"Marty",2018,"Walmart"),
                new StoreEmployee1(10322,"Bud",2016,"Target")));

        var genericEmployee=new StoreEmployee1();
        var comparator= new StoreEmployee1().new StoreComparater<>();
        storeEmployeesList.sort(comparator);

        storeEmployeesList.forEach(se -> System.out.println(se));

        System.out.println("With Pig Lating Names");
        addPigLatinName(storeEmployeesList);
    }

    public static void addPigLatinName(List<? extends StoreEmployee1> list){
        String lastName="Piggy";
        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee>{
            private String pigLatinName;
            private Employee1 originalInstance;

            public DecoratedEmployee(String pigLatinName,Employee1 originalinstance){
                this.pigLatinName=pigLatinName+" "+lastName;
                this.originalInstance=originalinstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString()+" "+pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }
        List<DecoratedEmployee> newList=new ArrayList<>(list.size());

        for (var employee:list
             ) {
            String name=employee.getName();
            String pigLatin=name.substring(1)+name.charAt(0)+"ay";
            newList.add(new DecoratedEmployee(pigLatin,employee));
        }

        newList.sort(null);

        for (var dEmployee:newList
             ) {
            System.out.println(dEmployee.originalInstance.getName()+ " "+dEmployee.pigLatinName);
        }
    }

}
