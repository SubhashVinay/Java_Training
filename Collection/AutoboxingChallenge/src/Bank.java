import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers=new ArrayList<>(5000);

    public Bank(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }

    private Customer getCustomer(String customerName){
        for (Customer cx:customers
             ) {
            if(cx.name().equalsIgnoreCase(customerName)){
                return cx;
            }
        }
        System.out.printf("Customer (%s) was not found %n ",customerName);
        return  null;
    }

    public void addNewCustomer(String customerName,double initialDeposit){
        if(getCustomer(customerName) == null){
           Customer customer=new Customer(customerName,initialDeposit);
           customers.add(customer);
            System.out.println("New Customes Added "+customer);
        }
    }

    public void addTransaction(String customerName,Double txAmount){
        Customer customer=getCustomer(customerName);
        if(customer != null){
            customer.transactions().add(txAmount);
        }
    }

    public void printStatement(String cxName){
        Customer customer=getCustomer(cxName);
        if(customer == null){
            return;
        }
        System.out.println("_".repeat(30));
        System.out.println("Customer Name: "+customer.name());
        System.out.println("Transactions:");
        for (double d: customer.transactions()
             ) {
            System.out.printf("$%10.2f (%s)%n",d,d<0?"debit":"credit");
        }
    }
}
