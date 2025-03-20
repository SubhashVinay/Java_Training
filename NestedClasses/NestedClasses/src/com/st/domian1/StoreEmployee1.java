package com.st.domian1;

import java.util.Comparator;

public class StoreEmployee1 extends Employee1{

    private String store;

    public StoreEmployee1() {
    }

    public StoreEmployee1(int employeeId, String name, int yearStarted, String store) {
        super(employeeId, name, yearStarted);
        this.store = store;
    }

    @Override
    public String toString() {
        return "%-8s %s".formatted(store,super.toString());
    }

    public class StoreComparater<T extends StoreEmployee1> implements Comparator<StoreEmployee1>{

        @Override
        public int compare(StoreEmployee1 o1, StoreEmployee1 o2) {
            int result=o1.store.compareTo(o2.store);
            if(result == 0){
                return new Employee1.Employee1Comparator<>("yearStarted").compare(o1,o2);
            }
            return result;
        }
    }
}
