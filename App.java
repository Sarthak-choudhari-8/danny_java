//import required classes and packages   
import java.util.Scanner;  
  
class ATM{

    Scanner sc = new Scanner(System.in);  

int balance =  0;
int pin;
String name;
long  phone_no;
long account_number;

public void Account_setup(){
System.out.println("\n\n[ Please first Setup Your Account ]\n");
System.out.println("\nEnter Name : ");
name = sc.nextLine();     
        
System.out.println("\nPlease Enter Phone Number : ");
phone_no = sc.nextLong();

System.out.println("\nSet trasaction Pin : ");
int pin1 = sc.nextInt();

System.out.println("\nEnter trasaction Pin again : ");
int pin2 = sc.nextInt();

if(pin2 ==  pin1){
    System.out.println("\nTransaction Pin Saved Successfully . ");
    pin = pin2;
}
else{
    System.out.println("\nYou entered Wrong pin . ");
    System.exit(0);  
}


System.out.println("\nYour System generated Account Number : "+((phone_no/2 ) +111));
 account_number = (phone_no/2 ) +111;
}



  

public void Check_balance(){

    System.out.println("Balance : "+balance);  

}
public void Deposite(int x){

        balance = balance + x;  

}
public void Withdraw(int x){

    balance = balance - x;  

}



}

//create ATMExample class to implement the ATM functionality  
 public class App
{  
    //main method starts   
    public static void main(String args[] )  
    {  
        //declare and initialize balance, withdraw, and deposit  
        int withdraw, deposit;
        // balance = 100000,  
        ATM obj = new ATM();
          
    
        //create scanner class object to get choice of user  
        Scanner sc = new Scanner(System.in);  

obj.Account_setup();


        while(true)  
        {  
            System.out.println("\n\nAutomated Teller Machine");  
            System.out.println("\nPress ( 1 ) for Withdraw Money ");  
            System.out.println("Press ( 2 ) for Deposit Money ");  
            System.out.println("Press ( 3 ) for Check Balance");  
            System.out.println("Press ( 4 ) for EXIT");  
            System.out.print("\n\nChoose the operation you want to perform:");  
              
            //get choice from user  
            int choice = sc.nextInt();  
            switch(choice)  
            {  
                case 1:  
        System.out.print("Enter money to be withdrawn : ");  
                      
        //get the withdrawl money from user  
        withdraw = sc.nextInt();  
                      
        //check whether the balance is greater than or equal to the withdrawal amount  
        if(obj.balance >= withdraw)  
        {  
            //remove the withdrawl amount from the total balance  
            // balance = balance - withdraw;  
            System.out.println("\n\nTransaction PIN : ");
            int pin3 = sc.nextInt();
        
            if(obj.pin == pin3){
                obj.Withdraw(withdraw);
                System.out.println("\nPlease collect your money ...");  
            }
            else{
                System.out.println("\nWrong PIN ");
            }


         
        }  
        else  
        {  
            //show custom error message   
            System.out.println("Insufficient Balance ...");  
        }  
        System.out.println("");  
        break;  
   
                case 2:  
                      
        System.out.print("Enter money to be deposited : ");  
                      
        //get deposite amount from te user  
        deposit = sc.nextInt();  
                      
        //add the deposit amount to the total balanace  
        // balance = balance + deposit;  
        obj.Deposite(deposit);
        System.out.println("Your Money has been successfully deposited ...");  
        System.out.println("");  
        break;  
   
                case 3:  
        //displaying the total balance of the user  
obj.Check_balance();
        // System.out.println("Balance : "+balance);  
        System.out.println("");  
        break;  
   
                case 4:  
        //exit from the menu  
        System.exit(0);  
            }  
            
        }  
        
    }  
}  
