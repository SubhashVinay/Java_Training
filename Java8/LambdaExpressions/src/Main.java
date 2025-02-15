import com.st.Operation;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        List<String> list=new ArrayList<>(List.of("alpha","bravo","charlie","delta"));

        for (String s :list
             ) {
            System.out.println(s);
        }

        System.out.println("-----------------------");

        list.forEach(s -> System.out.println(s));

        System.out.println("----------------");
        String prefix="nato";
        list.forEach(s -> {
            char first=s.charAt(0);
            System.out.println(prefix+" "+s + " means "+first);
        });
        int result=calculator((a,b) -> a+b,10,5);
        var result2=calculator((a,b) -> a/b,10.0,2.5);
        var result3=calculator((a,b) -> a.toUpperCase()+" "+b.toUpperCase(),"Ralph","Lauren");

        var coords= Arrays.asList(
                new double[]{47.2160,-95.2348},
                new double[]{29.1566,-89.2495},
                new double[]{35.1556,-90.0659}
        );
        coords.forEach(c -> System.out.println(Arrays.toString(c)));

        BiConsumer<Double,Double> biConsumer=(lat,lang) -> System.out.printf("[lat:%.3f lon:%.3f]%n",lat,lang);
        var firstPoint=coords.get(0);
        processPoint(firstPoint[0],firstPoint[1],biConsumer);

        System.out.println("------------------------------");

        coords.forEach(s -> processPoint(s[0],s[1],biConsumer));

        System.out.println("-------------------");
        list.forEach(s -> System.out.println(s));
        var removed=list.removeIf(s -> s.startsWith("b"));
        System.out.println(removed);
        list.forEach(s -> System.out.println(s));

        list.replaceAll(s -> s.charAt(0)+"-"+s.toUpperCase());
        System.out.println("-----------------");
        list.forEach(s -> System.out.println(s));

        String[] emptyStrings=new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings,",");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings,(i) -> ""+(i+1)+". "+
                switch (i){
                    case 0 -> "one";
                    case 1 -> "two";
                    case 2 -> "three";
                    default -> "";
                });
        System.out.println(Arrays.toString(emptyStrings));

        String[] names={"Ann","Bob","Carol","David","Ed","Fred"};
        String[] randomNames=randomlySelectedValues(15,names,() -> new Random().nextInt(0,names.length));
        System.out.println(Arrays.toString(randomNames));

    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2){
        T result= function.apply(value1,value2);
        System.out.println("Result Of Operation: "+result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> function){
        function.accept(t1,t2);
    }

    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> supplier){
        String[] selectedValues=new String[count];
        for(int i=0;i<count;i++){
            selectedValues[i]=values[supplier.get()];
        }
        return selectedValues;
    }
}