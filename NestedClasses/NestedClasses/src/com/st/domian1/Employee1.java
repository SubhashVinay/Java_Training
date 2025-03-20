package com.st.domian1;

import java.util.Comparator;

public class Employee1 {

    public static class Employee1Comparator<T extends Employee1> implements Comparator<Employee1> {

        private String sortTye;

        public Employee1Comparator() {
            this("name");
        }

        public Employee1Comparator(String sortTye) {
            this.sortTye = sortTye;
        }

        @Override
        public int compare(Employee1 o1, Employee1 o2) {
            if(sortTye.equalsIgnoreCase("yearStarted")){
                return o1.yearStarted - (o2.yearStarted);
            }
            return o1.name.compareTo(o2.name);
        }
    }

    private int employeeId;
    private String name;
    private int yearStarted;

    Employee1(){

    }

    public Employee1(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId,name,yearStarted);
    }
}
