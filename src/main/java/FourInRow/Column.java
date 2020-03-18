package FourInRow;

class Column {
    private Cell[] cells = new Cell[6];
    private int freeSpace;

    Column() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell();
        }
        freeSpace = 5;
    }

    void addOne(int player) {
        cells[freeSpace].setValue(player);
        freeSpace--;
    }

    int getFreeSpace() {
        return freeSpace;
    }

    int getColumnLength() {
        return cells.length;
    }

    int getCellValue(int cell) {
        return cells[cell].getValue();
    }

	void clear() {
        for (int i = 0; i < cells.length; i++) {
            cells[i].setValue(0);
        }
	}
}