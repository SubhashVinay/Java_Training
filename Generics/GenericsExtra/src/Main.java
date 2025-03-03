import com.st.model.LPAStudent;
import com.st.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int studentCount=10;
        List<Student> students=new ArrayList<>();
        for (int i=0;i<studentCount;i++){
            students.add(new Student());
        }
        students.add(new LPAStudent());
        printList(students);


        List<LPAStudent> lpaStudents=new ArrayList<>();
        for (int i=0;i<studentCount;i++){
            lpaStudents.add(new LPAStudent());
        }
        printList(lpaStudents);
    }

    public static <T> void printList(List<T> students){
        for (var student:students) {
            System.out.println(student);
        }
        System.out.println();
    }
}