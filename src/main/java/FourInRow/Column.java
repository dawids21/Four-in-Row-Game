package FourInRow;

class Column {
    private Cell[] cells = new Cell[6];
    private int freeSpace;

    Column() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell();
        }
        freeSpace = 0;
    }

    void addOne(int player) {
        cells[freeSpace].setValue(player);
        freeSpace++;
    }

    int getFreeSpace() {
        return freeSpace;
    }
}