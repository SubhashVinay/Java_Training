import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myIntArray=new int[5];
        int[] anotherArray=myIntArray;

        System.out.println("myIntArray = "+ Arrays.toString(myIntArray));
        System.out.println("anotherArray= "+Arrays.toString(anotherArray));

        anotherArray[0]=5;

        System.out.println("myIntArray = "+ Arrays.toString(myIntArray));
        System.out.println("anotherArray= "+Arrays.toString(anotherArray));

        modifyArray(myIntArray);

        System.out.println("myIntArray = "+ Arrays.toString(myIntArray));
        System.out.println("anotherArray= "+Arrays.toString(anotherArray));


    }


    private static void modifyArray(int[] array){
        array[1]=2;
    }
}