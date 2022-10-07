import java.util.*;
public class CustomerDetails
{
    private  String AccountNumber;
    private String CustomerName;
    private String Pin;
    private int Balance;
    public CustomerDetails(String AccountNumber, String CustomerName, String Pin, int Balance)
    {
        this.AccountNumber = AccountNumber;
        this.CustomerName = CustomerName;
        this.Pin = Pin;
        this.Balance = Balance;
    }
    public String getAccountNumber()
    {
        return AccountNumber;
    }
    public String getCustomerName()
    {
        return CustomerName;
    }
    public String getPinNumber()
    {
        return Pin;
    }
    public int getBalance()
    {
        return Balance;
    }
    public void setCustomerName(String CustomerName)
    {
        this.CustomerName = CustomerName;
    }
    public void setPinNumber(String Pin)
    {
        this.Pin = Pin;
    }
    public void setBalance(int Balance)
    {
        this.Balance = Balance;
    }
    public void withdraw(String accountNumber, int amount, TreeMap<String, CustomerDetails> db)
    {
        db.get(accountNumber).setBalance(getBalance()-amount);
    }

    public void deposit(String accountNumber, int amount, TreeMap<String, CustomerDetails> db){
        db.get(accountNumber).setBalance(getBalance()+amount);
    }
}