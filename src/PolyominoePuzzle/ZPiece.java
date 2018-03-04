package PolyominoePuzzle;

/**
 *
 * @author Faraz
 */
public class ZPiece extends Piece {

    Board board;
    int axisX, axisY;
    boolean placed;
    int PlaceX, PlaceY;
    int state = 0;
    int sLimit;

    int Ix, Iy;
    int Ox, Oy;

    String name;
    Piece I, O;

    public ZPiece(Board board, int axisX, int axisY, String name) {

        super(board, axisX, axisY, name);
        this.board = board;

        I = new Piece(board, 2, 2, "Z");
        O = new Piece(board, 2, 2, "Z");

        this.axisX = axisX--;
        this.axisY = axisY--;
        this.name = name;
        sLimit = 1;

    }

    public void RotateRight() {

        I.RotateRight();
        O.RotateRight();

        if (state != sLimit) {

            state++;
        } else {

            state = 0;
        }
    }

    public boolean Plotable(int x, int y) {

        if (x + axisX > board.getN() || x + axisX < 0) {

            return false;
        }
        if (y + axisY > board.getN() || y + axisY < 0) {

            return false;
        }

        switch (state) {

            case 0:
                if (I.Plotable(x, y) && O.Plotable(x + 2, y + 1)) {

                    return true;
                }
                break;

            case 1:
                if (I.Plotable(x + 1, y) && O.Plotable(x, y + 2)) {

                    return true;
                }
                break;

        }

        return false;
    }

    public void Place(int x, int y) {

        switch (state) {

            case 0:
                I.Place(x, y);
                O.Place(x + 2, y + 1);
                break;

            case 1:
                I.Place(x + 1, y);
                O.Place(x, y + 2);
                break;

        }
    }

    public void missPlace() {

        I.missPlace();
        O.missPlace();
    }

    public int getS() {

        return state;
    }
}
