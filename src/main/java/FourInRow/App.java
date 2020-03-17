package FourInRow;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        Board board = new Board();
        int turn = 1;
        int winner = board.getWinner();
        while (winner == 0) {
            board.display();
            board.makeTurn(turn, input);
            turn = (turn == 1 ? 2 : 1);
            winner = board.getWinner();
        }
        board.display();
        input.close();
        System.out.println("The " + (winner == 1 ? "yellow" : "red") + " player won");
    }
}
