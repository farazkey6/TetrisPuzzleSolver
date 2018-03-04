package PolyominoePuzzle;

/**
 *
 * @author Faraz
 */
public class UPiece extends Piece {

    Board board;
    int axisX, axisY;
    boolean placed;
    int PlaceX, PlaceY;
    int state = 0;
    int sLimit;

    int Ix, Iy;
    int Ox, Oy;
    int Tx, Ty;

    String name;
    Piece I, O, T;

    public UPiece(Board board, int axisX, int axisY, String name) {

        super(board, axisX, axisY, name);
        this.board = board;

        I = new Piece(board, axisX, 1, "U");
        O = new Piece(board, axisX, 1, "U");
        T = new Piece(board, 1, axisY, "U");

        this.axisX = axisX--;
        this.axisY = axisY--;
        this.name = name;
        sLimit = 3;

    }

    public void RotateRight() {

        I.RotateRight();
        O.RotateRight();
        T.RotateRight();

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
                if (I.Plotable(x, y) && O.Plotable(x, y + axisY) && T.Plotable(x, y)) {

                    return true;
                }
                break;

            case 1:
                if (I.Plotable(x, y) && O.Plotable(x + axisX, y) && T.Plotable(x, y)) {

                    return true;
                }
                break;

            case 2:
                if (I.Plotable(x, y) && O.Plotable(x, y + axisY - 1) && T.Plotable(x + axisX - 1, y)) {

                    return true;
                }
                break;

            case 3:
                if (I.Plotable(x, y) && O.Plotable(x + axisX, y) && T.Plotable(x, y + axisY - 2)) {

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
                O.Place(x, y + axisY);
                T.Place(x, y);
                break;

            case 1:
                I.Place(x, y);
                O.Place(x + axisX, y);
                T.Place(x, y);
                break;

            case 2:
                I.Place(x, y);
                O.Place(x, y + axisY - 1);
                T.Place(x + axisX - 1, y);
                break;

            case 3:
                I.Place(x, y);
                O.Place(x + axisX, y);
                T.Place(x, y + axisY - 2);
                break;
        }
    }

    public void missPlace() {

        I.missPlace();
        O.missPlace();
        T.missPlace();
    }

    public int getS() {

        return state;
    }
}
