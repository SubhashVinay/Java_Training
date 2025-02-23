import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        String name="Subhash";
        Function<String,String> uCase=String::toUpperCase;
        System.out.println(uCase.apply(name));

        Function<String,String> lastName=s -> s.concat(" Kumar");
        Function<String,String> uCaseLastName=uCase.andThen(lastName);

        System.out.println(uCaseLastName.apply(name));

        uCaseLastName=uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));

        Function<String,String[]> f0=uCase
                .andThen(s -> s.concat(" kumar"))
                .andThen(s -> s.split(" "));
        System.out.println(Arrays.toString(f0.apply("Subhash")));

        Function<String,String> f1=uCase
                .andThen(s -> s.concat(" kumar"))
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toUpperCase()+","+s[0]);
        System.out.println(f1.apply("Subhash"));

        Function<String,Integer> f2=uCase
                .andThen(s -> s.concat(" kumar"))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join(", ",s))
                .andThen(String::length);
        System.out.println(f2.apply("Subhash"));

        String [] names={"Ann","Bob","Carol"};

        Consumer<String> c1=s -> System.out.print(s.charAt(0));
        Consumer<String> c2= System.out::println;

        Arrays.asList(names).forEach(c1
                .andThen(s -> System.out.print(" - "))
                .andThen(c2));

        Predicate<String> p1=s -> s.equals("SUBHASH");
        Predicate<String> p2=s -> s.equalsIgnoreCase("Subhash");
        Predicate<String> p3=s -> s.startsWith("S");
        Predicate<String> p4=s -> s.endsWith("e");

        Predicate<String> combinedOR=p1.or(p2);
        System.out.println("combinedOR = "+combinedOR.test(name));

        Predicate<String> combinedAND=p1.and(p2);
        System.out.println("combinedAND = "+combinedAND.test(name));

        Predicate<String> combined=p3.and(p4).negate();
        System.out.println("combined = "+combined.test(name));

        record Person(String firstName,String lastName){}

        List<Person> list=new ArrayList<>(Arrays.asList(
                new Person("Peter","Pan"),
                new Person("Peter","PumpkinEater"),
                new Person("Minnie","Mouse"),
                new Person("Mickey","Mouse")
        ));

        list.sort((o1,o2) -> o1.lastName.compareTo(o2.lastName));
        list.forEach(System.out::println);

        System.out.println("---------------------------------");
        list.sort(Comparator.comparing(Person::lastName));
        list.forEach(System.out::println);

        System.out.println("---------------------------------");
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName));
        list.forEach(System.out::println);

        System.out.println("---------------------------------");
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName).reversed());
        list.forEach(System.out::println);

    }
}