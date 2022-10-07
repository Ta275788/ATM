import java.util.*;
public class CustomerVerification
{
    public static boolean validAccountNumber(String accountNumber, TreeMap<String, CustomerDetails> cd)
    {
        if(accountNumber.equals(cd.get(accountNumber).getAccountNumber()))
        {
            return true;
        }
        return false;
    }
    public static boolean validPin(String AccountNumber, String Pin, TreeMap<String, CustomerDetails> cd)
    {
        if(Pin.equals(cd.get(AccountNumber).getPinNumber()))
        {
            return true;
        }
        return false;
    }
    public static void AmountTransfer(String FromAccountNumber, String ToAccountNumber, int Amount, TreeMap<String, CustomerDetails> cd)
    {
        cd.get(FromAccountNumber).withdraw(FromAccountNumber, Amount, cd);
        cd.get(ToAccountNumber).deposit(ToAccountNumber, Amount, cd);
    }
}