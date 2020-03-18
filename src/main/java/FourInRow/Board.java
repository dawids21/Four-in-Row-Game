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

	void display() {
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

	void makeTurn(int turn, Scanner input) {
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
        winner = checkBoard(turn);
	}

	private int checkBoard(int turn) {
        int winner = 0;
        for (int cellX = 0; cellX < columns.length; cellX++) {
            for (int cellY = columns[cellX].getFreeSpace() + 1; cellY < columns[cellX].getColumnLength(); cellY++) {
                int thisCell = columns[cellX].getCellValue(cellY);
                if (cellY < 3 && cellX < 4) {
                    winner = checkColumn(cellY, cellX, thisCell);
                    if (winner == 0) {
                        winner = checkRow(cellY, cellX, thisCell);
                    }
                    if (winner == 0) {
                        winner = checkDiagonal(cellY, cellX, thisCell);
                    }
                }
                else if (cellY < 3 && cellX == 4) {
                    winner = checkColumn(cellY, cellX, thisCell);
                    if (winner == 0) {
                        winner = checkRow(cellY, cellX, thisCell);
                    }
                    if (winner == 0) {
                        winner = checkDiagonal(cellY, cellX, thisCell);
                    }
                    if (winner == 0) {
                        winner = checkAntiDiagonal(cellY, cellX, thisCell);
                    }
                }
                else if (cellY < 3 && cellX > 4) {
                    winner = checkColumn(cellY, cellX, thisCell);
                    if (winner == 0) {
                        winner = checkAntiDiagonal(cellY, cellX, thisCell);
                    }
                }
                else if (cellY >= 3 && cellX < 4) {
                    winner = checkRow(cellY, cellX, thisCell);
                }
                else {
                    break;
                }
                if (winner != 0) {
                    break;
                }
            }
            if (winner != 0) {
                break;
            }
        }
        return winner;
    }

    private int checkAntiDiagonal(int cellY, int cellX, int thisCell) {
        return 0;
    }

    private int checkDiagonal(int cellY, int cellX, int thisCell) {
        return 0;
    }

    private int checkRow(int cellY, int cellX, int thisCell) {
        return 0;
    }

    private int checkColumn(int cellY, int cellX, int thisCell) {
        return 0;
    }

    void clear() {
        for (int i = 0; i < columns.length; i++) {
            columns[i].clear();
        }
	}

    
}
