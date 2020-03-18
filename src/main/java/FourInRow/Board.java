package FourInRow;

import java.util.Scanner;

class Board {
    private int winner;
    private Column[] columns = new Column[7];

    Board() {
        winner = 0;
        for (int i = 0; i < columns.length; i++) {
            columns[i] = new Column();
        }
    }

    int getWinner() {
		return winner;
	}

	public void display() {
        System.out.println();
        for (int i = 0; i < columns[0].getColumnLength(); i++) {
            System.out.print("|");
            for (int j = 0; j < columns.length; j++) {
                if (columns[j].getCellValue(i) == 1) {
                    System.out.print("Y|");
                }
                else if (columns[j].getCellValue(i) == 2) {
                    System.out.print("R|");
                }
                else {
                    System.out.print(" |");
                }
            }
            System.out.println();
        }
        System.out.println("———————————————");
        System.out.print(" ");
        for (int i = 0; i < columns.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
	}

	public void makeTurn(int turn, Scanner input) {
        System.out.print("Drop a " + (turn == 1 ? "yellow" : "red") + " disk at column (0–6): ");
        int inputColumn = input.nextInt();
        while (true) {
            if (inputColumn < 0 || inputColumn > 6) {
                System.out.println("This column is out of bound. Choose another one.");
            }
            else if (columns[inputColumn].getFreeSpace() == -1) {
                System.out.println("This column is full. Choose another one.");
            }
            else {
                break;
            }
            System.out.print("Drop a " + (turn == 1 ? "yellow" : "red") + " disk at column (0–6): ");
            inputColumn = input.nextInt();
        }
        columns[inputColumn].addOne(turn);
	}

	public void clear() {
	}

    
}