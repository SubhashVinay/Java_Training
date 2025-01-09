import java.util.ArrayList;

record OrderItem(int qty,ProductForSale productForSale){}

public class Store {
    private static ArrayList<ProductForSale> productForSales=new ArrayList<>();
    public static void main(String[] args) {
        productForSales.add(new P1("Soap",20,"Daily Soap"));
        productForSales.add(new P1("Toothpaste",100,"Daily Paste"));
        showDetails();
        OrderItem o1=new OrderItem(2,new P1("Soap",10.0,"Daily Use Soap"));
        OrderItem o2=new OrderItem(3 ,new P1("Mixture",40.0,"Daily Use Mix"));
    }

    public static void addItemToOrder(ArrayList<ProductForSale> productForSales,OrderItem orderItem){
        productForSales.add(orderItem.productForSale());
    }

    private static void showDetails(){

        for (var item:productForSales
             ) {
            System.out.println(item.showDetails());
        }
    }

}
