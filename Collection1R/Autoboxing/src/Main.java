import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer boxedInt=Integer.valueOf(15);
        Integer deprecatedBoxing=new Integer(15);
        int unboxedInt=boxedInt.intValue();

        Integer autoBoxed=15;
        int autoUnboxed=autoBoxed;
        System.out.println(autoBoxed.getClass().getName());

        Double resultBoxed=getLiteralDoublePrimitive();
        double resultUnboxed=getDoubleObject();

        Integer[] wrapperArray=new Integer[5];
        wrapperArray[0]=50;
        System.out.println(Arrays.toString(wrapperArray));
        System.out.println(wrapperArray[0].getClass().getName());

        Character[] characterArray={'a','b','c','d','e'};
        System.out.println(Arrays.toString(characterArray));

    }

    private static Double getDoubleObject(){
        return Double.valueOf(100.0);
    }

    private static double getLiteralDoublePrimitive(){
        return 100.0;
    }
}