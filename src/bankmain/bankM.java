package bankmain;

import bankclass.bankC;
import java.util.Scanner;

public class bankM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int response;
        bankC bapp[] = new bankC[99];
        int accCount = 0; 

        do {
            System.out.println("WELCOME TO MY SYSTEM!");
            System.out.println("What do you feel like doing today?");
            System.out.println("1. Banking");
            System.out.println("2. Shopping");
            System.out.println("3. Pay Bills");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Exit");
                    System.out.print("Enter Action: ");
                    int action = sc.nextInt();

                    switch (action) {
                        case 1:
                            System.out.print("Enter Account No.: ");
                            int newAccNo = sc.nextInt();

                            boolean exists = false;
                            for (int i = 0; i < accCount; i++) {
                                if (bapp[i].getAccNo() == newAccNo) {
                                    exists = true;
                                    break;
                                }
                            }

                            if (exists) {
                                System.out.println("Account number already used!");
                            } else {
                                bapp[accCount] = new bankC();
                                bapp[accCount].setAccNo(newAccNo);
                                System.out.print("Enter Pin No.: ");
                                bapp[accCount].setPin(sc.nextInt());
                                System.out.println("Registered Account No: " + bapp[accCount].getAccNo());
                                accCount++;
                            }
                            break;

                        case 2:
                            System.out.print("Enter Account No.: ");
                            int accn = sc.nextInt();
                            System.out.print("Enter Pin No.: ");
                            int pin = sc.nextInt();

                            int attempts = 3;
                            boolean loggedIn = false;

                            while (attempts > 0) {
                                for (int i = 0; i < accCount; i++) {
                                    if (bapp[i].verifyAccount(accn, pin)) {
                                        loggedIn = true;
                                        break;
                                    }
                                }

                                if (loggedIn) {
                                    System.out.println("LOGIN SUCCESS!");
                                    break;
                                } else {
                                    attempts--;
                                    System.out.println("Invalid account, Attempts Left: " + attempts);
                                    if (attempts == 0) {
                                        System.out.println("MAX ATTEMPT LIMIT REACHED!");
                                        System.exit(0);
                                    }
                                    System.out.print("Enter Account No.: ");
                                    accn = sc.nextInt();
                                    System.out.print("Enter Pin No.: ");
                                    pin = sc.nextInt();
                                }
                            }
                            break;

                        case 3:
                            break;

                        default:
                            System.out.println("INVALID ACTION");
                    }
                    break;

                case 2:
                    break;

                case 3:
                    break;

                default:
                    System.out.println("INVALID ACTION!");
            }

            System.out.print("Continue? (1/0): ");
            response = sc.nextInt();
        } while (response == 1);
    }
}
