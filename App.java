
//import required classes and packages   
import java.util.Scanner;

class ATM {

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

        Thread.sleep(2000);

        System.out.print("Your System generated Account Number : " + ((phone_no / 2) + 111) + "\n");
        account_number = (phone_no / 2) + 111;

    }

    public void Check_balance() {

        System.out.println("\nCurrent Account Balance : " + balance + "\n\nAccount Number : " + account_number
                + "\t|\tAccount Holder : " + name);

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
        System.out.println("\n-----------------------------------------------------------\n");
    }

    static void space() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    static void title() {
        System.out.println(
                "\n\t\t===================================== Automated Teller Machine =======================================\n");
    }

    public static void main(String args[]) throws InterruptedException {
        int withdraw, deposit;
        ATM obj = new ATM();
        // create scanner class object to get choice of user
        Scanner sc = new Scanner(System.in);

        line();
        System.out.println(
                "\t\tVasantrao Naik Mahavidyalaya, chh. Sambhajinagar \n\n\tC Project  for -> Student database Management System\n\n\t\tdeveloped by -> Sarthak Choudhari ( BCS SY )");
        line();

        obj.Account_setup();

        while (true) {

            Thread.sleep(3500);
            space();
            space();
            title();
            System.out.println("\nPress ( 1 ) for Withdraw Money");
            System.out.println("Press ( 2 ) for Deposit Money");
            System.out.println("Press ( 3 ) for Check Balance");
            System.out.print("Press ( 4 ) for EXIT\n\n");

            line();

            System.out.print("Input -> : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // withdrawing money from bank account

                    line();
                    System.out.print("Enter money to be withdrawn : ");

                    // get the withdrawl money from user
                    withdraw = sc.nextInt();

                    // check whether the balance is greater than or equal to the withdrawal amount
                    if (obj.balance >= withdraw) {

                        System.out.print("\n\nTransaction PIN : ");
                        int pin3 = sc.nextInt();

                        line();
                        Thread.sleep(2500);
                        if (obj.pin == pin3) {
                            obj.Withdraw(withdraw);
                            System.out.println("\nRs " + withdraw
                                    + " has been debited from your account . . . \n\nAccount Number : "
                                    + obj.account_number + "\t|\tAccount Holder : " + obj.name);
                        } else {
                            System.out.println("\nWrong PIN ");
                        }

                    } else {

                        System.out.println("\nInsufficient Balance ...");
                    }
                    line();
                    System.out.println("");
                    break;

                case 2:
                    // depositing money to account .
                    line();
                    System.out.print("Enter money to be deposited : ");

                    // get deposite amount from te user
                    deposit = sc.nextInt();

                    System.out.print("\n\nTransaction PIN : ");
                    int pin3 = sc.nextInt();

                    line();
                    Thread.sleep(2000);

                    if (obj.pin == pin3) {

                        obj.Deposite(deposit);

                        System.out.println(
                                "\nRs " + deposit + " has been credited to your account . . . \n\nAccount Number : "
                                        + obj.account_number + "\t|\tAccount Holder : " + obj.name);

                    } else {
                        System.out.println("\nWrong PIN ");
                    }

                    line();
                    System.out.println();
                    break;

                case 3:
                    // displaying the total balance of the user
                    line();
                    System.out.print("\n\nTransaction PIN : ");
                    int pin4 = sc.nextInt();

                    line();
                    Thread.sleep(2000);

                    if (obj.pin == pin4) {
                        obj.Check_balance();

                    } else {
                        System.out.println("\nWrong PIN ");
                    }

                    line();
                    System.out.println("");
                    break;

                case 4:
                    // exit from the menu

                    line();
                    System.out.println("Thank You ...");

                    System.exit(0);
            }

        }

    }
}
