import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        try(Scanner scanner=new Scanner(System.in);)
        {
            AtmData atmData=new AtmData();
            CashOrdering cashOrdering=new CashOrdering();
            CustomerVerification customerVerification=new CustomerVerification();
            TreeMap<String, CustomerDetails> cd=new TreeMap<>();
            int[] amount=new int[]{2000, 500, 100};
            SeperatingCash seperatingCash=new SeperatingCash();
            while (true)
            {
                int choice=0;
                System.out.println("1. Load ATM\n2. Withdraw From ATM\n3. Check ATM Balance\n4. Create Account\n5. Transfer\n6. Check Account Balance\n7. Display All Customer Details\n8. Deposit\n9. End");
                choice=scanner.nextInt();
                System.out.println();
                scanner.nextLine();
                switch (choice)
                {
                    case 1:
                    {
                        System.out.println("Enter the Amount to deposit:");
                        String[] str=scanner.nextLine().split(",");
                        int flag=1;
                        for(String seperate:str)
                        {
                            String[] values=seperate.split(":");
                            int amount2=Integer.parseInt(values[0].trim());
                            int amount3=Integer.parseInt(values[1]);
                            if(amount2<0||amount3<0)
                            {
                                System.out.println("Incorrect Deposit Amount");
                            }
                            else if (amount2==0||amount3==0)
                            {
                                System.out.println("Deposit Amount Cannot be Zero");
                            }
                            else
                            {
                                CashOrdering.updateSeperatingCash(amount2, amount3, seperatingCash);
                            }
                        }
                        CashOrdering.updateDepositAmount(atmData, seperatingCash);
                        System.out.println("2000                    "+SeperatingCash.getTwoThousand()+"       "+2000*SeperatingCash.getTwoThousand());
                        System.out.println("500                     "+SeperatingCash.getFiveHundred()+"       "+500*SeperatingCash.getFiveHundred());
                        System.out.println("100                     "+SeperatingCash.getOneHundred()+"       "+100*SeperatingCash.getOneHundred());
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Enter the Account Number : ");
                        String accountNumber=scanner.next();
                        System.out.println("Enter the Pin Number : ");
                        String pin=scanner.next();
                        if(CustomerVerification.validAccountNumber(accountNumber, cd)&&CustomerVerification.validPin(accountNumber, pin, cd))
                        {
                            System.out.println("Enter the amount to Withdraw : ");
                            int withdraw=scanner.nextInt();
                            if(withdraw<=0||withdraw>atmData.getBalance())
                            {
                                System.out.println("Incorrect or Insufficient Funds");
                                break;
                            }
                            else if(cd.get(accountNumber).getBalance()>10000||cd.get(accountNumber).getBalance()<100)
                            {
                                System.out.println("Withdraw Amount should minimum 100 and maximum 10000");
                                break;
                            }
                            cd.get(accountNumber).withdraw(accountNumber, withdraw, cd);
                            int flag=1;
                            int[] dispensingSeperatingCash=CashOrdering.dispensingSeperatingCash(amount, withdraw);
                            for(int i=0;i< amount.length;i++)
                            {
                                if(dispensingSeperatingCash[i]>0)
                                {
                                    flag=CashOrdering.reduceSeperatingCash(amount[i], dispensingSeperatingCash[i], seperatingCash);
                                }
                            }
                            System.out.println();
                            if(flag==1)
                                CashOrdering.updateWithdrawAmount(atmData, withdraw);
                            else
                            {
                                System.out.println("No Available Denomination");
                                break;
                            }
                        }
                        else
                        {
                            System.out.println("Invalid Acoount Number or Pin Number");
                            break;
                        }
                        break;
                    }
                    case 3:
                    {
                        int AtmBalance=atmData.getBalance();
                        if(AtmBalance<=0)
                        {
                            System.out.println("No Fund");
                            continue;
                        }
                        else
                        {
                            System.out.println("2000                    "+SeperatingCash.getTwoThousand()+"       "+2000*SeperatingCash.getTwoThousand());
                            System.out.println("500                     "+SeperatingCash.getFiveHundred()+"       "+500*SeperatingCash.getFiveHundred());
                            System.out.println("100                     "+SeperatingCash.getOneHundred()+"       "+100*SeperatingCash.getOneHundred());
                            System.out.println("Total Amount available in ATM is = Rs. "+atmData.getBalance());
                        }
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Enter the New Account Number : ");
                        String AccountNumber=scanner.nextLine();
                        System.out.println("Enter the Customer Name : ");
                        String CustomerName=scanner.nextLine();
                        System.out.println("Enter the New Pin Number : ");
                        String Pin=scanner.nextLine();
                        System.out.println("Enter the Amount to Deposit : ");
                        int AccountBalance=scanner.nextInt();
                        if(AccountBalance>=500)
                        {
                            CustomerDetails customerDetails=new CustomerDetails(AccountNumber,CustomerName, Pin, AccountBalance);
                            cd.put(AccountNumber, customerDetails);
                        }
                        else
                        {
                            System.out.println("Minimum Balance Must be 500 or above");
                            break;
                        }
                        break;
                    }
                    case 5:
                    {
                        System.out.println("Enter the Account Number : ");
                        String FromAccountNumber=scanner.next();
                        System.out.println("Enter the Pin Number : ");
                        String FromPin=scanner.next();
                        if(CustomerVerification.validAccountNumber(FromAccountNumber, cd)&&CustomerVerification.validPin(FromAccountNumber, FromPin, cd))
                        {
                            System.out.println("Enter the Account Number to make Transfer : ");
                            String ToAccountNumber=scanner.next();
                            System.out.println("Enter the Amount to Transfer : ");
                            int AmountTransfer=scanner.nextInt();
                            CustomerVerification.AmountTransfer(FromAccountNumber, ToAccountNumber, AmountTransfer, cd);
                        }
                        else
                        {
                            System.out.println("Invalid Account Number or Pin Number");
                            break;
                        }
                        break;
                    }
                    case 6:
                    {
                        System.out.println("Enter the Account Number : ");
                        String AccountNumber=scanner.next();
                        System.out.println("Enter the Pin Number : ");
                        String Pin=scanner.next();
                        if(CustomerVerification.validAccountNumber(AccountNumber, cd)&&CustomerVerification.validPin(AccountNumber, Pin, cd))
                        {
                            System.out.println("AccNo  AccountHolder    PinNumber AccountBalance");
                            System.out.println(AccountNumber+"        "+cd.get(AccountNumber).getCustomerName()+"        "+Pin+"        "+cd.get(AccountNumber).getBalance());
                        }
                        else
                        {
                            System.out.println("Invalid Account Number or Pin Number");
                            break;
                        }
                        break;
                    }
                    case 7:
                    {
                        System.out.println("AccNo    Account Holder    Pin Number    Account Balance");
                        for(Map.Entry<String, CustomerDetails> entry: cd.entrySet())
                        {
                            System.out.println(entry.getValue().getAccountNumber()+"       "+entry.getValue().getCustomerName()+"        "+entry.getValue().getPinNumber()+"        "+entry.getValue().getBalance());
                        }
                    }
                    case 8:
                    {
                        System.out.println("Enter the Account Number : ");
                        String AccountNumber=scanner.next();
                        if(CustomerVerification.validAccountNumber(AccountNumber, cd))
                        {
                            System.out.println("Enter the Amount to Deposit : ");
                            int Deposit=scanner.nextInt();
                            cd.get(AccountNumber).deposit(AccountNumber, Deposit, cd);
                            System.out.println("Your Current Account Balance is Rs. "+cd.get(AccountNumber).getBalance());
                        }
                        else
                        {
                            System.out.println("Please Enter valid Account Number...");break;
                        }break;
                    }
                    case 9:
                    {
                        System.out.println("Thank You!");
                        System.exit(0);
                    }
                    default:
                    {
                        System.out.println("Please Enter valid option...");
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}