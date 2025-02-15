import com.st.domain.Employee;
import com.st.domain.EmployeeComparator;
import com.st.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeesList=new ArrayList<>();
        employeesList.add(new Employee(10001,"Subhash",2008));
        employeesList.add(new Employee(10050,"Abhiram",2012));
        employeesList.add(new Employee(11089,"Guriya",2004));
        employeesList.add(new Employee(12353,"Aadhya",2020));
        employeesList.add(new Employee(17890,"Indu",2001));

//        var employeeComparator=new EmployeeComparator<>();
//        employeesList.sort(employeeComparator);

        employeesList.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());

        for (Employee e:employeesList
             ) {
            System.out.println(e);
        }

        System.out.println("Store Members!");

        List<StoreEmployee> storeEmployeesList=new ArrayList<>(List.of(new StoreEmployee(10015,"Suresh",2019,"Target"),
                new StoreEmployee(10515,"Ramesh",2021,"Walmart"),
                new StoreEmployee(10105,"Joe",2020,"Macys"),
                new StoreEmployee(10215,"Marty",2018,"Walmart"),
                new StoreEmployee(10322,"Bud",2016,"Target")));

        //var genericEmployee=new StoreEmployee();
        var comparator=new StoreEmployee().new StoreComparator<>();
        storeEmployeesList.sort(comparator);

        for (StoreEmployee se:storeEmployeesList
             ) {
            System.out.println(se);
        }
    }
}