import java.util.ArrayList;
import java.util.Arrays;

record GroceryItem(String name, String type, int count){

    public GroceryItem(String name){
        this(name,"DAIRY",1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s",count,name.toUpperCase(),type);
    }
}

public class Main {
    public static void main(String[] args) {

        GroceryItem[] groceryArray=new GroceryItem[3];
        groceryArray[0]=new GroceryItem("milk");
        groceryArray[1]=new GroceryItem("apples","produce",6);
        groceryArray[2]=new GroceryItem("oranges","produce",5);
        System.out.println(Arrays.toString(groceryArray));

        ArrayList objectList=new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");

        ArrayList<GroceryItem> groceryItemsList=new ArrayList<>();
        groceryItemsList.add(new GroceryItem("Butter"));
        groceryItemsList.add(new GroceryItem("Milk"));
        groceryItemsList.add(new GroceryItem("oranges","PRODUCE",5));
        groceryItemsList.set(0,new GroceryItem("Apples","Produce",6));
        System.out.println(groceryItemsList);

    }
}