/*
 * Will Z.
 * 21/11/18
 * This is a program that will play "Rock, Paper, Scissors!" against you.
 */

package summative.unit.pkg2;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author wizwa9381
 */
public class SummativeUnit2 {
    /**
     * This displays user data before the program ends.
     * @param winAmount The total amount of matches won.
     * @param lossAmount The total amount of matches lost.
     * @param tieAmount The total amount of matches tied.
     * @param winPercent The percentage of matches won.
     * @param totalGames The total amount of matches.
     */
    public static void statistics(double winAmount, double lossAmount, double tieAmount, double winPercent, double totalGames){
        winPercent = (winAmount/(totalGames-tieAmount))*100;
        System.out.println("You won "+winAmount+" times.");
        System.out.println("You tied with the computer "+tieAmount+" times.");
        System.out.println("You lost "+lossAmount+" times.");
        System.out.println("You played "+totalGames+" times.");
        System.out.println("You won around "+Math.round(winPercent)+"% of the time (draws not included).");
    }
    /**
     * This gives the computer a random number.
     * @param computerChoice This method gives this a random number between 1 and 3.
     * @return computerChoice to the main program.
     */
    public static int randomNumberForComputer(int computerChoice) {
        //Computer getting a random number.
        Random rand = new Random();
        computerChoice = rand.nextInt(3)+1;
        return computerChoice;
    }
    /**
     * Getting the users choice for rock paper scissors.
     * @param userInput The users choice for rock paper scissors or statistics.
     * @param keyedInput The scanner to pick up the users input.
     * @return 
     */
    public static int userChoice(int userInput, Scanner keyedInput){
        //Getting the users choice.
        System.out.println("Type 1 for rock.");
        System.out.println("Type 2 for paper.");
        System.out.println("Type 3 for scissors.");
        System.out.println("Type 4 for statistics and then exiting");
        System.out.println("What is your choice?");
        userInput = keyedInput.nextInt();
        return userInput;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables
        Scanner keyedInput = new Scanner(System.in);
        int userInput=0,computerChoice=0;
        double winAmountFinder=0,totalGames=0,lossAmount=0,tieAmountTotal=0,winPercent=0;
        //Loop the program
        do {
            //Method for users choice
            userInput = userChoice(userInput,keyedInput);
            //Method for computer choice
            computerChoice = randomNumberForComputer(computerChoice);
            //Switch statements comparing the users choice to the computers and storing statistics.
            switch (userInput){
                case 1:
                    System.out.println("You chose rock.");
                    switch (computerChoice){
                        case 1:
                            System.out.println("The computer also chose rock. No one wins.");
                            totalGames = totalGames+1;
                            tieAmountTotal = tieAmountTotal+1;
                            break;
                        case 2:
                            System.out.println("The computer chose paper. You lose.");
                            totalGames = totalGames+1;
                            lossAmount = lossAmount+1;
                            break;
                        case 3:
                            System.out.println("The computer chose scissors. You win.");
                            totalGames = totalGames+1;
                            winAmountFinder = winAmountFinder+1;
                            break;
                    }
                    break;
                case 2:
                    System.out.println("You chose paper.");
                    switch (computerChoice){
                        case 1:
                            System.out.println("The computer chose rock. You win.");
                            totalGames = totalGames+1;
                            winAmountFinder = winAmountFinder+1;
                            break;
                        case 2:
                            System.out.println("The computer also chose paper. No one wins.");
                            totalGames = totalGames+1;
                            tieAmountTotal = tieAmountTotal+1;
                            break;
                        case 3:
                            System.out.println("The computer chose scissors. You lose.");
                            totalGames = totalGames+1;
                            lossAmount = lossAmount+1;
                            break;
                    }
                    break;
                case 3:
                    System.out.println("You chose scissors.");
                    switch (computerChoice){
                        case 1:
                            System.out.println("The computer chose rock. You lose.");
                            totalGames = totalGames+1;
                            lossAmount = lossAmount+1;
                            break;
                        case 2:
                            System.out.println("The computer chose paper. You win.");
                            totalGames = totalGames+1;
                            winAmountFinder = winAmountFinder+1;
                            break;
                        case 3:
                            System.out.println("The computer also chose scissors. No one wins.");
                            totalGames = totalGames+1;
                            tieAmountTotal = tieAmountTotal+1;
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Displaying statistics and exiting.");
                    statistics(winAmountFinder,lossAmount,tieAmountTotal,winPercent,totalGames);
                    break;
                default:
                    System.out.println("You didn't choose an option, try again.");
                    break;
            }
        } while(userInput != 4);
    }
    
}