package PolyominoePuzzle;

/**
 *
 * @author Faraz
 */
public class Piece {

    Board board;
    int axisX, axisY;
    boolean placed;
    int PlaceX, PlaceY;
    int state = 0;
    int sLimit;
    String name;

    public Piece(Board board, int axisX, int axisY, String name) {

        this.board = board;
        this.axisX = axisX--;
        this.axisY = axisY--;
        this.name = name;
        sLimit = 1;
    }

    public void RotateRight() {

        int temp = axisX;
        axisX = axisY;
        axisY = temp;
        if (state == 1) {

            state = 0;
        } else {

            state = 1;
        }

//        System.out.println(name + " Rotated");
    }

    public boolean Plotable(int x, int y) {

        if (x + axisX > board.getN() || x + axisX < 0) {

            return false;
        }
        if (y + axisY > board.getN() || y + axisY < 0) {

            return false;
        }
        for (int i = 0; i < axisX; i++) {
            for (int j = 0; j < axisY; j++) {
                if (!board.isAvailable(x + i, y + j)) {

                    return false;
                }
            }
        }

        return true;
    }

    public void Place(int x, int y) {

        for (int i = 0; i < axisX; i++) {
            for (int j = 0; j < axisY; j++) {

                board.fill(name, x + i, y + j);
            }
        }

        this.PlaceX = x;
        this.PlaceY = y;
        this.placed = true;
//        board.IncS();
//        System.out.println(name + " Piece Placed at: " + PlaceX + " " + PlaceY + " With state of " + state);
    }

    public void missPlace() {

        for (int i = 0; i < axisX; i++) {
            for (int j = 0; j < axisY; j++) {

                board.empty(PlaceX + i, PlaceY + j);
            }
        }

//        System.out.println(name + " missPlaced from " + PlaceX + " " + PlaceY);
//        board.DecS();
        this.placed = false;
    }

    public int getState() {

        return state;
    }
}
