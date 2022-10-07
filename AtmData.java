public class AtmData
{
    private int balance;
    private  int deposit;
    private int withdraw;
    public AtmData()
    {

    }
    public AtmData(int balance, int deposit, int withdraw)
    {
        this.balance = balance;
        this.deposit = deposit;
        this.withdraw = withdraw;
    }
    public int getBalance()
    {
        return balance;
    }
    public void setBalance(int balance)
    {
        this.balance = balance;
    }
    public int getDeposit()
    {
        return deposit;
    }
    public void setDeposit(int deposit)
    {
        this.deposit = deposit;
    }
    public int getWithdraw()
    {
        return withdraw;
    }
    public void setWithdraw(int withdraw)
    {
        this.withdraw = withdraw;
    }
}