public class CashOrdering
{
    public static void updateSeperatingCash(int amount, int SeperatingCash, SeperatingCash seperatingCash)
    {
        if(amount==2000)
        {
            seperatingCash.setTwoThousand(seperatingCash.getTwoThousand()+SeperatingCash);
        }
        else if(amount==500)
        {
            seperatingCash.setFiveHundred(seperatingCash.getFiveHundred()+SeperatingCash);
        }
        else if(amount==100)
        {
            seperatingCash.setOneHundred(seperatingCash.getOneHundred()+SeperatingCash);
        }
    }
    public static int reduceSeperatingCash(int amount, int SeperatingCash, SeperatingCash seperatingCash)
    {
        int flag1=0, flag2=0;
        if(amount==2000)
        {
            if(seperatingCash.getTwoThousand()>0)
            {
                seperatingCash.setTwoThousand(seperatingCash.getTwoThousand()-SeperatingCash);
                return 1;
            }
            else if(seperatingCash.getFiveHundred()>0)
            {
                flag1=1;
                seperatingCash.setFiveHundred(seperatingCash.getFiveHundred()-SeperatingCash);
            }
            else if(seperatingCash.getOneHundred()>0)
            {
                flag2=1;
                seperatingCash.setOneHundred(seperatingCash.getOneHundred()-SeperatingCash);
            }
        }
        else if(amount==500)
        {
            if(seperatingCash.getFiveHundred()>0)
            {
                if(flag1==0)
                {
                    seperatingCash.setFiveHundred(seperatingCash.getFiveHundred()-SeperatingCash);
                    return 1;
                }
            }
            else if(seperatingCash.getOneHundred()>0)
            {
                if(flag2==0)
                {
                    seperatingCash.setOneHundred(seperatingCash.getOneHundred()-SeperatingCash);
                }
            }
        }
        else if(amount==100)
        {
            if(seperatingCash.getOneHundred()>0)
            {
                if(flag2==0)
                {
                    seperatingCash.setOneHundred(seperatingCash.getOneHundred()-SeperatingCash);
                    return 1;
                }
            }
        }
        return -1;
    }
    public static void updateDepositAmount(AtmData atmData, SeperatingCash seperatingCash)
    {
        int DepositAmount=seperatingCash.getTwoThousand()*2000+seperatingCash.getFiveHundred()*500+seperatingCash.getOneHundred()*100;
        atmData.setDeposit(DepositAmount);
        atmData.setBalance(atmData.getDeposit());
    }
    public static void updateWithdrawAmount(AtmData atmDatabase, int withdraw)
    {
        atmDatabase.setWithdraw(withdraw);
        atmDatabase.setBalance(atmDatabase.getBalance()-withdraw);
    }
    public static int[] dispensingSeperatingCash(int[] amount, int withdrawAmount)
    {
        int[] CashCounter=new int[amount.length];
        for(int i=0;i<amount.length;i++)
        {
            if(withdrawAmount>=amount[i])
            {
                amount[i]=withdrawAmount/amount[i];
                withdrawAmount=withdrawAmount-amount[i]*amount[i];
            }
        }
        return CashCounter;
    }
}