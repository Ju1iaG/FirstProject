import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Objects;

public class BankAccount {

    private String nameOwner;
    private int balance;
    private LocalDateTime dataOpen;
    private boolean blocked;
    private String number;

    public BankAccount (String nameThisOwner){
        nameOwner = nameThisOwner;
        balance = 0;
        dataOpen = LocalDateTime.now();
        blocked = false;

        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int digit = rnd.nextInt(10);
            sb.append(digit);
        }
        number = sb.toString();
    }

    public void setName(String name){
        this.nameOwner=name;
    }
    public String getName(){
        return nameOwner;
    }
    public void setBalance(int b){
        this.balance=b;
    }
    public String getBalance(){
        return String.valueOf(balance);
    }
    public void setData(LocalDateTime b){
        this.dataOpen=b;
    }
    public String getData(){
        return String.valueOf(dataOpen);
    }
     public void setBlock(boolean b){
        this.blocked=b;
    }
    public String getBlock(){
        return String.valueOf(blocked);
    }
    

    public boolean deposit(int amount){
        this.balance += amount;
        return true;
    }

    public boolean withdraw(int amount){
        if(balance >= amount){
            this.balance -= amount;
            return true;
        }
        else{
            this.blocked = true;
            return false;
        }
    }

    public boolean transfer(BankAccount otherAccount, int amount){
        if(this.blocked == true || otherAccount.blocked == true){
            return false;
        }
        else if(this.balance < amount){
            this.blocked = true;
            return false;
        }
        else{
            this.balance -= amount;
            otherAccount.balance += amount;
            return true;
        }
    }

    @Override
    public String toString(){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return "Name: " + nameOwner + "; Balance: " + balance + "; Opening Date: " + dataOpen.format(f) + "; Blocked: " + blocked + "; Number: " + number;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        else if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        BankAccount bt = (BankAccount) obj;
        return this.nameOwner.equals(bt.nameOwner) && (this.balance == bt.balance) && (this.number == bt.number) && (this.blocked == bt.blocked) && this.dataOpen.equals(bt.dataOpen);
    }
    

    @Override
    public int hashCode(){
        return Objects.hash(nameOwner,balance,number,blocked,dataOpen);
    }
}
