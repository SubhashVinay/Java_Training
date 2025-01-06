import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transactions){
    public Customer(String name,double initialDeposit){
        this(name.toUpperCase(),new ArrayList<Double>(500));
        transactions.add(initialDeposit);
    }
}

public class Main {
    public static void main(String[] args) {
        Customer subh=new Customer("Subhash",1000.0);
        System.out.println(subh);

        Bank bank=new Bank("HDFC");
        bank.addNewCustomer("Subhash",500.0);
        System.out.println(bank);
    }
}