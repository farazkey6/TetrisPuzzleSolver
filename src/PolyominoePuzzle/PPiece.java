package PolyominoePuzzle;

/**
 *
 * @author Faraz
 */
public class PPiece extends Piece {

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

    public PPiece(Board board, int axisX, int axisY, String name) {

        super(board, axisX, axisY, name);
        this.board = board;

        I = new Piece(board, axisY, 1, "P");
        O = new Piece(board, 2, axisX, "P");

        this.axisY = axisX--;
        this.axisX = axisY--;
        this.name = name;
        sLimit = 3;

    }

    public void RotateRight() {

        I.RotateRight();
        O.RotateRight();
//        System.out.println("rooooootate");
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
                if (I.Plotable(x, y) && O.Plotable(x, y)) {

                    return true;
                }
                break;

            case 1:
                if (I.Plotable(x, y) && O.Plotable(x, y + 2)) {

                    return true;
                }
                break;

            case 2:
                if (I.Plotable(x, y + 2) && O.Plotable(x + 2, y)) {

                    return true;
                }
                break;

            case 3:
                if (I.Plotable(x + 2, y) && O.Plotable(x, y)) {

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
                O.Place(x, y);
                break;

            case 1:
                I.Place(x, y);
                O.Place(x, y + 2);
                break;

            case 2:
                I.Place(x, y + 2);
                O.Place(x + 2, y);
                break;

            case 3:
                I.Place(x + 2, y);
                O.Place(x, y);
                break;
        }
    }

    public void missPlace() {

        switch (state) {

            case 0:
                I.missPlace();
                O.missPlace();
                break;

            case 1:
                I.missPlace();
                O.missPlace();
                break;

            case 2:
                I.missPlace();
                O.missPlace();
                break;

            case 3:
                I.missPlace();
                O.missPlace();
                break;
        }
    }

    public int getS() {

        return state;
    }

}
