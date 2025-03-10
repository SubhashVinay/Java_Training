import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Integer five=5;
        Integer[] intArray={0,5,10,-50,50};

        for (int i:intArray
             ) {
            int val=five.compareTo(i);
            System.out.printf("%d %s %d : compareTo=%d %n",five,(val == 0 ?"==":val>0?">":"<"),i,val);
        }

        String banana="banana";
        String [] fruit={"apple","banana","pear","BANANA"};

        for (String s :fruit
             ) {
            int val=banana.compareTo(s);
            System.out.printf("%s %s %s : compareTo= %d %n",banana,(val==0 ? "==":val>0?">":"<"),s,val);
        }

        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));

       Student tim=new Student("Tim");
       Student[] students={new Student("Zach"),new Student("Tim"),new Student("Ann")};

       Arrays.sort(students);
       System.out.println(Arrays.toString(students));
//        for (Student student:students) {
//            System.out.println(tim.compareTo(student));
//        }
        System.out.println("result = "+tim.compareTo(new Student("Baker")));

        Comparator<Student> studentComparator=new StudentGPAComparator();
        Arrays.sort(students,studentComparator.reversed());
        System.out.println(Arrays.toString(students));
    }



}