import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] intArr={5,4,3,2,1,78,90,34};
        System.out.println(Arrays.toString(reverseCopy(intArr)));

        int[] inputArray=returnArray();
        System.out.println(Arrays.toString(inputArray));

        int returnedMin=findMin(inputArray);
        System.out.println("Min Element is "+returnedMin);

        System.out.println("Input Array before Reversing "+Arrays.toString(inputArray));
        reverseAnArray(inputArray);
        System.out.println("After Reversing the Array "+Arrays.toString(inputArray));
    }

    private static int[] returnArray(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a list of integers,seperated by commas:");
        String input=scanner.nextLine();
        String[] inputArray=input.split(",");
        int[] intArray=new int[inputArray.length];
        for(int i=0;i< inputArray.length;i++){
            intArray[i]= Integer.parseInt(inputArray[i].trim());
        }
        return intArray;
    }

    private static int findMin(int[] array){
        int min=Integer.MAX_VALUE;
        for (int i:array
        ) {
            if(i < min){
                min=i;
            }
        }
        return min;
    }

    private static int[] reverseAnArray(int[] input){
        for(int i=0;i< input.length/2;i++){
            int temp=input[i];
            input[i]=input[input.length-1-i];
            input[input.length -i -1]=temp;
        }
        return input;
    }

    private static int[] reverseCopy(int[] input){
        int[] resultantArray=new int[input.length];
        int maxIndex=input.length-1;
        for (int el:input
             ) {
            resultantArray[maxIndex --]=el;
        }
        return resultantArray;
    }
}