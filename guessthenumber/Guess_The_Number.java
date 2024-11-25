import java.util.Scanner;

public class Guess_The_Number {
    public static void main(String[] args) {
        int num = (int) (Math.random() * 10) + 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("choose a number from 1 to 10:");
        int user = sc.nextInt();
        boolean flag = false;
        while (!flag) {
            if (user < num) {
                System.out.println("choose a greater number:");
                user = sc.nextInt();
            } else if (user > num) {
                System.out.println("choose a smaller number:");
                user = sc.nextInt();
            } else {
                System.out.println("Congratulations! You guessed the number!");
                flag = true;
            }
        }

    }
}
