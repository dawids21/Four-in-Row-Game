package FourInRow;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        Board board = new Board();
        while (true) {
            int turn = 1;
            int winner = board.getWinner();
            board.clear();
            while (winner == 0) {
                board.display();
                board.makeTurn(turn, input);
                turn = (turn == 1 ? 2 : 1);
                winner = board.getWinner();
                System.out.println("debug");
            }
            board.display();
            System.out.println("The " + (winner == 1 ? "yellow" : "red") + " player won");
            if (!playAgain(input)) {
                break;
            }
        }
        input.close();
    }
    private static boolean playAgain(Scanner input) {
        boolean playAgain;
        while (true) {
            System.out.print("Do you want to play again (y/n)? ");
            char answer = input.next().charAt(0);
            answer = Character.toLowerCase(answer);
            if (answer != 'y' && answer != 'n') {
                System.out.println("Choose y or n");
            }
            else {
                playAgain = (answer == 'y' ? true : false);
                break;
            }
        }
        return playAgain;
    }
}
