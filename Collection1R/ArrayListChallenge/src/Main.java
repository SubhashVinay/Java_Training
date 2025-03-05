import java.util.*;

public class Main {

    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag=true;
        ArrayList<String> groceries=new ArrayList<>();
        while (flag){
            printActions();
            switch (Integer.parseInt(scanner.nextLine())){
                case 1 -> addItems(groceries);
                case 2 -> removeItems(groceries);
                default -> flag=false;
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        }
    }

    private static void addItems(ArrayList<String> groceryArray){
        System.out.println("Add items to the grocery list separated by commas");
        String[] items=scanner.nextLine().split(",");
        for(String i:items){
            String trimmed=i.trim();
            if(groceryArray.indexOf(trimmed) < 0){
                groceryArray.add(trimmed);
            }
        }
    }

    private static void removeItems(ArrayList<String> groceryArray){
        System.out.println("Remove items from the  grocery list separated by commas");
        String[] items=scanner.nextLine().split(",");
        for(String i:items){
            String trimmed=i.trim();
            groceryArray.remove(trimmed);
        }
    }

    private static void printActions(){
        String textBlock= """
                Availble Actions
                
                0 - to shutdown
                
                1- to add item(s) to list (comma delimited list)
                
                2 - to remove any items (comma delimited list)
                
                Enter a number for which actions you want to do:""";
        System.out.println(textBlock + " ");
    }
}