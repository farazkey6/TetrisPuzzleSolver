package PolyominoePuzzle;

/**
 *
 * @author Faraz
 */
public class T2Piece extends Piece {

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

    public T2Piece(Board board, int axisX, int axisY, String name) {

        super(board, axisX, axisY, name);
        this.board = board;

        I = new Piece(board, 1, axisY, "t");
        O = new Piece(board, axisX, 2, "t");

        this.axisX = axisX--;
        this.axisY = axisY--;
        this.name = name;
        sLimit = 3;

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
                if (I.Plotable(x, y) && O.Plotable(x - 2, y + 1)) {

                    return true;
                }
                break;

            case 1:
                if (I.Plotable(x, y) && O.Plotable(x + 1, y)) {

                    return true;
                }
                break;

            case 2:
                if (I.Plotable(x, y) && O.Plotable(x, y + 1)) {

                    return true;
                }
                break;

            case 3:
                if (I.Plotable(x, y + 2) && O.Plotable(x + 1, y)) {

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
                O.Place(x - 2, y + 1);
                break;

            case 1:
                I.Place(x, y);
                O.Place(x + 1, y);
                break;

            case 2:
                I.Place(x, y);
                O.Place(x , y + 1);
                break;

            case 3:
                I.Place(x, y + 2);
                O.Place(x + 1, y);
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
