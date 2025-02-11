    import java.util.Arrays;
    import java.util.Comparator;
    import java.util.List;

    public class Main {
        public record Person(String firstName,String lastName){

            @Override
            public String toString() {
                return firstName + " "+lastName;
            }
        }
        public static void main(String[] args) {
            List<Person> people= Arrays.asList(
                    new Person("Subhash","Kumar"),
                    new Person("Abhiram","Kumar"),
                    new Person("Guriya","Kumari"),
                    new Person("Swati","Aadhya"),
                    new Person("Indu","Devi")
            );

            var comparatorLastName=new Comparator<Person>(){

                @Override
                public int compare(Person o1, Person o2) {
                    return o1.lastName.compareTo(o2.lastName);
                }
            };

            people.sort(comparatorLastName);
            System.out.println(people);

            people.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));

            interface EnhancedComparator<T> extends Comparator<T>{
                int secondLevel(T o1,T o2);
            }

            var enhancedComparator= new EnhancedComparator<Person>() {

                @Override
                public int compare(Person o1, Person o2) {
                    int result=o1.lastName.compareTo(o2.lastName);
                    return result==0 ? secondLevel(o1,o2):result;
                }

                @Override
                public int secondLevel(Person o1, Person o2) {
                    return o1.firstName.compareTo(o2.firstName);
                }
            };

            people.sort(enhancedComparator);
            System.out.println(people);
        }
    }