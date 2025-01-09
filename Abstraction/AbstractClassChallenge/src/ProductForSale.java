public abstract  class ProductForSale {

    protected String type;
    private double price;
    private String description;

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(int qty){
        return price*qty;
    }
    public void getPricedItem(int qty){
        System.out.printf("%2d qty at $%8.2f each, %-15s %-35s %n",qty,price,type,description);
    }

    public abstract String showDetails();
}
class P1 extends ProductForSale{

    public P1(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public String showDetails() {
        return String.format("%s %.2f %s",type,getPrice(),getDescription());
    }
}
class P2 extends ProductForSale{

    public P2(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public String showDetails() {
        return String.format("%s %.2f %s",type,getPrice(),getDescription());
    }
}
class P3 extends ProductForSale{

    public P3(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public String showDetails() {
        return String.format("%s %.2f %s",type,getPrice(),getDescription());
    }
}

