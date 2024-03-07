
//import required classes and packages   
import java.util.Scanner;

class ATM  {

    Scanner sc = new Scanner(System.in);

    int balance = 10000;
    int pin;
    String name;
    long phone_no;
    long account_number;

    public void Account_setup() throws InterruptedException {
        System.out.println("[ Please first Setup Your Account ]\n");

        System.out.print("\nName : ");
        name = sc.nextLine();

        System.out.print("\nPhone Number : ");
        phone_no = sc.nextLong();

        System.out.print("\nSet trasaction Pin : ");
        int pin1 = sc.nextInt();

        System.out.print("\nEnter trasaction Pin again : ");
        int pin2 = sc.nextInt();

        Thread.sleep(1500);

        if (pin2 == pin1) {
          
            System.out.println("\n\n\nTransaction Pin Saved Successfully . \n");
            pin = pin2;
        } else {
            System.out.println("\nYou entered Wrong pin . ");
            System.exit(0);
        }

        Thread.sleep(1500);

        System.out.print("Your System generated Account Number : " + ((phone_no / 2) + 111) + "\n");
        account_number = (phone_no / 2) + 111;
   
    }

    public void Check_balance() {
        System.out.println("your current balance : ");
        System.out.println("Balance : " + balance);

    }

    public void Deposite(int x) {

        balance = balance + x;

    }

    public void Withdraw(int x) {

        balance = balance - x;

    }

}

// create ATMExample class to implement the ATM functionality
public class App {

    static void line() {
        System.out.println("\n\n--------------------------------------------------\n\n");
    }

    static void space() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    static void title() {
        System.out.println(
                "\n\t\t===================================== ATM INTERFACE =======================================\n");
    }

    public static void main(String args[]) throws InterruptedException {
        int withdraw, deposit;
        ATM obj = new ATM();
        // create scanner class object to get choice of user
        Scanner sc = new Scanner(System.in);

        title();
        System.out.println(
                "\t\tVasantrao Naik Mahavidyalaya, chh. Sambhajinagar \n\n\tC Project  for -> Student database Management System\n\n\t\tdeveloped by -> Sarthak Choudhari ( BCS SY )");
        line();


        obj.Account_setup();


        line();



        while (true) {

            Thread.sleep(1500);

            System.out.println("\n\nAutomated Teller Machine");
            System.out.println("\nPress ( 1 ) for Withdraw Money ");
            System.out.println("Press ( 2 ) for Deposit Money ");
            System.out.println("Press ( 3 ) for Check Balance");
            System.out.println("Press ( 4 ) for EXIT");
            System.out.print("\n\nChoose the operation you want to perform:");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // withdrawing money from bank account

                    System.out.print("Enter money to be withdrawn : ");

                    // get the withdrawl money from user
                    withdraw = sc.nextInt();

                    // check whether the balance is greater than or equal to the withdrawal amount
                    if (obj.balance >= withdraw) {

                        System.out.println("\n\nTransaction PIN : ");
                        int pin3 = sc.nextInt();

                        if (obj.pin == pin3) {
                            obj.Withdraw(withdraw);
                            System.out.println("\nPlease collect your money ...");
                        } else {
                            System.out.println("\nWrong PIN ");
                        }

                    } else {

                        System.out.println("Insufficient Balance ...");
                    }

                    System.out.println("");
                    break;

                case 2:
                    // depositing money to account .

                    System.out.print("Enter money to be deposited : ");

                    // get deposite amount from te user
                    deposit = sc.nextInt();

                    System.out.println("\n\nTransaction PIN : ");
                    int pin3 = sc.nextInt();

                    if (obj.pin == pin3) {
                        obj.Deposite(deposit);
                        System.out.println("\nRs. " + deposit + " has been succesfully Deposited to your account .");
                    } else {
                        System.out.println("\nWrong PIN ");
                    }

                    System.out.println();
                    break;

                case 3:
                    // displaying the total balance of the user

                    System.out.println("\n\nTransaction PIN : ");
                    int pin4 = sc.nextInt();

                    if (obj.pin == pin4) {
                        obj.Check_balance();

                    } else {
                        System.out.println("\nWrong PIN ");
                    }

                    System.out.println("");
                    break;

                case 4:
                    // exit from the menu

                    System.exit(0);
            }

        }

    }
}
