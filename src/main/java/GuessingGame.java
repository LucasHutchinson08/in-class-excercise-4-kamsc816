import java.util.Scanner;
import java.util.Random;
public class GuessingGame {
    public static void main(String[] args) {
        // TODO: Prompt the user with a welcome message
        // TODO: Generate a random secret number between 1 and 100 (inclusive)
        // TODO: Use a do...while loop to read guesses until correct
        // TODO: Print "Too low" / "Too high" / "You got it!" accordingly
        // TODO: Use Scanner for input
        int num;
        int guess;
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Welcome to Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        do {
            num = random.nextInt(100)+1;
            System.out.println("Enter your guess: ");
            guess = sc.nextInt();
            if(num>guess){
                System.out.println("Too low! Try again");
            }
            if(num<guess){
                System.out.println("Too high! Try again");
            }
        }while(num!=guess);
        if(num==guess){
            System.out.println("You got it!");
        }
    }
}
