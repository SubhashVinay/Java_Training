import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int [] firstArray=getRandomArray(9);
        System.out.println(Arrays.toString(firstArray));
        Arrays.sort(firstArray);

        int[] newIntArray=new int[]{30,35,7,8,90,56,67,89};
        System.out.println(Arrays.toString(newIntArray));
        int[] sortedArry=sortArrayDesc(newIntArray);
        System.out.println(Arrays.toString(sortedArry));
    }

    private static int[] getRandomArray(int length){
        Random random=new Random();
        int[] newArray=new int[length];
        for(int i=0;i< newArray.length;i++){
            newArray[i]=random.nextInt(100);
        }
        return newArray;
    }

    private static int[] sortArrayDesc(int[] intArray){
        int[] sortedArray=Arrays.copyOf(intArray,intArray.length);
        //System.out.println(Arrays.toString(sortedArray));
        boolean flag =true;
        int temp;
        while (flag){
            flag=false;
            for(int i=0;i< sortedArray.length-1;i++){
                if(sortedArray[i] < sortedArray[i+1]){
                    temp=sortedArray[i];
                    sortedArray[i]=sortedArray[i+1];
                    sortedArray[i+1]=temp;
                    flag=true;
                    //System.out.println("----------->"+Arrays.toString(sortedArray));
                }
            }
        }
        return sortedArray;
    }
}