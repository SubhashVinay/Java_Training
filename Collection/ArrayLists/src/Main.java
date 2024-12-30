import java.util.ArrayList;
import java.util.Arrays;

record GroceryItem(String name, String type, int count){
    public GroceryItem(String name){
        this(name,"DAIRY",1);
    }

    @Override
    public String toString(){
        return String.format("%d %s in %s",count,name,type);
    }
}
public class Main {

    public static void main(String[] args) {
        GroceryItem[] grcoeryArray=new GroceryItem[3];
        grcoeryArray[0]=new GroceryItem("milk");
        grcoeryArray[1]=new GroceryItem("apples","PRODUCE",6);
        grcoeryArray[2]=new GroceryItem("oranges","PRODUCE",5);
        System.out.println(Arrays.toString(grcoeryArray));

        ArrayList objects=new ArrayList();
        objects.add(new GroceryItem("Butter"));
        objects.add("Yogurt");

        ArrayList<GroceryItem> groceryItemsList=new ArrayList();
        groceryItemsList.add(new GroceryItem("Butter"));
        groceryItemsList.add(new GroceryItem("milk"));
        groceryItemsList.add(new GroceryItem("oranges","PRODUCE",5));
        groceryItemsList.set(0,new GroceryItem("apples","PRODUCE",6));
        groceryItemsList.remove(1);
        System.out.println(groceryItemsList);

    }
}