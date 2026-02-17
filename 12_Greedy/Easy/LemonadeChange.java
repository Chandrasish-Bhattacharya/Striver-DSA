// Lemonade Change
// Problem Statement: Given an array representing a queue of customers and the value of bills they hold, determine if it is possible to provide correct change to each customer. 
// Customers can only pay with 5$, 10$ or 20$ bills and we initially do not have any change at hand. 
// Return true, if it is possible to provide correct change for each customer otherwise return false.

// Example 1:
// Input: bills = [5, 5, 5, 10, 20]
// Output: True          
// Explanation:
// Initially we have 0 change and the queue of customers is [5, 5, 5, 10, 20].
// First Customer pays 5$, no change required.
// Second Customer pays 5$, no change required.
// Third Customer pays 5$, no change required.
// The Fourth Customer pays 10$, out of the three 5$ bills we have, we pay a 5$ bill and accept the 10$ bill.
// Fifth Customer pays 20$, out of the two 5$ bills and one 10$ bill we have, we pay 15$ in change and have one 5$ bill left.
// Hence, it is possible to provide change to all customers.

// Example 2:
// Input: bills = [5, 5, 10, 10, 20]
// Output: False
// Explanation: 
// Initially, we have 0 change and the queue of customers is [5,5,10,10,20].
// The first customer pays 5$, no change required.
// The second customer pays 5$, no change required.
// The third customer pays 10$, we collect a 5$ bill and give back a 5$ bill.
// The fourth customer pays 10$, we collect a 5$ bill and give back a 5$ bill.
// The fifth customer pays 20$, we cannot give the change of $15 back because we only have two $10 bills.
// Since not every customer received the correct change, the answer is false.

public class LemonadeChange{
    public boolean lemonadeChange(int[] bills){
        int five = 0 , ten = 0;
        for(int i : bills){
            if(i == 5){
                five++;
            }
            else if(i == 10){
                if(five > 0){
                    five--;
                    ten++;
                }
                else return false;
            }
            else{
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                }
                else if(five >= 3){
                    five -=3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
    int[] bills = {5, 5, 10, 10, 20};
    LemonadeChange sol = new LemonadeChange();
    System.out.print(sol.lemonadeChange(bills));
    }
}