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
        for (int column = 0; column < columns.length; column++) {
            for (int row = columns[column].getFreeSpace() + 1; row < columns[column].getColumnLength(); row++) {
                int thisCell = columns[column].getCellValue(row);
                if (column < 3 && row < 3) {
                    winner = checkColumn(row, column, thisCell);
                    if (winner == 0) {
                        winner = checkRow(row, column, thisCell);
                    }
                    if (winner == 0) {
                        winner = checkDiagonal(row, column, thisCell);
                    }
                }
                else if (row < 3 && column == 3) {
                    winner = checkColumn(row, column, thisCell);
                    if (winner == 0) {
                        winner = checkRow(row, column, thisCell);
                    }
                    if (winner == 0) {
                        winner = checkDiagonal(row, column, thisCell);
                    }
                    if (winner == 0) {
                        winner = checkAntiDiagonal(row, column, thisCell);
                    }
                }
                else if (row < 3 && column > 3) {
                    winner = checkColumn(row, column, thisCell);
                    if (winner == 0) {
                        winner = checkAntiDiagonal(row, column, thisCell);
                    }
                }
                else if (row >= 3 && column < 4) {
                    winner = checkRow(row, column, thisCell);
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

    private int checkAntiDiagonal(int row, int column, int thisCell) {
        int winner = thisCell;
        for (int i = 1; i < 4; i++) {
            if (columns[column - i].getCellValue(row + i) != thisCell) {
                winner = 0;
                break;
            }
        }
        return winner;
    }

    private int checkDiagonal(int row, int column, int thisCell) {
        int winner = thisCell;
        for (int i = 1; i < 4; i++) {
            if (columns[column + i].getCellValue(row + i) != thisCell) {
                winner = 0;
                break;
            }
        }
        return winner;
    }

    private int checkRow(int row, int column, int thisCell) {
        int winner = thisCell;
        for (int i = 1; i < 4; i++) {
            if (columns[column + i].getCellValue(row) != thisCell) {
                winner = 0;
                break;
            }
        }
        return winner;
    }

    private int checkColumn(int row, int column, int thisCell) {
        int winner = thisCell;
        for (int i = 1; i < 4; i++) {
            if (columns[column].getCellValue(row + i) != thisCell) {
                winner = 0;
                break;
            }
        }
        return winner;
    }

    void clear() {
        for (int i = 0; i < columns.length; i++) {
            columns[i].clear();
        }
        winner = 0;
	}

    
}
