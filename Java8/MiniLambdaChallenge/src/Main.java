import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        printWordInASentence("Ram went to market");

        Function<String,String> biFunction=(stringVal) -> {
            StringBuilder returnVal=new StringBuilder();
            for(int i=0;i< stringVal.length();i++){
                if(i %2 ==1){
                    returnVal.append(stringVal.charAt(i));
                }
            }
            return returnVal.toString();
        };
        //System.out.println(biFunction.apply("1234567890"));
        String  s=everySecondCharacter(biFunction,"1234567890");
        System.out.println(s);

        Supplier<String> supplyLoveMessage=() -> "i love java";
        String iLoveJava=supplyLoveMessage.get();

        System.out.println(iLoveJava);
    }

    public static void printWordInASentence(String sentence){
        String [] words=sentence.split(" ");
        Arrays.asList(words).forEach(c -> System.out.println(c));
    }

    public static String everySecondCharacter(Function<String,String> function,String val){
        return function.apply(val);
    }
}