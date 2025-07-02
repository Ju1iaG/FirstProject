//import java.util.Set;

public class Main {
    public static void main(String[] args){
        BankAccount b1 = new BankAccount("Kakashi");
        BankAccount b2 = new BankAccount("Boromir");

        b2.deposit(33);
        b1.deposit(100);
        System.out.println(b1);
        b2.withdraw(30);
        System.out.println(b2);
        b1.transfer(b2, 50);
        System.out.println(b1);
        System.out.println(b2);

        //Set<BankAccount> a1 = new HashSet<>();
        //a1.add(new BankAccount("Michael"));
        //System.out.println(a1);
    }
}
