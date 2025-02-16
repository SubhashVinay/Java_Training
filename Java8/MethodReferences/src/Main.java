import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class PlainOld{

    private static int intVal=1;

    int id;

    PlainOld(){
        id=PlainOld.intVal++;
        System.out.println("PlainOld Object Created with id value "+id);
    }


}
public class Main {
    public static void main(String[] args) {

        List<String> list=new ArrayList<>(List.of("Anna","Bob","Chuck","Dave"));
        list.forEach(System.out::println);

        calculator(Integer::sum,10,20);
        calculator(Double::sum,4.5,5.5);

        Supplier<PlainOld> plainOldSupplier= PlainOld::new;
        plainOldSupplier.get();
        plainOldSupplier.get();

        calculator(String::concat,"Hello","World");

        BinaryOperator<String> b1=String::concat;
        BiFunction<String,String,String> b2=String::concat;
        UnaryOperator<String> u1=String::toUpperCase;

        System.out.println(b1.apply("Hello","World"));
        System.out.println(b2.apply("Hello","World"));
        System.out.println(u1.apply("Hello"));

        String result="Hello".transform(u1);
        System.out.println("Result: "+result);
        result=result.transform(String::toLowerCase);
        System.out.println("Result: "+result);
    }

    public static <T> void calculator(BinaryOperator<T> function,T val1,T val2){
        T result= function.apply(val1,val2);
        System.out.println("Result Of Operation: "+result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference,int count){
        PlainOld[] array=new PlainOld[count];
        Arrays.setAll(array , i -> reference.get());
        return array;
    }
}