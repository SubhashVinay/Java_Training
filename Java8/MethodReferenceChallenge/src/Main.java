import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {
    private static Random random=new Random();
    public static void main(String[] args) {
        String [] names={"Anna","Bob","Charlie","Dave","Eva"};

        UnaryOperator<String> u1=String::toUpperCase;
        UnaryOperator<String> u2=s -> s+" "+getInitial('D','M')+".";

        UnaryOperator<String> u4=s -> s+" "+Main.reverse(s,0,s.indexOf(" "));
        UnaryOperator<String> u3= Main::reverse;

        List<UnaryOperator<String>> functions=new ArrayList<>(List.of(u1,u2,u4,u3));

        applyChanges(names,functions);

    }

    private static void applyChanges(String[] names, List<UnaryOperator<String>> stringFunctions){
        List<String> backedByArray= Arrays.asList(names);

        for (var function:stringFunctions
             ) {
            backedByArray.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(names));
        }
    }

    private static char getInitial(char start,char end){
        return (char) random.nextInt((int) start,(int) end+1);
    }

    private static String reverse(String s){
        return reverse(s,0,s.length());
    }

    private static String reverse(String s,int start,int end){
        return new StringBuilder(s.substring(start,end)).reverse().toString();
    }
}