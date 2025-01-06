import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer boxedInteger=Integer.valueOf(15);//preferred but unneessary
        Integer boxed=new Integer(15);//Deprecated
        int unboxedInteger=boxedInteger.intValue(); //unnecessary

        Integer autoBoxed=15;
        int autoUnboxed=autoBoxed;
        System.out.println(autoBoxed.getClass().getName());
        //System.out.println(autoUnboxed.getClass().getName());

        Double resultBoxed=getLiteralDoublePrimitive();
        double resultUnboxed=getDoubleObject();

        Integer[] wrapperArray=new Integer[5];
        wrapperArray[0]=15;
        System.out.println(Arrays.toString(wrapperArray));
        System.out.println(wrapperArray[0].getClass().getName());

        Character[] characterArray={'a','b','c','d','e'};
        System.out.println(Arrays.toString(characterArray));

        var ourList=getList(1,2,3,4,5);
        System.out.println(ourList);

    }
    private static ArrayList<Integer> getList(Integer ... varArgs){
        ArrayList<Integer> aList=new ArrayList<>();
        for (int i :varArgs
             ) {
            aList.add(i);
        }
        return aList;
    }

    private static int returnAnInt(Integer i){
        return i;
    }

    private static Integer returnInteger(int i){
        return i;
    }

    private static Double getDoubleObject(){
        return Double.valueOf(1000.0);
    }

    private static Double getLiteralDoublePrimitive(){
        return 100.0;
    }
}