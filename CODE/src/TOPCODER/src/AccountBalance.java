/**
PROBLEM STATEMENT
You are working for the financial institution TopBank, and you have 
been tasked with writing a module that will take an initial account 
balance, along with a list of that day's transactions, and return 
the ending balance for the day.

Each transaction will be either a credit, which adds funds to the 
account, or a debit, which removes funds from the account.  If a 
debit exceeds the available funds at the time, then the account 
balance will go negative.  You will be given an int startingBalance, 
the initial account balance.  You will also be given a String[] 
transactions, the list of transactions for the day.  Each element of 
transactions will be in the form "type amount" (quotes added for 
clarity).  Each type will be 'C' or 'D', for credit or debit, 
respectively.  Each amount will be an integer between 1 and 1000000, 
inclusive, with no leading zeros.  You are to return an int 
representing the ending balance after processing all of the 
transactions.



DEFINITION
Class:AccountBalance
Method:processTransactions
Parameters:int, String[]
Returns:int
Method signature:int processTransactions(int startingBalance, String
[] transactions)


CONSTRAINTS
-startingBalance will be between 0 and 1000000, inclusive.
-transactions will have between 0 and 50 elements, inclusive.
-Each element of transactions will be formatted as "type amount" 
(quotes added for clarity).
-Each type will be 'C' or 'D'.
-Each amount will represent an integer between 1 and 1000000, 
inclusive, with no leading zeros.


EXAMPLES

0)
100
{"C 1000", "D 500", "D 350"}

Returns: 250

This person had 100 dollars, got their paycheck, then went shopping 
at two different stores.  100 + 1000 - 500 - 350 = 250.

1)
100
{}

Returns: 100

With no transactions, the balance doesn't change by the end of the 
day.

2)
100
{"D 50", "D 20", "D 40"}

Returns: -10

Uh oh!  This person's account is overdrawn.

3)
53874
{"D 1234", "C 987", "D 2345", "C 654", "D 6789", "D 34567"}

Returns: 10580

Several transactions of both types.


Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
**/

public class AccountBalance
{
    public static int processTransactions(int startingBalance, String[] transactions)
    {
        int ans=startingBalance;
        for(int i=0;i<transactions.length;i++)
        {
            String []temp=transactions[i].split(" ");
            if(temp[0].equals("C"))
            {
                ans+=Integer.parseInt(temp[1]);
            }
            else
            {
                ans-=Integer.parseInt(temp[1]);
            }
        }
        return ans;
    }
}
