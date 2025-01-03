import javax.sound.midi.Soundbank;
import java.util.*;

public class Main {
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        boolean flag=true;
        ArrayList<String> groceries=new ArrayList<>();
        while (flag){
            printActions();
            switch (Integer.parseInt(scanner.nextLine())){
                case 1 -> addItem(groceries);
                case 2 -> removeItem(groceries);
                default -> flag=false;
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        }
    }
    private static void addItem(ArrayList<String> groceries){
        System.out.println("Enter Items to be Added Separated by Commas");
        String[] items=scanner.nextLine().split(",");
        for (String item:items
             ) {
            item.trim();
            if(groceries.indexOf(item) < 0){
                groceries.add(item);
            }
        }
    }

    private static void removeItem(ArrayList<String> groceries){
        System.out.println("Enter Items to be removed Separated by Commas");
        String[] items=scanner.nextLine().split(",");
        for (String item:items
        ) {
            item.trim();
            groceries.remove(item);
        }
    }
    private static void printActions(){
        String text= """
                Available actions:
                                
                0 - to shutdown
                                
                1 - to add item(s) to list (comma delimited list)
                                
                2 - to remove any items (comma delimited list)
                                
                Enter a number for which action you want to do:""";
        System.out.println(text+" ");
    }
}